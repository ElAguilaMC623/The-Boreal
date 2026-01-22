package net.elaguilamc623.the_boreal.registries;

import net.elaguilamc623.the_boreal.TheBoreal;
import net.elaguilamc623.the_boreal.enchantments.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BorealEnchantments {

    public static final DeferredRegister<Enchantment> ENCHANTMENTS =
            DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, TheBoreal.MOD_ID);

    public static final RegistryObject<Enchantment> BOREAL_CURSE =
            ENCHANTMENTS.register("boreal_curse", BorealCurseEnchantment::new);

    public static final RegistryObject<Enchantment> RANDOM_CRIT =
            ENCHANTMENTS.register("random_crit", RandomCritEnchantment::new);

    public static final RegistryObject<Enchantment> EMISSIVE =
            ENCHANTMENTS.register("emissive", EmissiveEnchantment::new);
}