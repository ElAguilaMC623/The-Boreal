package net.elaguilamc623.the_boreal.worldgen.features.custom.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.elaguilamc623.complementary_core.world.features.config.IFeatureConfig;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public record NocturnalTreeConfig(
        BlockStateProvider toPlace,
        BlockStateProvider leavesProvider,
        TagKey<Block> allowedGround,
        IntProvider heightRange
) implements IFeatureConfig {

    public static final Codec<NocturnalTreeConfig> CODEC = RecordCodecBuilder.create((instance) ->
            instance.group(
                    BlockStateProvider.CODEC.fieldOf("to_place").forGetter(NocturnalTreeConfig::toPlace),
                    BlockStateProvider.CODEC.fieldOf("leaves").forGetter(NocturnalTreeConfig::leavesProvider),
                    TagKey.codec(Registries.BLOCK).fieldOf("allowed_ground").forGetter(NocturnalTreeConfig::allowedGround),
                    IntProvider.codec(1, 64).fieldOf("height").forGetter(NocturnalTreeConfig::heightRange)
            ).apply(instance, NocturnalTreeConfig::new)
    );
}
