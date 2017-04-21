package farmanimals.init;

import farmanimals.item.Drinks;
import farmanimals.item.ItemModArmor;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {
	
	public static Item chocolateMilk;
	public static Item milk;
	public static Item chocolateMilkBucket;
	
	public static Item milkaSkin;
	
	public static ArmorMaterial milka;
	public static Item milka_helmet;
	public static Item milka_chestplate;
	public static Item milka_leggings;
	public static Item milka_boots;


	public void init() {
		chocolateMilk = new Drinks(2, 2, true, Items.GLASS_BOTTLE).setCreativeTab(CreativeTabs.FOOD);
		NameUtils.setNames(chocolateMilk, "chocolateMilk");
		milk = new Drinks(1, 1, true, Items.GLASS_BOTTLE).setCreativeTab(CreativeTabs.FOOD);
		NameUtils.setNames(milk, "milk");
		chocolateMilkBucket = new Drinks(2, 2, true, Items.BUCKET).setMaxStackSize(1).setContainerItem(Items.BUCKET).setCreativeTab(CreativeTabs.MISC);
		NameUtils.setNames(chocolateMilkBucket, "chocolateMilkBucket");
		
		milkaSkin = new Item().setCreativeTab(CreativeTabs.MATERIALS);
		NameUtils.setNames(milkaSkin, "milkaSkin");
		
		milka = EnumHelper.addArmorMaterial("milkaarmor", "", 8, new int[] {2, 3, 4, 2}, 21, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0);
		milka_helmet = new ItemModArmor(milka, EntityEquipmentSlot.HEAD);
		NameUtils.setNames(milka_helmet, "milka_helmet");		
		milka_chestplate = new ItemModArmor(milka, EntityEquipmentSlot.CHEST);
		NameUtils.setNames(milka_chestplate, "milka_chestplate");		
		milka_leggings = new ItemModArmor(milka, EntityEquipmentSlot.LEGS);
		NameUtils.setNames(milka_leggings, "milka_leggings");		
		milka_boots = new ItemModArmor(milka, EntityEquipmentSlot.FEET);
		NameUtils.setNames(milka_boots, "milka_boots");		
	}
	
	public void register() {
		registerItem(chocolateMilk);
		registerItem(milk);
		registerItem(chocolateMilkBucket);
		
		registerItem(milkaSkin);
		
		registerItem(milka_helmet);
		registerItem(milka_chestplate);
		registerItem(milka_leggings);
		registerItem(milka_boots);
	}
	
	private void registerItem(Item item) {
		GameRegistry.register(item);
	}

}
