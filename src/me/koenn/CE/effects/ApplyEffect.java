package me.koenn.CE.effects;

import de.slikey.effectlib.EffectManager;
import de.slikey.effectlib.effect.SphereEffect;
import de.slikey.effectlib.util.DynamicLocation;
import de.slikey.effectlib.util.ParticleEffect;
import me.koenn.CE.LTPCustomEnchants;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class ApplyEffect {

    private SphereEffect effect;

    public ApplyEffect(Player enchanter, Type type) {
        Location location = enchanter.getLocation();
        EffectManager manager = new EffectManager(LTPCustomEnchants.instance);
        this.effect = new SphereEffect(manager);
        this.effect.setDynamicOrigin(new DynamicLocation(enchanter.getLocation()));
        this.effect.setDynamicTarget(new DynamicLocation(new Location(enchanter.getWorld(), location.getX(), location.getY() - 1, location.getZ())));
        this.effect.radius = 1;
        this.effect.iterations = 1;

        switch (type) {
            case SUCCEED:
                this.setupSucceed();
                break;
            case FAILED:
                this.setupFailed();
                break;
            case DESTROYED:
                this.setupDestroy();
                break;
        }
    }

    private void setupDestroy() {
        this.effect.particle = ParticleEffect.FLAME;
        this.effect.yOffset = 0.3;
        this.effect.speed = 0.2F;
        this.effect.particleCount = 10;
    }

    private void setupFailed() {
        this.effect.particle = ParticleEffect.SMOKE_NORMAL;
        this.effect.yOffset = 0.8;
        this.effect.speed = 0.2F;
        this.effect.particleCount = 20;
    }

    private void setupSucceed() {
        this.effect.particle = ParticleEffect.SPELL;
        this.effect.yOffset = 0.4;
        this.effect.speed = 0.2F;
        this.effect.particleCount = 5;

    }

    public void start() {
        this.effect.start();
    }

    public enum Type {
        SUCCEED, FAILED, DESTROYED
    }
}
