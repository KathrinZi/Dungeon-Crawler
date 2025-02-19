package com.dungeon;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ItemTest {

 @Test
 void testHealingPotionRestoresHealth() {
 Player player = new Player("Hero", 50, 15);
 Item healingPotion = new Item("Healing Potion", "Restores health", 20, "Potion");
 healingPotion.useItem(player);
 assertEquals(70, player.getHealth(), "Healing potion should restore health");
 }

 @Test
 void testWeaponIncreasesAttack() {
 Player player = new Player("Hero", 100, 10);
 Item sword = new Item("Sword", "A strong blade", 5, "Weapon");
 sword.useItem(player);
 assertEquals(15, player.getAttackPower(), "Weapon should increase attack power");
 }
}
