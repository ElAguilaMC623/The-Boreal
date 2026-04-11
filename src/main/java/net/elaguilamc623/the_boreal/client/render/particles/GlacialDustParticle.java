package net.elaguilamc623.the_boreal.client.render.particles;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;

public class GlacialDustParticle extends TextureSheetParticle {

    public GlacialDustParticle(ClientLevel level, double x, double y, double z,
                                  double vx, double vy, double vz) {
        super(level, x, y, z, vx, vy, vz);
        this.gravity = 0;
        this.lifetime = 40 + this.random.nextInt(20);
        this.quadSize *= 0.4F;
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;

        public Provider(SpriteSet sprites) {
            this.sprites = sprites;
        }

        @Override
        public Particle createParticle(SimpleParticleType type, ClientLevel level,
                                       double x, double y, double z,
                                       double vx, double vy, double vz) {
            GlacialDustParticle p = new GlacialDustParticle(level, x, y, z, vx, vy, vz);
            p.pickSprite(this.sprites);
            return p;
        }
    }
}