package org.ctp.enchantmentsolution.enchantments.custom;

import java.util.Arrays;
import java.util.List;

import org.bukkit.enchantments.Enchantment;
import org.ctp.enchantmentsolution.enchantments.CustomEnchantment;
import org.ctp.enchantmentsolution.enchantments.DefaultEnchantments;
import org.ctp.enchantmentsolution.enchantments.Weight;
import org.ctp.enchantmentsolution.utils.items.nms.ItemType;

public class WidthPlusPlus extends CustomEnchantment{

	public WidthPlusPlus() {
		setDefaultDisplayName("Width++");
		setDefaultFiftyConstant(0);
		setDefaultThirtyConstant(-10);
		setDefaultFiftyModifier(20);
		setDefaultThirtyModifier(20);
		setDefaultFiftyMaxConstant(40);
		setDefaultThirtyMaxConstant(35);
		setDefaultFiftyStartLevel(15);
		setDefaultThirtyStartLevel(1);
		setDefaultFiftyMaxLevel(3);
		setDefaultThirtyMaxLevel(2);
		setDefaultWeight(Weight.RARE);
		setDefaultDescription("Increase left/right break radius by 1 per level.");
	}
	
	@Override
	public Enchantment getRelativeEnchantment() {
		return DefaultEnchantments.WIDTH_PLUS_PLUS;
	}
	
	@Override
	protected List<ItemType> getEnchantmentItemTypes() {
		return Arrays.asList(ItemType.TOOLS);
	}

	@Override
	protected List<ItemType> getAnvilItemTypes() {
		return Arrays.asList(ItemType.TOOLS);
	}

	@Override
	protected List<Enchantment> getDefaultConflictingEnchantments() {
		return Arrays.asList();
	}

	@Override
	public String getName() {
		return "width_plus_plus";
	}

}
