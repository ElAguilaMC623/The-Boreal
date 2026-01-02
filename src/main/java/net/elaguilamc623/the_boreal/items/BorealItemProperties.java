package net.elaguilamc623.the_boreal.items;

import net.minecraft.world.item.Item;

public class BorealItemProperties extends Item.Properties {

    private boolean unbreakable = false;

    public BorealItemProperties unbreakable() {
        this.unbreakable = true;
        return this;
    }

    public boolean isUnbreakable() {
        return unbreakable;
    }
}
