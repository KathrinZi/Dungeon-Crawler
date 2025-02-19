package com.dungeon;

import java.util.Scanner;
import java.util.List;
import java.util.Arrays;

import static com.dungeon.LoggerUtil.logger;

public class Dungeon {
 private final Player player;
 private Room currentRoom;
 private boolean gameRunning = true;

 public Dungeon(Player player) {
 this.player = player;
 initializeDungeon();
 }

 private Room[] rooms;

 private void initializeDungeon() {
 rooms = new Room[]{
 new Room("Entrance", "A dark and eerie entrance..."),
 new Room("Hallway", "A narrow hallway with flickering torches..."),
 new Room("Armory", "An abandoned armory filled with weapons..."),
 new Room("Dark Cave", "You hear eerie sounds echoing..."),
 new Room("Library", "Ancient books line the shelves..."),
 new Room("Treasure Room", "Jewels and gold are scattered around..."),
 new Room("Dragon's Lair", "A massive golden egg lies before you...")
 };

 // Gegner
 Enemy goblin = new Enemy("Goblin", 30, 5);
 Enemy skeleton = new Enemy("Skeleton", 40, 7);
 Enemy orc = new Enemy("Orc", 50, 10);

 // Items
 Item dragonEgg = new Item("Dragon's Egg", "A mystical golden egg", 0, "Treasure");
 Item healingPotion = new Item("Healing Potion", "Restores health", 20, "Potion");
 Item sword = new Item("Sword of Destiny", "A powerful blade", 5, "Weapon");

 // Setze Gegner in jeden zweiten Raum
 rooms[1].setEnemy(goblin);
 rooms[3].setEnemy(skeleton);
 rooms[5].setEnemy(orc);

 // Setze Items in Räume
 rooms[2].setItem(sword);
 rooms[4].setItem(healingPotion);
 rooms[6].setItem(dragonEgg);

 // Räume verknüpfen
 for (int i = 0; i < rooms.length - 1; i++) {
 rooms[i].setNextRoom(rooms[i + 1]);
 }

 currentRoom = rooms[0]; // Spieler startet im ersten Raum
 }

 public void startDungeon(Scanner scanner) {
 logger.info("The adventure begins...");
 while (gameRunning) {
 enterRoom(scanner);
 }
 }

 private void enterRoom(Scanner scanner) {
 System.out.println("\n--- " + currentRoom.getName() + " ---");
 System.out.println(currentRoom.getDescription());

 // Kampf, falls Gegner vorhanden
if (currentRoom.getEnemy() != null && currentRoom.getEnemy().isAlive()) {
 System.out.println(" A wild " + currentRoom.getEnemy().getName() + " appears!");
 fight(scanner, currentRoom.getEnemy());
 }

// Item-Interaktion
 if (currentRoom.getItem() != null) {
 System.out.println(" You found an item: " + currentRoom.getItem().getName());
 System.out.println("Do you want to take it? (yes/no)");

 String choice = scanner.nextLine().trim().toLowerCase();
 if (choice.equals("yes")) {
 player.addItem(currentRoom.getItem());

 // Falls es das Drachen-Ei ist → Spiel beenden
 if (currentRoom.getItem().getName().equalsIgnoreCase("Dragon's Egg")) {
 System.out.println("\n You have collected the Dragon's Egg! The adventure is over.");
 gameRunning = false;
 return;
 }
 }
 }

 // Auswahl: Weitergehen oder bleiben
 if (currentRoom.getNextRoom() != null) {
 System.out.println("Do you want to move to the next room? (yes/no)");
 String moveChoice = scanner.nextLine().trim().toLowerCase();
if (moveChoice.equals("yes")) {
 currentRoom = currentRoom.getNextRoom();
 }
 }

 // Zeigt das Inventar, wenn gewünscht
 System.out.println("Do you want to check your inventory? (yes/no)");
 String inventoryChoice = scanner.nextLine().trim().toLowerCase();
 if (inventoryChoice.equals("yes")) {
 player.showInventory();
 }
 }

 private void fight(Scanner scanner, Enemy enemy) {
 while (enemy.isAlive() && player.isAlive()) {
 System.out.println("Do you want to attack or use an item? (attack/item)");
 String action = scanner.nextLine().trim().toLowerCase();

 if (action.equals("attack")) {
 player.attack(enemy);
 if (enemy.isAlive()) {
 enemy.attack(player);
 }
 } else if (action.equals("item")) {
 System.out.println("Enter the item name:");
 String itemName = scanner.nextLine().trim();
 player.useItem(itemName);
 } else {
 System.out.println("Invalid choice!");
 }
 }

 if (!player.isAlive()) {
 System.out.println(" You have died! Game over.");
 gameRunning = false;
 }
 }
}
