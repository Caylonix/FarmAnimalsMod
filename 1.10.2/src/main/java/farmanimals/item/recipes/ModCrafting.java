package farmanimals.item.recipes;

import farmanimals.init.ModItems;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModCrafting {
	
	public void register() {
    	GameRegistry.addShapelessRecipe(new ItemStack(ModItems.milk), Items.MILK_BUCKET, Items.GLASS_BOTTLE);
    	GameRegistry.addShapelessRecipe(new ItemStack(ModItems.chocolateMilk), ModItems.milk, new ItemStack(Items.DYE, 1, 3));
    	GameRegistry.addShapelessRecipe(new ItemStack(ModItems.chocolateMilk), ModItems.chocolateMilkBucket, Items.GLASS_BOTTLE);
    	
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.milka_helmet, 1), new Object[] {
				"xxx",
				"x x", 'x', new ItemStack(ModItems.milkaSkin)
		});
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.milka_chestplate, 1), new Object[] {
				"x x",
				"xxx",
				"xxx", 'x', new ItemStack(ModItems.milkaSkin)
		});
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.milka_leggings, 1), new Object[] {
				"xxx",
				"x x",
				"x x", 'x', new ItemStack(ModItems.milkaSkin)
		});
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.milka_boots, 1), new Object[] {
				"x x",
				"x x", 'x', new ItemStack(ModItems.milkaSkin)
		});
	}
}	
