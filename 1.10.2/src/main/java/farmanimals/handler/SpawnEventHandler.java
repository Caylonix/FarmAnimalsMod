package farmanimals.handler;

import farmanimals.entity.BetterCow;
import farmanimals.init.ModConfig;
import net.minecraft.entity.passive.EntityCow;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class SpawnEventHandler {
	
	@SubscribeEvent
    public void spawn(EntityJoinWorldEvent event) {
		if(!event.getWorld().isRemote && ModConfig.cowExchange && event.getEntity() instanceof EntityCow && !(event.getEntity() instanceof BetterCow)) {
			EntityCow cow = (EntityCow) event.getEntity();		        
	        BetterCow betterCow = new BetterCow(event.getWorld());        		        		
	        betterCow.setLocationAndAngles(cow.posX, cow.posY, cow.posZ, cow.rotationYaw, cow.rotationPitch);
	        betterCow.setType(ModConfig.wildCowType);
	        betterCow.setGrowingAge(cow.getGrowingAge());
    		event.getWorld().spawnEntityInWorld(betterCow);
    		cow.setDead();		
		}
	}
}
