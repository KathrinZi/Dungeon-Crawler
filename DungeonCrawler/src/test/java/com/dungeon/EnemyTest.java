package com.dungeon;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EnemyTest {

    @Test
    void testEnemyTakesDamage() {
        Enemy enemy = new Enemy("Goblin", 40, 5);
        enemy.takeDamage(20);
        assertEquals(20, enemy.getHealth(), "Enemy health should decrease after taking damage");
    }

    @Test
    void testEnemyDiesWhenHealthIsZero() {
        Enemy enemy = new Enemy("Goblin", 10, 5);
        enemy.takeDamage(10);
        assertFalse(enemy.isAlive(), "Enemy should be dead when health reaches 0");
    }
}