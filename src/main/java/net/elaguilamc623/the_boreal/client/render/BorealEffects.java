package net.elaguilamc623.the_boreal.client.render;

import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.extensions.IForgeDimensionSpecialEffects;

@OnlyIn(Dist.CLIENT)
public class BorealEffects extends DimensionSpecialEffects implements IForgeDimensionSpecialEffects {
    public BorealEffects() {
        super(192.0F, true, SkyType.NORMAL, false, false);
    }

    @Override
    public Vec3 getBrightnessDependentFogColor(Vec3 color, float brightness) {
        return new Vec3(0.25f, 0.05f, 0.25f);
    }

    @Override
    public boolean isFoggyAt(int x, int y) {
        return false;
    }
}