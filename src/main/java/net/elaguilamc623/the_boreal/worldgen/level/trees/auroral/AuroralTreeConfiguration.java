package net.elaguilamc623.the_boreal.worldgen.level.trees.auroral;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class AuroralTreeConfiguration implements FeatureConfiguration {
    public static final Codec<AuroralTreeConfiguration> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            BlockStateProvider.CODEC.fieldOf("trunk_provider").forGetter(cfg -> cfg.trunkProvider),
            BlockStateProvider.CODEC.fieldOf("foliage_provider").forGetter(cfg -> cfg.foliageProvider),
            BlockStateProvider.CODEC.fieldOf("branch_provider").forGetter(cfg -> cfg.branchProvider),
            Codec.INT.fieldOf("minimum_size").forGetter(cfg -> cfg.minimumSize),
            Codec.INT.fieldOf("size_variation").forGetter(cfg -> cfg.sizeVariation)
    ).apply(instance, AuroralTreeConfiguration::new));

    public final BlockStateProvider trunkProvider;
    public final BlockStateProvider foliageProvider;
    public final BlockStateProvider branchProvider;
    public final int minimumSize;
    public final int sizeVariation;

    public AuroralTreeConfiguration(BlockStateProvider trunk, BlockStateProvider foliage, BlockStateProvider branch, int minSize, int sizeVar) {
        this.trunkProvider = trunk;
        this.foliageProvider = foliage;
        this.branchProvider = branch;
        this.minimumSize = minSize;
        this.sizeVariation = sizeVar;
    }
}