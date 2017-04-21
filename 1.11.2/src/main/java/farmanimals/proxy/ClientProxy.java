package farmanimals.proxy;

import farmanimals.client.ModelBetterCow;
import farmanimals.client.RenderBetterCow;
import farmanimals.entity.BetterCow;
import farmanimals.init.ModItems;
import farmanimals.utils.RegistryUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
	
	public void registerModels() {
		//Entites
		RenderingRegistry.registerEntityRenderingHandler(BetterCow.class, new RenderBetterCow(Minecraft.getMinecraft().getRenderManager(), new ModelBetterCow(), 0));
		
		//Items
		RegistryUtils.registerModel(ModItems.chocolatemilk, 0, new ModelResourceLocation(ModItems.chocolatemilk.getRegistryName(), "inventory"));
		RegistryUtils.registerModel(ModItems.milk, 0, new ModelResourceLocation(ModItems.milk.getRegistryName(), "inventory"));
		RegistryUtils.registerModel(ModItems.chocolatemilkbucket, 0, new ModelResourceLocation(ModItems.chocolatemilkbucket.getRegistryName(), "inventory"));
		
		RegistryUtils.registerModel(ModItems.milkaskin, 0, new ModelResourceLocation(ModItems.milkaskin.getRegistryName(), "inventory"));
		
		//Armor Items
		RegistryUtils.registerModel(ModItems.milka_helmet, 0, new ModelResourceLocation(ModItems.milka_helmet.getRegistryName(), "inventory"));
		RegistryUtils.registerModel(ModItems.milka_chestplate, 0, new ModelResourceLocation(ModItems.milka_chestplate.getRegistryName(), "inventory"));
		RegistryUtils.registerModel(ModItems.milka_leggings, 0, new ModelResourceLocation(ModItems.milka_leggings.getRegistryName(), "inventory"));
		RegistryUtils.registerModel(ModItems.milka_boots, 0, new ModelResourceLocation(ModItems.milka_boots.getRegistryName(), "inventory"));
	}
	
}
