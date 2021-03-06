package org.ctp.enchantmentsolution.listeners.abilities;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.ctp.enchantmentsolution.enchantments.DefaultEnchantments;
import org.ctp.enchantmentsolution.enchantments.Enchantments;

public class ExpShareListener extends EnchantmentListener{

	@EventHandler
	public void onEntityDeath(EntityDeathEvent event){
		if(!canRun(DefaultEnchantments.EXP_SHARE, event)) return;
		if(event.getEntity() instanceof Player){
			return;
		}
		Entity killer = event.getEntity().getKiller();
		if(killer instanceof Player){
			Player player = (Player) killer;
			ItemStack killItem = player.getInventory().getItemInMainHand();
			if(killItem != null && Enchantments.hasEnchantment(killItem, DefaultEnchantments.EXP_SHARE)){
				int exp = event.getDroppedExp();
				if(exp > 0){
					int totalExp = exp;
					int level = Enchantments.getLevel(killItem, DefaultEnchantments.EXP_SHARE);
					for(int i = 0; i < exp * level; i++){
						double chance = (.50);
						double random = Math.random();
						if(chance > random){
							totalExp++;
						}
					}
					event.setDroppedExp(totalExp);
				}
			}
		}
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event){
		if(!canRun(DefaultEnchantments.EXP_SHARE, event)) return;
		Player player = event.getPlayer();
		ItemStack killItem = player.getInventory().getItemInMainHand();
		if(killItem != null && Enchantments.hasEnchantment(killItem, DefaultEnchantments.EXP_SHARE)){
			int exp = event.getExpToDrop();
			if(exp > 0){
				int totalExp = exp;
				int level = Enchantments.getLevel(killItem, DefaultEnchantments.EXP_SHARE);
				for(int i = 0; i < exp * level; i++){
					double chance = .50;
					double random = Math.random();
					if(chance > random){
						totalExp++;
					}
				}
				event.setExpToDrop(totalExp);
			}
		}
	}
}
