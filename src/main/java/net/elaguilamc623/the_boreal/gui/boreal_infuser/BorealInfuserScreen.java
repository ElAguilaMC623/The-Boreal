package net.elaguilamc623.the_boreal.gui.boreal_infuser;

import com.mojang.blaze3d.systems.RenderSystem;
import net.elaguilamc623.the_boreal.TheBoreal;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class BorealInfuserScreen extends AbstractContainerScreen<BorealInfuserMenu> {

    private static final ResourceLocation TEXTURE =
            new ResourceLocation(TheBoreal.MOD_ID, "textures/gui/boreal_infuser.png");

    public BorealInfuserScreen(BorealInfuserMenu menu, Inventory inv, Component title) {
        super(menu, inv, title);
        this.imageWidth = 176;
        this.imageHeight = 166;
    }

    @Override
    protected void renderBg(GuiGraphics gui, float partialTicks, int mouseX, int mouseY) {
        RenderSystem.setShaderTexture(0, TEXTURE);
        gui.blit(TEXTURE, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight);
    }

    @Override
    public void render(GuiGraphics gui, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(gui);
        super.render(gui, mouseX, mouseY, partialTicks);
        this.renderTooltip(gui, mouseX, mouseY);
    }
}