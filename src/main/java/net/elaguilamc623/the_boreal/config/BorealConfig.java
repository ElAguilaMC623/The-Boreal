package net.elaguilamc623.the_boreal.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class BorealConfig {

    public static class Client {
        public final ForgeConfigSpec.BooleanValue plantParticles;

        Client(ForgeConfigSpec.Builder builder) {
            builder.push("visual");

            plantParticles = builder
                    .comment("Some plants like the Borealight Shroom or Glacialweed emit particles")
                    .define("bright_plants_emit_particles", true);

            builder.pop();
        }
    }

    public static final ForgeConfigSpec CLIENT_SPEC;
    public static final Client CLIENT;

    static {
        ForgeConfigSpec.Builder clientBuilder = new ForgeConfigSpec.Builder();
        CLIENT = new Client(clientBuilder);
        CLIENT_SPEC = clientBuilder.build();
    }
}
