package net.elaguilamc623.the_boreal.worldgen.dimension.gen;

import com.mojang.datafixers.util.Pair;
import net.elaguilamc623.the_boreal.registries.BorealBiomes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import java.util.function.Consumer;

public class BorealBiomeMapBuilder {

    private final Climate.Parameter FULL = span(-1.0F, 1.0F);

    private final Climate.Parameter OCEAN_FAR = span(-1.0F, -0.6F);
    private final Climate.Parameter OCEAN_NEAR = span(-0.6F, -0.5F);
    private final Climate.Parameter COAST = span(-0.5F, -0.35F);
    private final Climate.Parameter INLAND = span(-0.35F, 1.0F);

    private final Climate.Parameter[] TEMP = {
            span(-1.0F, -0.25F),
            span(-0.25F, -0.05F),
            span(-0.05F, 0.15F),
            span(0.15F, 0.3F),
            span(0.3F, 1.0F)
    };

    private final Climate.Parameter[] HUM = {
            span(-1.0F, -0.35F),
            span(-0.35F, -0.2F),
            span(-0.2F, -0.05F),
            span(-0.05F, 0.15F),
            span(0.15F, 0.35F),
            span(0.35F, 1.0F)
    };

    private final Climate.Parameter[] EROSION = {
            span(-1.0F, -0.49F),
            span(-0.49F, -0.4F),
            span(-0.4F, -0.29F),
            span(-0.29F, -0.22F),
            span(-0.22F, 0.22F),
            span(0.22F, 0.29F),
            span(0.29F, 0.4F),
            span(0.4F, 0.48F),
            span(0.48F, 1.0F)
    };

    public void addBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> out) {

        addOceans(out);
        addCoasts(out);
        addInland(out);
    }

    private void addOceans(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> out) {

        out.accept(Pair.of(
                Climate.parameters(FULL, FULL, OCEAN_FAR, FULL, depth(0.2F, 1.0F), FULL, 0.0F),
                BorealBiomes.GLACIAL_DEEP_OCEAN
        ));

        out.accept(Pair.of(
                Climate.parameters(FULL, FULL, OCEAN_FAR, FULL, depth(0.0F, 0.2F), FULL, 0.0F),
                BorealBiomes.GLACIAL_OCEAN
        ));
    }

    private void addCoasts(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> out) {

        for (Climate.Parameter t : TEMP)
            for (Climate.Parameter h : HUM)
                out.accept(Pair.of(
                        Climate.parameters(t, h, COAST, EROSION[4], depth(0.0F, 0.2F), FULL, 0.0F),
                        BorealBiomes.GLACIAL_SHRUBLAND
                ));
    }

    private void addInland(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> out) {

        for (Climate.Parameter t : TEMP)
            for (Climate.Parameter h : HUM)
                for (Climate.Parameter e : EROSION) {

                    ResourceKey<Biome> biome = pickInlandBiome(t, h, e);

                    out.accept(Pair.of(
                            Climate.parameters(t, h, INLAND, e, depth(0.0F, 0.2F), FULL, 0.0F),
                            biome
                    ));
                }
    }

    private ResourceKey<Biome> pickInlandBiome(Climate.Parameter t, Climate.Parameter h, Climate.Parameter e) {

        float tMid = mid(t);
        float hMid = mid(h);

        if (tMid < -0.4F && hMid > 0.2F) return BorealBiomes.SNOWY_AURORAL_FOREST;
        if (tMid < -0.2F && hMid < 0.2F) return BorealBiomes.GLACIAL_TUNDRA;
        if (tMid > 0.2F && hMid < 0.1F) return BorealBiomes.GLACIAL_DESERT;
        if (tMid > 0.1F && hMid > 0.2F) return BorealBiomes.AURORAL_FOREST;

        return BorealBiomes.GLACIAL_PLAINS;
    }

    private static Climate.Parameter span(float min, float max) {
        return Climate.Parameter.span(min, max);
    }

    private static Climate.Parameter depth(float min, float max) {
        return Climate.Parameter.span(min, max);
    }

    private static float mid(Climate.Parameter p) {
        return (p.min() + p.max()) / 2.0F;
    }
}