package farmanimals.entity;

import javax.annotation.Nullable;

import farmanimals.init.ModConfig;
import farmanimals.init.ModItems;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BetterCow extends EntityCow {
	
    private static final DataParameter<Integer> TYPE = EntityDataManager.createKey(BetterCow.class, DataSerializers.VARINT);
    private int transTime;
	public BetterCow(World worldIn) {
		super(worldIn);
	}
	
    protected void entityInit() {
        super.entityInit();
        this.getDataManager().register(TYPE, Integer.valueOf(0));
    }
	
    public int getType() {
        return this.getDataManager().get(TYPE);
    }
    
    public void setType(int i) {
    	this.getDataManager().set(TYPE, Integer.valueOf(i));
    }
    
    public void onLivingUpdate() {
        if (!this.worldObj.isRemote) {
        	if(transTime > 0) {
        		--transTime;
        		if(transTime < 1) {
        			this.transForm();
        		}
        	}
        }
        super.onLivingUpdate();
    }
    
    public void transForm() {
    	BetterCow newEntity = new BetterCow(this.worldObj);
    	newEntity.copyLocationAndAnglesFrom(this);
    	newEntity.setType(4);
    	newEntity.setGrowingAge(this.getGrowingAge());

        this.worldObj.removeEntity(this);
        this.setDead();
        this.worldObj.spawnEntityInWorld(newEntity);
        this.worldObj.playEvent((EntityPlayer)null, 1027, new BlockPos((int)this.posX, (int)this.posY, (int)this.posZ), 0);
    }
    
    public boolean processInteract(EntityPlayer player, EnumHand hand, @Nullable ItemStack stack) {
    	
        if (!this.worldObj.isRemote && player.capabilities.isCreativeMode && stack != null && stack.getItem() == Items.STICK) {
        	this.switchType();
        	return true;
        } else if (!this.worldObj.isRemote && !player.capabilities.isCreativeMode && stack != null && stack.getItem() == Items.BUCKET && this.getType() == 4 && !this.isChild()) {
            player.playSound(SoundEvents.ENTITY_COW_MILK, 1.0F, 1.0F);
            if (--stack.stackSize == 0) {
                player.setHeldItem(hand, new ItemStack(ModItems.chocolateMilkBucket));
            } else if (!player.inventory.addItemStackToInventory(new ItemStack(ModItems.chocolateMilkBucket))) {
                player.dropItem(new ItemStack(ModItems.chocolateMilkBucket), false);
            }
        	return true;
        } else if(!this.worldObj.isRemote && stack != null && this.isPotionActive(MobEffects.SPEED) &&  stack.getItem() == Items.COOKIE && this.getType() != 4 && this.transTime == 0) {
        	this.transTime = ModConfig.milkaTransTime;
        	--stack.stackSize;
        	return true;
    	} else {
            return super.processInteract(player, hand, stack);
        }
    }
    
    public void switchType() {  	
    	int i = this.getType();
    	if(i < 4) {
    		i++;
    	} else {
    		i = 0;
    	}
    	BetterCow entity = new BetterCow(this.worldObj);
    	entity.copyLocationAndAnglesFrom(this);
    	entity.setGrowingAge(this.getGrowingAge());
    	entity.setType(i);
        this.setDead();        
        this.worldObj.spawnEntityInWorld(entity);
    }
    
    @Override
    public void writeEntityToNBT(NBTTagCompound compound) {
        super.writeEntityToNBT(compound);
        compound.setInteger("type", this.getDataManager().get(TYPE));
        if(this.transTime > 0) {
            compound.setInteger("trans", this.transTime);
        }
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound compound) {
        super.readEntityFromNBT(compound);
        this.getDataManager().set(TYPE, compound.getInteger("type"));
        this.transTime = compound.getInteger("trans");
    }
    
    public BetterCow createChildwithVariants(BetterCow cow, int variants, int mutationRate) {
    	BetterCow newCow = new BetterCow(this.worldObj);
    	int type = cow.getType();
    	int otherType = rand.nextInt(variants);
    	if(type == 4 || type == otherType || rand.nextInt(mutationRate * (variants -1)) != 0) {
    		newCow.setType(type);
    	} else {
    		newCow.setType(otherType);
    	}
    	return newCow;
    }
    
    public EntityCow createChild(EntityAgeable ageable) {
        return this.createChildwithVariants((BetterCow) ageable, 4, ModConfig.cowMutationRate);
    }
    
    @Nullable
    protected ResourceLocation getLootTable() {
        return null;
    }
    
    protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
        int j = this.rand.nextInt(3) + 1 + this.rand.nextInt(1 + lootingModifier);
        int k;
        int t = this.getType();
        
        for (k = 0; k < j; ++k) {
            this.dropItem(t < 4 ? Items.LEATHER : ModItems.milkaSkin, 1);
        }

        for (k = 0; k < j; ++k) {
            if (this.isBurning()) {
            	this.dropItem(t < 4 ? Items.COOKED_BEEF : Items.COOKIE, 1);
            } else {
            	this.dropItem(t < 4 ? Items.BEEF : Items.COOKIE, 1);
            }
        }
    }
}