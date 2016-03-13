package me.koenn.CE.effects;

import de.slikey.effectlib.EffectManager;
import de.slikey.effectlib.effect.AnimatedBallEffect;
import de.slikey.effectlib.util.DynamicLocation;
import me.koenn.CE.LTPCustomEnchants;
import org.bukkit.Location;
import org.bukkit.block.Block;

/**
 * Effect to show when you enchant a book.
 */
public class EnchantEffect {

    private AnimatedBallEffect effect;

    /**
     * Constructs the effect, and prepares everything to play it.
     *
     * @param enchantmentTable The enchantTable to play the effect on.
     */
    public EnchantEffect(Block enchantmentTable) {
        Location exact = enchantmentTable.getLocation().add(0.5, 1.0, 0.5);
        EffectManager manager = new EffectManager(LTPCustomEnchants.instance);
        this.effect = new AnimatedBallEffect(manager);
        this.effect.iterations = 25;
        this.effect.size = 0.5F;
        this.effect.yFactor = 1.0F;
        this.effect.yOffset = 0.0F;
        this.effect.setDynamicOrigin(new DynamicLocation(exact));
        this.effect.setDynamicTarget(new DynamicLocation(exact));
    }

    /**
     * Play the effect.
     */
    public void play() {
        this.effect.start();
    }
}
