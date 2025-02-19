package com.dungeon;

public abstract class LivingEntity {
    protected String name;
    protected int health;
    protected int attackPower;

    public LivingEntity(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    public void attack(LivingEntity target) {
        System.out.println(name + " attacks " + target.getName() + " for " + attackPower + " damage!");
        target.takeDamage(attackPower);
    }

    public void takeDamage(int damage) {
        health -= damage;
        System.out.println(name + " takes " + damage + " damage. Health now: " + health);
        if (health <= 0) {
            System.out.println(name + " has been defeated! ☠️");
        }
    }

    public void heal(int amount) {
        health += amount;
        System.out.println(name + " heals for " + amount + " HP. Current health: " + health);
    }

    public void increaseAttack(int amount) {
        attackPower += amount;
        System.out.println(name + "'s attack power increased to: " + attackPower);
    }

    public boolean isAlive() { return health > 0; }
    public String getName() { return name; }
}