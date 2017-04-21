package farmanimals.item;

import farmanimals.FarmAnimals;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemModArmor extends ItemArmor {

	public ItemModArmor(ArmorMaterial materialIn, EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn, 0, equipmentSlotIn);
		this.setCreativeTab(CreativeTabs.COMBAT);
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
		if(slot == EntityEquipmentSlot.HEAD || slot == EntityEquipmentSlot.CHEST || slot == EntityEquipmentSlot.FEET) {
			return FarmAnimals.MODID + ":textures/armor/milka_layer_1.png";
		} else if (slot == EntityEquipmentSlot.LEGS) {
			return FarmAnimals.MODID + ":textures/armor/milka_layer_2.png";
		} else {
			return null;
		}
	}
}
