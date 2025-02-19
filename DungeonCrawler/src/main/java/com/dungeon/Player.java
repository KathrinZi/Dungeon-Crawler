package com.dungeon;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Player extends LivingEntity {
 private List<Item> inventory;

 public Player(String name, int health, int attackPower) {
  super(name, health, attackPower);
  this.inventory = new ArrayList<>();
 }
public int getHealth(){
  return this.health;
}
 public void addItem(Item item) {
  inventory.add(item);
  System.out.println("🎒 " + item.getName() + " has been added to your inventory!");
 }

 public void useItem(String itemName) {
  List<Item> filteredItems = inventory.stream()
          .filter(item -> item.getName().equalsIgnoreCase(itemName))
          .collect(Collectors.toList());

  if (!filteredItems.isEmpty()) {
   Item item = filteredItems.get(0);
   item.useItem(this);
   inventory.remove(item);
  } else {
   System.out.println("❌ You don't have that item!");
  }
 }

 public void showInventory() {
  if (inventory.isEmpty()) {
   System.out.println("🎒 Your inventory is empty.");
  } else {
   System.out.println("🎒 Inventory:");
   inventory.forEach(item -> System.out.println(" - " + item.getName()));
  }
 }

 public int getAttackPower() {
  return 0;
 }
}