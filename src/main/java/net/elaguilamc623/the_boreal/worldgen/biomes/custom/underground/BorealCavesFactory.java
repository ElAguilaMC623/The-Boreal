package net.elaguilamc623.the_boreal.worldgen.biomes.custom.underground;

import net.elaguilamc623.the_boreal.worldgen.biomes.custom.AbstractBorealBiomeFactory;
import net.elaguilamc623.the_boreal.worldgen.biomes.util.BorealBiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;

public class BorealCavesFactory extends AbstractBorealBiomeFactory {

    @Override
    public float temperature(BootstapContext<Biome> context) {
        return 0.3F;
    }

    @Override
    public float downfall(BootstapContext<Biome> context) {
        return 0.5F;
    }

    @Override
    public BiomeSpecialEffects.Builder specialEffects(BootstapContext<Biome> context) {
        return super.specialEffects(context)
                .grassColorOverride(4876142)
                .foliageColorOverride(4876142)
                .fogColor(2507703)
                .waterColor(5718385)
                .waterFogColor(2561575);
    }

    @Override
    public MobSpawnSettings.Builder mobSpawnSettings(BootstapContext<Biome> context) {
        return super.mobSpawnSettings(context);
    }

    @Override
    public BiomeGenerationSettings.Builder defaultGenerationSettings(BootstapContext<Biome> context) {
        var builder = super.defaultGenerationSettings(context);

        BorealBiomeDefaultFeatures.addAllCaveOres(builder);

        return builder;
    }
}
