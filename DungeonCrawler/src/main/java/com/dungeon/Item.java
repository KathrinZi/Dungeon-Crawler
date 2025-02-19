package com.dungeon;

public class Item {
 private String name;
 private String description;
 private int effect;
 private String type;

 public Item(String name, String description, int effect, String type) {
 this.name = name;
 this.description = description;
 this.effect = effect;
 this.type = type;
 }

 public String getName() { return name; }
 public String getDescription() { return description; }
 public int getEffect() { return effect; }
 public String getType() { return type; }

 public void useItem(Player player) {
 if (type.equals("Potion")) {
 player.heal(effect);
 System.out.println(" You used a " + name + " and restored " + effect + " health!");
 } else if (type.equals("Weapon")) {
 player.increaseAttack(effect);
 System.out.println(" You equipped " + name + " and gained +" + effect + " attack power!");
 } else if (type.equals("Treasure")) {
 System.out.println(" You collected the " + name + "! This is a legendary item.");
 }
 }
}
