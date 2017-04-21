package farmanimals.init;

import farmanimals.item.Drinks;
import farmanimals.item.ItemModArmor;
import farmanimals.utils.RegistryUtils;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {
	
	public static Item chocolatemilk;
	public static Item milk;
	public static Item chocolatemilkbucket;
	
	public static Item milkaskin;
	
	public static ArmorMaterial milka;
	public static Item milka_helmet;
	public static Item milka_chestplate;
	public static Item milka_leggings;
	public static Item milka_boots;


	public void init() {
		chocolatemilk = new Drinks(2, 2, true, Items.GLASS_BOTTLE).setCreativeTab(CreativeTabs.FOOD);
		RegistryUtils.setItemNames(chocolatemilk, "chocolatemilk");
		milk = new Drinks(1, 1, true, Items.GLASS_BOTTLE).setCreativeTab(CreativeTabs.FOOD);
		RegistryUtils.setItemNames(milk, "milk");
		chocolatemilkbucket = new Drinks(2, 2, true, Items.BUCKET).setMaxStackSize(1).setContainerItem(Items.BUCKET).setCreativeTab(CreativeTabs.MISC);
		RegistryUtils.setItemNames(chocolatemilkbucket, "chocolatemilkbucket");
		
		milkaskin = new Item().setCreativeTab(CreativeTabs.MATERIALS);
		RegistryUtils.setItemNames(milkaskin, "milkaskin");
		
		milka = EnumHelper.addArmorMaterial("milkaarmor", "", 8, new int[] {2, 3, 4, 2}, 21, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0);
		milka_helmet = new ItemModArmor(milka, EntityEquipmentSlot.HEAD);
		RegistryUtils.setItemNames(milka_helmet, "milka_helmet");	
		milka_chestplate = new ItemModArmor(milka, EntityEquipmentSlot.CHEST);
		RegistryUtils.setItemNames(milka_chestplate, "milka_chestplate");		
		milka_leggings = new ItemModArmor(milka, EntityEquipmentSlot.LEGS);
		RegistryUtils.setItemNames(milka_leggings, "milka_leggings");	
		milka_boots = new ItemModArmor(milka, EntityEquipmentSlot.FEET);
		RegistryUtils.setItemNames(milka_boots, "milka_boots");	
	}
	
	public void register() {
		registerItem(chocolatemilk);
		registerItem(milk);
		registerItem(chocolatemilkbucket);
		
		registerItem(milkaskin);
		
		registerItem(milka_helmet);
		registerItem(milka_chestplate);
		registerItem(milka_leggings);
		registerItem(milka_boots);
	}
	
	private void registerItem(Item item) {
		GameRegistry.register(item);
	}

}
