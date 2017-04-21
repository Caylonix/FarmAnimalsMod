package farmanimals.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Drinks extends ItemFood {

	public int healAmount;
	public float saturation;
	public boolean curePotionEffects;
	public Item returnItem;
	
	public Drinks(int healAmount, float saturation, boolean curePotionEffects, Item returnItem) {
		super(healAmount, saturation, false);
		this.setAlwaysEdible();
		this.returnItem = returnItem;
		this.healAmount = healAmount;
		this.saturation = saturation;
		this.curePotionEffects = curePotionEffects;
	}
	
    public EnumAction getItemUseAction(ItemStack stack) {
        return EnumAction.DRINK;
    }
    
	@Override
	protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
		super.onFoodEaten(stack, world, player);
		player.inventory.addItemStackToInventory(new ItemStack(this.returnItem));
		if(this.curePotionEffects) {
			player.curePotionEffects(new ItemStack(Items.MILK_BUCKET));
		}
	}

    public int getMaxItemUseDuration(ItemStack stack) {
        return 32;
    }
}
