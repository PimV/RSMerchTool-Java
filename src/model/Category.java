/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Pim
 */
public enum Category {

    MISCELLANEOUS(0),
    AMMO(1),
    ARROWS(2),
    BOLTS(3),
    CONSTRUCTION_MATERIALS(4),
    CONSTRUCTION_PROJECTS(5),
    COOKING_INGREDIENTS(6),
    COSTUMES(7),
    CRAFTING_MATERIALS(8),
    FAMILIARS(9),
    FARMING_PRODUCE(10),
    FLETCHING_MATERIALS(11),
    FOOD_AND_DRINK(12),
    HERBLORE_MATERIALS(13),
    HUNTING_EQUIPMENT(14),
    HUNTING_PRODUCE(15),
    JEWELLERY(16),
    MAGE_ARMOUR(17),
    MAGE_WEAPONS(18),
    MELEE_ARMOUR_LOW(19),
    MELEE_ARMOUR_MID(20),
    MELEE_ARMOUR_HIGH(21),
    MELEE_WEAPONS_LOW(22),
    MELEE_WEAPONS_MID(23),
    MELEE_WEAPONS_HIGH(24),
    MINING_AND_SMITHING(25),
    POTIONS(26),
    PRAYER_ARMOUR(27),
    PRAYER_MATERIALS(28),
    RANGE_ARMOUR(29),
    RANGE_WEAPONS(30),
    RUNECRAFTING(31),
    RUNES_SPELLS_AND_TELEPORTS(32),
    SEEDS(33),
    SUMMONING_SCROLLS(34),
    TOOLS_AND_CONTAINERS(35),
    WOODCUTTING_PRODUCT(36),
    POCKET_ITEMS(37);

    private final int categoryNumber;

    Category(int categoryNumber) {
        this.categoryNumber = categoryNumber;
    }
}
