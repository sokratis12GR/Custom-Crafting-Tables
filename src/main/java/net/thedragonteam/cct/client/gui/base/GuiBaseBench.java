/*
 * Copyright (c) TheDragonTeam 2016-2017.
 */

package net.thedragonteam.cct.client.gui.base;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentTranslation;

import static java.lang.String.format;
import static net.thedragonteam.cct.CCTConfig.cctGuiNames;
import static net.thedragonteam.cct.util.Utils.isNotNullNorEmpty;
import static net.thedragonteam.cct.util.Utils.setRL;

public class GuiBaseBench extends GuiContainer {

    public ResourceLocation resourceLocation;
    public String name;
    public int guiNumber;

    public GuiBaseBench(Container container, ResourceLocation resourceLocation, int size, int xSize, int ySize, int guiNumber) {
        super(container);
        this.resourceLocation = resourceLocation;
        this.name = format("%sx%s", size, size);
        this.xSize = xSize;
        this.ySize = ySize;
        this.guiNumber = guiNumber;
    }

    public GuiBaseBench(Container container, int size, int xSize, int ySize, int guiNumber) {
        super(container);
        String actualSize = format("%sx%s", size, size);
        this.resourceLocation = setRL(format("textures/gui/container/gui_%s.png", actualSize));
        this.name = actualSize;
        this.xSize = xSize;
        this.ySize = ySize;
        this.guiNumber = guiNumber;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        this.fontRenderer.drawString(isNotNullNorEmpty(cctGuiNames[guiNumber]) ? cctGuiNames[guiNumber] : new TextComponentTranslation("container.cct." + name).getFormattedText(), 28, 5, 4210752);
        this.fontRenderer.drawString(new TextComponentTranslation("container.cct.inventory").getFormattedText(), 8, this.ySize - 96 + 2, 4210752);
    }

    /**
     * Draws the background layer of this container (behind the items).
     */
    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(resourceLocation);
        int i = (this.width - this.xSize) / 2;
        int j = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);
    }
}
