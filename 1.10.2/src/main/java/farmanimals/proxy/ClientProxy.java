package farmanimals.proxy;

import farmanimals.client.ModelBetterCow;
import farmanimals.client.RenderBetterCow;
import farmanimals.entity.BetterCow;
import farmanimals.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
	
	public void registerModels() {
		//Entites
		RenderingRegistry.registerEntityRenderingHandler(BetterCow.class, new RenderBetterCow(Minecraft.getMinecraft().getRenderManager(), new ModelBetterCow(), 0));
		
		//Items
		registerModel(ModItems.chocolateMilk, 0, new ModelResourceLocation(ModItems.chocolateMilk.getRegistryName(), "inventory"));
		registerModel(ModItems.milk, 0, new ModelResourceLocation(ModItems.milk.getRegistryName(), "inventory"));
		registerModel(ModItems.chocolateMilkBucket, 0, new ModelResourceLocation(ModItems.chocolateMilkBucket.getRegistryName(), "inventory"));
		
		registerModel(ModItems.milkaSkin, 0, new ModelResourceLocation(ModItems.milkaSkin.getRegistryName(), "inventory"));
		
		//Armor Items
		registerModel(ModItems.milka_helmet, 0, new ModelResourceLocation(ModItems.milka_helmet.getRegistryName(), "inventory"));
		registerModel(ModItems.milka_chestplate, 0, new ModelResourceLocation(ModItems.milka_chestplate.getRegistryName(), "inventory"));
		registerModel(ModItems.milka_leggings, 0, new ModelResourceLocation(ModItems.milka_leggings.getRegistryName(), "inventory"));
		registerModel(ModItems.milka_boots, 0, new ModelResourceLocation(ModItems.milka_boots.getRegistryName(), "inventory"));
	}
	
	private void registerModel(Object obj, int meta, ModelResourceLocation loc) {
		Item item = null;
		if(obj instanceof Item) {
			item = (Item) obj;
		} else if(obj instanceof Block) {
			item = Item.getItemFromBlock((Block)obj); 
		} else {
			throw new IllegalArgumentException();
		}
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta, loc);			
	}
}
