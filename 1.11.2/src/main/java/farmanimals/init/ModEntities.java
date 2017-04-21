package farmanimals.init;

import farmanimals.FarmAnimals;
import farmanimals.entity.BetterCow;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class ModEntities {
	
	public void register() {
		EntityRegistry.registerModEntity(new ResourceLocation(FarmAnimals.MODID, "BetterCow"), BetterCow.class, (FarmAnimals.MODID + "." + "bettercow"), 0, FarmAnimals.instance, 80, 3, true, 0x3F3024, 0xFFFFFF);
	}

}
