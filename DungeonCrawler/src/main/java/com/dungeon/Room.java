package com.dungeon;

public class Room {
 private String name;
 private String description;
 private Enemy enemy;
 private Item item;
 private Room nextRoom;

 public Room(String name, String description) {
  this.name = name;
  this.description = description;
 }

 public void setNextRoom(Room nextRoom) {
  this.nextRoom = nextRoom;
 }

 public void setItem(Item item) {
  this.item = item;
 }

 public void setEnemy(Enemy enemy) {
  this.enemy = enemy;
 }

 public Room getNextRoom() { return nextRoom; }
 public String getName() { return name; }
 public String getDescription() { return description; }
 public Enemy getEnemy() { return enemy; }
 public Item getItem() { return item; }
}