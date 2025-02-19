package com.dungeon;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RoomTest {

    @Test
    void testRoomLinksToNextRoom() {
        Room entrance = new Room("Entrance", "Dark and eerie");
        Room hallway = new Room("Hallway", "Narrow and creepy");
        entrance.setNextRoom(hallway);

        assertEquals(hallway, entrance.getNextRoom(), "Entrance should link to hallway");
    }

    @Test
    void testRoomCanHoldItems() {
        Room treasureRoom = new Room("Treasure Room", "Full of gold");
        Item treasure = new Item("Gold Coin", "A shiny gold coin", 0, "Treasure");
        treasureRoom.setItem(treasure);

        assertNotNull(treasureRoom.getItem(), "Room should contain an item");
        assertEquals("Gold Coin", treasureRoom.getItem().getName(), "Item should be a Gold Coin");
    }
}