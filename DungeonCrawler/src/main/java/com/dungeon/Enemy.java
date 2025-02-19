package com.dungeon;

public class Enemy extends LivingEntity {
 public Enemy(String name, int health, int attackPower) {
  super(name, health, attackPower);
 }

 public int getHealth() {
  return 0;
 }
}