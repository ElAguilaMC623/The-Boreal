package net.elaguilamc623.the_boreal.worldgen.dimension;

import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.dimension.DimensionType;
import java.util.OptionalLong;

public class BorealDimensionType {
    public static void bootstrap(BootstapContext<DimensionType> context) {
        context.register(BorealDimension.BOREAL_TYPE,
                new DimensionType(
                        OptionalLong.of(18000L), // fixed time (empty = ciclo normal)
                        true,
                        false,
                        false,
                        false,
                        1.0,
                        false,
                        false,
                        -64,
                        384,
                        384,
                        BlockTags.INFINIBURN_OVERWORLD,
                        new ResourceLocation("minecraft", "overworld"),
                        0.0f,
                        new DimensionType.MonsterSettings(
                                false,
                                false,
                                UniformInt.of(0, 0),
                                0
                        )

                )
        );
    }
}