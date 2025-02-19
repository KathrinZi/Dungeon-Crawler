package com.dungeon;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

 @Test
 void testPlayerTakesDamage() {
  Player player = new Player("Hero", 100, 15);
  player.takeDamage(30);
  assertEquals(70, player.getHealth(), "Player health should decrease after taking damage");
 }

 @Test
 void testPlayerHealing() {
  Player player = new Player("Hero", 50, 15);
  player.heal(20);
  assertEquals(70, player.getHealth(), "Player health should increase after healing");
 }

 @Test
 void testPlayerCannotOverheal() {
  Player player = new Player("Hero", 90, 15);
  player.heal(20);
  assertEquals(100, player.getHealth(), "Player health should not exceed max health");
 }
}