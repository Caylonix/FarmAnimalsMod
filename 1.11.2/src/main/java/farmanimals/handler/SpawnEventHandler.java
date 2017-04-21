package farmanimals.handler;

import farmanimals.entity.BetterCow;
import farmanimals.init.ModConfigs;
import net.minecraft.entity.passive.EntityCow;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class SpawnEventHandler {
	
	@SubscribeEvent
    public void spawn(EntityJoinWorldEvent event) {
		if(!event.getWorld().isRemote && ModConfigs.cowExchange && event.getEntity() instanceof EntityCow && !(event.getEntity() instanceof BetterCow)) {
			EntityCow cow = (EntityCow) event.getEntity();		        
	        BetterCow betterCow = new BetterCow(event.getWorld());        		        		
	        betterCow.setLocationAndAngles(cow.posX, cow.posY, cow.posZ, cow.rotationYaw, cow.rotationPitch);
	        betterCow.setType(ModConfigs.wildCowType);
	        betterCow.setGrowingAge(cow.getGrowingAge());
    		event.getWorld().spawnEntity(betterCow);
    		cow.setDead();		
		}
	}
}
