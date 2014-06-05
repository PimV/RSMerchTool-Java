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

    MISCELLANEOUS(0, "Miscellaneous", "Random items"),
    AMMO(1, "Ammo", "All sorts of ammunition"),
    ARROWS(2, "Arrows", "Arrows used in bows"),
    BOLTS(3, "Bolts", "Bolts used in crossbows"),
    CONSTRUCTION_MATERIALS(4, "Miscellaneous", "Random items"),
    CONSTRUCTION_PROJECTS(5, "Miscellaneous", "Random items"),
    COOKING_INGREDIENTS(6, "Miscellaneous", "Random items"),
    COSTUMES(7, "Miscellaneous", "Random items"),
    CRAFTING_MATERIALS(8, "Miscellaneous", "Random items"),
    FAMILIARS(9, "Miscellaneous", "Random items"),
    FARMING_PRODUCE(10, "Miscellaneous", "Random items"),
    FLETCHING_MATERIALS(11, "Miscellaneous", "Random items"),
    FOOD_AND_DRINK(12, "Miscellaneous", "Random items"),
    HERBLORE_MATERIALS(13, "Miscellaneous", "Random items"),
    HUNTING_EQUIPMENT(14, "Miscellaneous", "Random items"),
    HUNTING_PRODUCE(15, "Miscellaneous", "Random items"),
    JEWELLERY(16, "Miscellaneous", "Random items"),
    MAGE_ARMOUR(17, "Miscellaneous", "Random items"),
    MAGE_WEAPONS(18, "Miscellaneous", "Random items"),
    MELEE_ARMOUR_LOW(19, "Miscellaneous", "Random items"),
    MELEE_ARMOUR_MID(20, "Miscellaneous", "Random items"),
    MELEE_ARMOUR_HIGH(21, "Miscellaneous", "Random items"),
    MELEE_WEAPONS_LOW(22, "Miscellaneous", "Random items"),
    MELEE_WEAPONS_MID(23, "Miscellaneous", "Random items"),
    MELEE_WEAPONS_HIGH(24, "Miscellaneous", "Random items"),
    MINING_AND_SMITHING(25, "Miscellaneous", "Random items"),
    POTIONS(26, "Miscellaneous", "Random items"),
    PRAYER_ARMOUR(27, "Miscellaneous", "Random items"),
    PRAYER_MATERIALS(28, "Miscellaneous", "Random items"),
    RANGE_ARMOUR(29, "Miscellaneous", "Random items"),
    RANGE_WEAPONS(30, "Miscellaneous", "Random items"),
    RUNECRAFTING(31, "Miscellaneous", "Random items"),
    RUNES_SPELLS_AND_TELEPORTS(32, "Miscellaneous", "Random items"),
    SEEDS(33, "Miscellaneous", "Random items"),
    SUMMONING_SCROLLS(34, "Miscellaneous", "Random items"),
    TOOLS_AND_CONTAINERS(35, "Miscellaneous", "Random items"),
    WOODCUTTING_PRODUCT(36, "Miscellaneous", "Random items"),
    POCKET_ITEMS(37, "Pocket Items", "Random items"),;

    private final int categoryNumber;
    private final String niceName;
    private final String description;

    Category(int categoryNumber, String niceName, String description) {
        this.categoryNumber = categoryNumber;
        this.niceName = niceName;
        this.description = description;
    }

    public static final Category get(String categoryName) {
        for (Category c : Category.values()) {
            if (c.toString().equals(categoryName)) {
                return c;
            }
        }
        return null;
    }

    public final int getCategoryNumber() {
        return this.categoryNumber;
    }

    public final String getNiceName() {
        return this.niceName;
    }
    
    public final String getDescription() {
        return this.description;
    }
}
