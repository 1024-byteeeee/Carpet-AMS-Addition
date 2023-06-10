package club.mcams.carpet;

import club.mcams.carpet.util.recipes.CraftingRule;
import static club.mcams.carpet.settings.AmsRuleCategory.*;
//#if MC<11900
import carpet.settings.Rule;
//#else
//$$ import carpet.api.settings.Rule;
//#endif

/**
 * Here is your example Settings class you can plug to use carpetmod /carpet settings command
 */

public class AmsServerSettings {

    @Rule(
            //#if MC<11900
            desc = "Enabling making super bows with both infinite and mending enchants",
            category = {AMS, FEATURE}
            //#else
            //$$ categories = {AMS, FEATURE}
            //#endif
    )
    public static boolean superBow = false;

    @Rule(
            //#if MC<11900
            desc = "Make cactus accepts scheduled tick as random tick",
            category = {AMS, FEATURE, SURVIVAL}
            //#else
            //$$ categories = {AMS, FEATURE, SURVIVAL}
            //#endif
    )
    public static boolean scheduledRandomTickCactus = false;

    @Rule(
            //#if MC<11900
            desc = "Make bamboo accepts scheduled tick as random tick",
            category = {AMS, FEATURE, SURVIVAL}
            //#else
            //$$ categories = {AMS, FEATURE, SURVIVAL}
            //#endif
    )
    public static boolean scheduledRandomTickBamboo = false;

    @Rule(
            //#if MC<11900
            desc = "Make chorus flower accepts scheduled tick as random tick",
            category = {AMS, FEATURE, SURVIVAL}
            //#else
            //$$ categories = {AMS, FEATURE, SURVIVAL}
            //#endif
    )
    public static boolean scheduledRandomTickChorusFlower = false;

    @Rule(
            //#if MC<11900
            desc = "Make sugar cane accepts scheduled tick as random tick",
            category = {AMS, FEATURE, SURVIVAL}
            //#else
            //$$ categories = {AMS, FEATURE, SURVIVAL}
            //#endif
    )
    public static boolean scheduledRandomTickSugarCane = false;

    @Rule(
            //#if MC<11900
            desc = "Make stems accepts scheduled tick as random tick",
            category = {AMS, FEATURE, SURVIVAL}
            //#else
            //$$ categories = {AMS, FEATURE, SURVIVAL}
            //#endif
    )
    public static boolean scheduledRandomTickStem = false;

    @Rule(
            //#if MC<11900
            desc = "Make all plants accepts scheduled tick as random tick",
            category = {AMS, FEATURE, SURVIVAL}
            //#else
            //$$ categories = {AMS, FEATURE, SURVIVAL}
            //#endif
    )
    public static boolean scheduledRandomTickAllPlants = false;

    @Rule(
            //#if MC<11900
            desc = "Optimize dragon respawning",
            category = {AMS, OPTIMIZATION}
            //#else
            //$$ categories = {AMS, OPTIMIZATION}
            //#endif
    )
    public static boolean optimizedDragonRespawn = false;

    @Rule(
            options = {"bone_block", "wither_skeleton_skull", "note_block", "OFF"},
            //#if MC<11900
            desc = "Load nearby 3x3 chunks for 15 seconds when a note block is triggered",
            extra = {
                    "[bone_block] - When bone_block is on the note_block",
                    "[wither_skeleton_skull] - When wither_skeleton_skull is on the note_block, either placed on the note block or hanging on the wall",
                    "[note_block] - Only note_block",
                    "[OFF] - Disable the rule"
            },
            category = {AMS, FEATURE, AMS_CHUNKLOADER}
            //#else
            //$$ categories = {AMS, FEATURE, AMS_CHUNKLOADER}
            //#endif
    )
    public static String noteBlockChunkLoader = "OFF";

    @Rule(
            options = {"bone_block", "bedrock", "all", "OFF"},
            //#if MC<11900
            desc = "Load nearby 3x3 chunks for 15 seconds when a piston is triggered",
            extra = {
                    "[bone_block] - When bone_block is on the piston",
                    "[bedrock] - When bedrock is under the piston",
                    "[all] - When boe_block is on the piston or bed rock is under the piston",
                    "[OFF] - Disable the rule"
            },
            category = {AMS, FEATURE, AMS_CHUNKLOADER}
            //#else
            //$$ categories = {AMS, FEATURE, AMS_CHUNKLOADER}
            //#endif
    )
    public static String pistonBlockChunkLoader = "OFF";

    @Rule(
            //#if MC<11900
            desc = "Load nearby 3x3 chunks for 15 seconds when a bell is triggered",
            category = {AMS, FEATURE, AMS_CHUNKLOADER}
            //#else
            //$$ categories = {AMS, FEATURE, AMS_CHUNKLOADER}
            //#endif
    )
    public static boolean bellBlockChunkLoader = false;

    @Rule(
            //#if MC<11900
            desc = "Control chunk loading for players at any gamemodes",
            category = {AMS, COMMAND, AMS_CHUNKLOADER}
            //#else
            //$$ categories = {AMS, FEATURE, AMS_CHUNKLOADER}
            //#endif
    )
    public static String commandChunkLoading = "false";

    @Rule(
            //#if MC<11900
            desc = "Players can use water buckets to place water in nether",
            category = {AMS, FEATURE}
            //#else
            //$$ categories = {AMS, FEATURE}
            //#endif
    )
    public static boolean netherWaterPlacement = false;

    //#if MC>=11700
    @Rule(
            //#if MC<11900
            desc = "Change the hardness of deepslate to stone",
            category = {AMS, FEATURE, SURVIVAL}
            //#else
            //$$ categories = {AMS, FEATURE, SURVIVAL}
            //#endif
    )
    public static boolean softDeepslate = false;
    //#endif

    @Rule(
            //#if MC<11900
            desc = "Change the hardness of obsdian to deepslate",
            category = {AMS, FEATURE, SURVIVAL}
            //#else
            //$$ categories = {AMS, FEATURE, SURVIVAL}
            //#endif
    )
    public static boolean softObsidian = false;

    @Rule(
            //#if MC<11900
            desc = "Set all blocks BlastResistance to 0",
            category = {AMS, FEATURE, SURVIVAL, TNT}
            //#else
            //$$ categories = {AMS, FEATURE, SURVIVAL, TNT}
            //#endif
    )
    public static boolean blowUpEverything = false;

    @Rule(
            //#if MC<11900
            desc = "Share villagers discount to all players",
            category = {AMS, FEATURE, SURVIVAL}
            //#else
            //$$ categories = {AMS, FEATURE, SURVIVAL}
            //#endif
    )
    public static boolean sharedVillagerDiscounts = false;

    @Rule(
            //#if MC<11900
            desc = "Simulation fake Peace",
            category = {AMS, FEATURE}
            //#else
            //$$ categories = {AMS, FEATURE}
            //#endif
    )
    public static boolean fakePeace = false;

    @Rule(
            //#if MC<11900
            desc = "The campfire is extinguished when the player places it",
            category = {AMS, FEATURE, SURVIVAL}
            //#else
            //$$ categories = {AMS, FEATURE, SURVIVAL}
            //#endif
    )
    public static boolean extinguishedCampfire = false;

    @Rule(
            //#if MC<11900
            desc = "players don't get hurt by flying into walls",
            category = {AMS, FEATURE, SURVIVAL}
            //#else
            //$$ categories = {AMS, FEATURE, SURVIVAL}
            //#endif
    )
    public static boolean safeFlight = false;

    //#if MC<11900
    @Rule(
            desc = "Let the bone_block be update suppressor",
            category = {AMS, FEATURE}
    )
    public static boolean boneBlockUpdateSuppressor = false;
    //#endif

    @Rule(
            //#if MC<11900
            desc = "Explosion can destroy obsidian",
            category = {AMS, FEATURE, SURVIVAL, TNT}
            //#else
            //$$ categories = {AMS, FEATURE, SURVIVAL, TNT}
            //#endif
    )
    public static boolean weakObsidian = false;

    @Rule(
            //#if MC<11900
            desc = "Explosion can destroy crying_obsidian",
            category = {AMS, FEATURE, SURVIVAL, TNT}
            //#else
            //$$ categories = {AMS, FEATURE, SURVIVAL, TNT}
            //#endif
    )
    public static boolean weakCryingObsidian = false;

    //#if MC>11800
    //$$    @Rule(categories = {AMS, FEATURE, SURVIVAL, TNT})
    //$$    public static boolean weakReinforcedDeepslate = false;
    //#endif

    @Rule(
            //#if MC<11900
            desc = "Explosion can destroy bedrock",
            category = {AMS, FEATURE, SURVIVAL, TNT}
            //#else
            //$$ categories = {AMS, FEATURE, SURVIVAL, TNT}
            //#endif
    )
    public static boolean weakBedRock = false;

    @Rule(
            //#if MC<11900
            desc = "Explosion can destroy all blocks except anvil and bedrock",
            category = {AMS, FEATURE, SURVIVAL, TNT}
            //#else
            //$$ categories = {AMS, FEATURE, SURVIVAL, TNT}
            //#endif
    )
    public static boolean enhancedWorldEater = false;

    @Rule(
            //#if MC<11900
            desc = "This rule prevents villager trades from locking up",
            category = {AMS, FEATURE, SURVIVAL}
            //#else
            //$$ categories = {AMS, FEATURE, SURVIVAL}
            //#endif
    )
    public static boolean infiniteTrades = false;

    @Rule(
            //#if MC<11900
            desc = "Players will be invulnerable",
            category = {AMS, FEATURE}
            //#else
            //$$ categories = {AMS, FEATURE}
            //#endif
    )
    public static boolean invulnerable = false;

    @Rule(
            //#if MC<11900
            desc = "Allows players in Creative mode to kill entities in one hit\n" +
                    "If the player is sneaking, other entities around the target get killed too",
            category = {AMS, FEATURE, CREATIVE}
            //#else
            //$$ categories = {AMS, FEATURE, CREATIVE}
            //#endif
    )
    public static boolean creativeOneHitKill = false;

    @Rule(
            //#if MC<11900
            desc = "Doubles the size of your EnderChest",
            category = {AMS, FEATURE, SURVIVAL}
            //#else
            //$$ categories = {AMS, FEATURE, SURVIVAL}
            //#endif
    )
    public static boolean largeEnderChest = false;

    @Rule(
            //#if MC<11900
            desc = "The block model of bamboo will not generate offset",
            category = {AMS, FEATURE, OPTIMIZATION}
            //#else
            //$$ categories = {AMS, FEATURE, OPTIMIZATION}
            //#endif
    )
    public static boolean bambooModelNoOffset = false;

    @Rule(
            //#if MC<11900
            desc = "Allow players to pass through bamboo",
            category = {AMS, FEATURE}
            //#else
            //$$ categories = {AMS, FEATURE}
            //#endif
    )
    public static boolean bambooCollisionBoxDisabled = false;

    @Rule(
            //#if MC<11900
            desc = "Disable campfire smoke particles",
            category = {AMS, FEATURE}
            //#else
            //$$ categories = {AMS, FEATURE}
            //#endif
    )
    public static boolean campfireSmokeParticleDisabled = false;

    @Rule(
            //#if MC<11900
            desc = "Totem will not be destroyed by flames and magma",
            category = {AMS, FEATURE}
            //#else
            //$$ categories = {AMS, FEATURE}
            //#endif
    )
    public static boolean antiFireTotem = false;

    @Rule(
            //#if MC<11900
            desc = "Dropped items will not be destroyed by explosions",
            category = {AMS, FEATURE, TNT}
            //#else
            //$$ categories = {AMS, FEATURE}
            //#endif
    )
    public static boolean itemAntiExplosion = false;

    /**
     * 可移动方块规则
     */
    @Rule(
            //#if MC<11900
            desc = "Makes ender_chests movable",
            category = {AMS, FEATURE, AMS_MOVABLE}
            //#else
            //$$ categories = {AMS, FEATURE, AMS_MOVABLE}
            //#endif
    )
    public static boolean movableEnderChest = false;

    @Rule(
            //#if MC<11900
            desc = "Makes end_portal_frame movable",
            category = {AMS, FEATURE, AMS_MOVABLE}
            //#else
            //$$ categories = {AMS, FEATURE, AMS_MOVABLE}
            //#endif
    )
    public static boolean movableEndPortalFrame = false;

    @Rule(
            //#if MC<11900
            desc = "Makes obsidian movable",
            category = {AMS, FEATURE, AMS_MOVABLE}
            //#else
            //$$ categories = {AMS, FEATURE, AMS_MOVABLE}
            //#endif
    )
    public static boolean movableObsidian = false;

    @Rule(
            //#if MC<11900
            desc = "Makes crying_obsidian movable",
            category = {AMS, FEATURE, AMS_MOVABLE}
            //#else
            //$$ categories = {AMS, FEATURE, AMS_MOVABLE}
            //#endif
    )
    public static boolean movableCryingObsidian = false;

    @Rule(
            //#if MC<11900
            desc = "Makes bedrock movable",
            category = {AMS, FEATURE, AMS_MOVABLE}
            //#else
            //$$ categories = {AMS, FEATURE, AMS_MOVABLE}
            //#endif
    )
    public static boolean movableBedRock = false;

    @Rule(
            //#if MC<11900
            desc = "Makes enchanting_table movable",
            category = {AMS, FEATURE, AMS_MOVABLE}
            //#else
            //$$ categories = {AMS, FEATURE, AMS_MOVABLE}
            //#endif
    )
    public static boolean movableEnchantingTable = false;

    @Rule(
            //#if MC<11900
            desc = "Makes beacon movable",
            category = {AMS, FEATURE, AMS_MOVABLE}
            //#else
            //$$ categories = {AMS, FEATURE, AMS_MOVABLE}
            //#endif
    )
    public static boolean movableBeacon = false;

    //#if MC>=11900
    //$$ @Rule(categories = {AMS, FEATURE, AMS_MOVABLE})
    //$$ public static boolean movableReinforcedDeepslate = false;
    //#endif

    //#if MC>=11900
    //$$ @Rule(categories = {AMS, FEATURE, AMS_MOVABLE})
    //$$ public static boolean movableSculkCatalyst = false;
    //#endif

    //#if MC>=11900
    //$$ @Rule(categories = {AMS, FEATURE, AMS_MOVABLE})
    //$$ public static boolean movableSculkSensor = false;
    //#endif

    //#if MC>=11900
    //$$ @Rule(categories = {AMS, FEATURE, AMS_MOVABLE})
    //$$ public static boolean movableSculkShrieker = false;
    //#endif

    @Rule(
            //#if MC<11900
            desc = "Makes anvil movable",
            category = {AMS, FEATURE, AMS_MOVABLE}
            //#else
            //$$ categories = {AMS, FEATURE, AMS_MOVABLE}
            //#endif
    )
    public static boolean movableAnvil = false;

    /**
     * 合成表规则
     */
    @SuppressWarnings("unused")
    @CraftingRule(recipes = "enchanted_golden_apples.json")
    @Rule(
            //#if MC<11900
            desc = "Enchanted Golden Apples can be crafted with 8 Gold Blocks again",
            category = {CRAFTING, SURVIVAL, AMS}
            //#else
            //$$ categories = {CRAFTING, SURVIVAL, AMS}
            //#endif
    )
    public static boolean craftableEnchantedGoldenApples = false;

    //#if MC>=11700
    @SuppressWarnings("unused")
    @CraftingRule(recipes = "bundle.json")
    @Rule(
            //#if MC<11900
            desc = "Crafted bundle in minecraft 1.17/1.18/1.19",
            category = {CRAFTING, SURVIVAL, AMS}
            //#else
            //$$ categories = {CRAFTING, SURVIVAL, AMS}
            //#endif
    )
    public static boolean craftableBundle = false;
    //#endif

    //#if MC<11900 && MC>=11700
    @SuppressWarnings("unused")
    @CraftingRule(recipes = "sculk_sensor.json")
    @Rule(
            //#if MC<11900
            desc = "Crafted sculk_sensor in minecraft 1.17/1.18",
            category = {CRAFTING, SURVIVAL, AMS}
            //#else
            //$$ categories = {CRAFTING, SURVIVAL, AMS}
            //#endif
    )
    public static boolean craftableSculkSensor = false;
    //#endif

    @SuppressWarnings("unused")
    @CraftingRule(recipes = "bone_block.json")
    @Rule(
            //#if MC<11900
            desc = "Use nine bones to crafted three bone_blocks",
            category = {CRAFTING, SURVIVAL, AMS}
            //#else
            //$$ categories = {CRAFTING, SURVIVAL, AMS}
            //#endif
    )
    public static boolean betterCraftableBoneBlock = false;

    @SuppressWarnings("unused")
    @CraftingRule(recipes = "elytra.json")
    @Rule(
            //#if MC<11900
            desc = "Crafted elytra in minecraft",
            category = {CRAFTING, SURVIVAL, AMS}
            //#else
            //$$ categories = {CRAFTING, SURVIVAL, AMS}
            //#endif
    )
    public static boolean craftableElytra = false;

    @SuppressWarnings("unused")
    @CraftingRule(recipes = {"dispenser1.json", "dispenser2.json"})
    @Rule(
            //#if MC<11900
            desc = "Better craftable dispenser",
            category = {CRAFTING, SURVIVAL, AMS}
            //#else
            //$$ categories = {CRAFTING, SURVIVAL, AMS}
            //#endif
    )
    public static boolean betterCraftableDispenser = false;

    //#if MC>=11700
    @SuppressWarnings("unused")
    @CraftingRule(recipes = "polished_blackstone_button.json")
    @Rule(
            //#if MC<11900
            desc = "Use deepslate to crafted polished_blackstone_button in minecraft",
            category = {CRAFTING, SURVIVAL, AMS}
            //#else
            //$$ categories = {CRAFTING, SURVIVAL, AMS}
            //#endif
    )
    public static boolean betterCraftablePolishedBlackStoneButton = false;
    //#endif
}
