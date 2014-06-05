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
    CONSTRUCTION_MATERIALS(4, "Construction materials", "Random items"),
    CONSTRUCTION_PROJECTS(5, "Construction projects", "Random items"),
    COOKING_INGREDIENTS(6, "Cooking inredients", "Random items"),
    COSTUMES(7, "Costumes", "Random items"),
    CRAFTING_MATERIALS(8, "Crafting materials", "Random items"),
    FAMILIARS(9, "Familiars", "Random items"),
    FARMING_PRODUCE(10, "Farming produce", "Random items"),
    FLETCHING_MATERIALS(11, "Fletching materials", "Random items"),
    FOOD_AND_DRINK(12, "Food and drink", "Random items"),
    HERBLORE_MATERIALS(13, "Herblore materials", "Random items"),
    HUNTING_EQUIPMENT(14, "Hunting equipment", "Random items"),
    HUNTING_PRODUCE(15, "Hunting produce", "Random items"),
    JEWELLERY(16, "Jewellery", "Random items"),
    MAGE_ARMOUR(17, "Mage armour", "Random items"),
    MAGE_WEAPONS(18, "Mage weapons", "Random items"),
    MELEE_ARMOUR_LOW(19, "Melee armour - low level", "Random items"),
    MELEE_ARMOUR_MID(20, "Melee armour - mid level", "Random items"),
    MELEE_ARMOUR_HIGH(21, "Melee armour - high level", "Random items"),
    MELEE_WEAPONS_LOW(22, "Melee weapons - low level", "Random items"),
    MELEE_WEAPONS_MID(23, "Melee weapons - mid level", "Random items"),
    MELEE_WEAPONS_HIGH(24, "Melee weapons - high level", "Random items"),
    MINING_AND_SMITHING(25, "Mining and smithing", "Random items"),
    POTIONS(26, "Potions", "Random items"),
    PRAYER_ARMOUR(27, "Prayer armour", "Random items"),
    PRAYER_MATERIALS(28, "Prayer materials", "Random items"),
    RANGE_ARMOUR(29, "Range armour", "Random items"),
    RANGE_WEAPONS(30, "Range weapons", "Random items"),
    RUNECRAFTING(31, "Runecrafting", "Random items"),
    RUNES_SPELLS_AND_TELEPORTS(32, "Runes, Spells and Teleports", "Random items"),
    SEEDS(33, "Seeds", "Random items"),
    SUMMONING_SCROLLS(34, "Summoning scrolls", "Random items"),
    TOOLS_AND_CONTAINERS(35, "Tools and containers", "Random items"),
    WOODCUTTING_PRODUCT(36, "Woodcutting product", "Random items"),
    POCKET_ITEMS(37, "Pocket items", "Random items"),;

    private final int categoryNumber;
    private final String niceName;
    private final String description;

    Category(int categoryNumber, String niceName, String description) {
        this.categoryNumber = categoryNumber;
        this.niceName = niceName;
        this.description = description;
    }

    public static final Category getByName(String categoryName) {
        for (Category c : Category.values()) {
            if (c.toString().equals(categoryName)) {
                return c;
            }
        }
        return null;
    }

    public static final Category getByNiceName(String niceName) {
        for (Category c : Category.values()) {
            if (c.getNiceName().equals(niceName)) {
                return c;
            }
        }
        return null;
    }

    public static final Category getByNumber(int number) {
        for (Category c : Category.values()) {
            if (c.getCategoryNumber() == number) {
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
