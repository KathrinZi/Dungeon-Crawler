package com.dungeon;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Game {
 private static final Logger logger = LogManager.getLogger(Game.class);

 public static void main(String[] args) {
  logger.info("Game started!");
  Scanner scanner = new Scanner(System.in);

  System.out.println("🎮 Welcome to the Dungeon!");
  System.out.println("Are you a new adventurer? (yes/no)");
  if ("yes".equals(scanner.nextLine().toLowerCase())) {
   System.out.println("Brave adventurer, your journey begins! ⚔️");
  } else {
   System.out.println("Welcome back, hero! 🏹");
  }

  Player player = new Player("Hero", 100, 15);
  Dungeon dungeon = new Dungeon(player);
  dungeon.startDungeon(scanner);
 }
}