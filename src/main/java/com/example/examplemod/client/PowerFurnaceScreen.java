package com.example.examplemod.client;

import com.example.examplemod.blockentitys.PowerFurnaceEntity;
import com.example.examplemod.inventory.PowerFurnaceMenu;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.awt.*;

@OnlyIn(Dist.CLIENT)
public class PowerFurnaceScreen extends AbstractContainerScreen<PowerFurnaceMenu> {

    //TODO: Access PowerFurnaceEntity directly so we can make use of its variables

    private static final ResourceLocation CONTAINER_LOCATION = new ResourceLocation("generitech:textures/gui/container/machine.png");
    private final PowerFurnaceEntity powerFurnaceEntity;

    public PowerFurnaceScreen(PowerFurnaceMenu menu, Inventory inventory, Component component) {
        super(menu, inventory, component);
        this.powerFurnaceEntity = menu.getPowerFurnaceEntity();
    }

    protected void init() {
        super.init();
        this.titleLabelX = (this.imageWidth - this.font.width(this.title)) / 2;
    }

    public void render(PoseStack poseStack, int posX, int posY, float p_98697_) {
        this.renderBackground(poseStack);
        super.render(poseStack, posX, posY, p_98697_);
        this.renderTooltip(poseStack, posX, posY);
    }

    //FIXME: properly get PowerFurnaceEntity object, code below currently passes a null pointer exception upon menu open
    /*@Override
    protected void renderLabels(PoseStack poseStack, int posX, int posY) {
        drawCenteredString(poseStack, this.font, Integer.toString(powerFurnaceEntity.getProcessTime()),64, 64, new Color(160, 30, 80).getRGB());
    }*/

    @Override
    protected void renderBg(PoseStack poseStack, float p_97788_, int posX, int posY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, CONTAINER_LOCATION);
        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;
        this.blit(poseStack, i, j, 0, 0, this.imageWidth, this.imageHeight);

    }
}
