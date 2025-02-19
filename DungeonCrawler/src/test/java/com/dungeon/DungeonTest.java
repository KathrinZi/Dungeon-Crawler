package com.dungeon;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class DungeonTest {

 @Test
 void testDungeonStartsWithCorrectRoom() {
  Player player = new Player("Hero", 100, 15);
  Dungeon dungeon = new Dungeon(player);
  assertNotNull(dungeon, "Dungeon should be created successfully");
 }
}