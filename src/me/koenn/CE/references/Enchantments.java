package me.koenn.CE.references;

import me.koenn.CE.enchantments.EnchantType;
import me.koenn.CE.util.Tool;

/**
 * Information and settings for all the different enchantments.
 */
public class Enchantments {

    public static class Poison {
        public static final String NAME = "Venom Bite";
        public static final String DESC = "Has a chance of giving your%victim poison";
        public static final int MAX_LEVEL = 6;
        public static final Tool TOOL = Tool.SWORD;
        public static final EnchantType TYPE = EnchantType.RARE;
    }

    public static class Wither {
        public static final String NAME = "Withering";
        public static final String DESC = "Has a chance of giving your%victim wither";
        public static final int MAX_LEVEL = 4;
        public static final Tool TOOL = Tool.MELEE;
        public static final EnchantType TYPE = EnchantType.ULTRA_RARE;
    }

    public static class Lightning {
        public static final String NAME = "Electric Rage";
        public static final String DESC = "Has a chance to let lightning%strike your victim";
        public static final int MAX_LEVEL = 4;
        public static final Tool TOOL = Tool.MELEE;
        public static final EnchantType TYPE = EnchantType.LEGENDARY;
    }

    public static class Experience {
        public static final String NAME = "Flare of the Gods";
        public static final String DESC = "Gives extra experience for %killing mobs";
        public static final int MAX_LEVEL = 3;
        public static final Tool TOOL = Tool.SWORD;
        public static final EnchantType TYPE = EnchantType.LEGENDARY;
    }

    public static class Vampirism {
        public static final String NAME = "Bite of the Vampire";
        public static final String DESC = "Has a chance of lifesteal%when you hit someone";
        public static final int MAX_LEVEL = 5;
        public static final Tool TOOL = Tool.SWORD;
        public static final EnchantType TYPE = EnchantType.LEGENDARY;
    }

    public static class Headless {
        public static final String NAME = "Decapitate";
        public static final String DESC = "Has a chance of getting the%skull of your victim";
        public static final int MAX_LEVEL = 5;
        public static final Tool TOOL = Tool.SWORD;
        public static final EnchantType TYPE = EnchantType.COMMON;
    }

    public static class IceAspect {
        public static final String NAME = "Resurrection of Time";
        public static final String DESC = "Has a chance of giving your%victim slowness";
        public static final int MAX_LEVEL = 3;
        public static final Tool TOOL = Tool.AXE;
        public static final EnchantType TYPE = EnchantType.SIMPLE;
    }

    public static class Speed {
        public static final String NAME = "Bless of Hermes";
        public static final String DESC = "Gives you permanent%speed";
        public static final int MAX_LEVEL = 4;
        public static final Tool TOOL = Tool.BOOTS;
        public static final EnchantType TYPE = EnchantType.LEGENDARY;
    }

    public static class Resistance {
        public static final String NAME = "Spirit Barrage";
        public static final String DESC = "Gives you permanent%resistance";
        public static final int MAX_LEVEL = 2;
        public static final Tool TOOL = Tool.ARMOR;
        public static final EnchantType TYPE = EnchantType.ULTRA_RARE;
    }

    public static class Glowing {
        public static final String NAME = "Bat Vision";
        public static final String DESC = "Gives you permanent%night vision";
        public static final int MAX_LEVEL = 1;
        public static final Tool TOOL = Tool.HELMET;
        public static final EnchantType TYPE = EnchantType.SIMPLE;
    }

    public static class AntiFire {
        public static final String NAME = "Molten Salvo";
        public static final String DESC = "Gives you permanent%fire resistance";
        public static final int MAX_LEVEL = 1;
        public static final Tool TOOL = Tool.ARMOR;
        public static final EnchantType TYPE = EnchantType.RARE;
    }

    public static class Healing {
        public static final String NAME = "Call of Greater Healing";
        public static final String DESC = "Gives you an increased%regeneration rate";
        public static final int MAX_LEVEL = 2;
        public static final Tool TOOL = Tool.ARMOR;
        public static final EnchantType TYPE = EnchantType.ULTRA_RARE;
    }
}
