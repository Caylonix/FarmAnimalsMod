package farmanimals.init;

import farmanimals.FarmAnimals;
import farmanimals.entity.BetterCow;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class ModEntities {
	
	public void register() {
		EntityRegistry.registerModEntity(BetterCow.class, "bettercow", 0, FarmAnimals.instance, 80, 3, true, 0x3F3024, 0xFFFFFF);
	}

}
