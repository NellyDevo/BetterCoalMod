package me.johnnydevo.bettercoalmod.blocks.mattercompressor;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import me.johnnydevo.bettercoalmod.BetterCoalMod;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class MatterCompressorScreen extends ContainerScreen<MatterCompressorContainer> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(BetterCoalMod.MOD_ID, "textures/gui/matter_compressor.png");

    public MatterCompressorScreen(MatterCompressorContainer pMenu, PlayerInventory pPlayerInventory, ITextComponent pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    public void render(MatrixStack pMatrixStack, int pMouseX, int pMouseY, float pPartialTicks) {
        renderBackground(pMatrixStack);
        super.render(pMatrixStack, pMouseX, pMouseY, pPartialTicks);
        renderTooltip(pMatrixStack, pMouseX, pMouseY);
    }

    @Override
    protected void renderBg(MatrixStack pMatrixStack, float pPartialTicks, int pX, int pY) {
        RenderSystem.color4f(1, 1, 1, 1);
        minecraft.getTextureManager().bind(TEXTURE);

        int posX = (width - imageWidth) / 2;
        int posY = (height - imageHeight) / 2;

        blit(pMatrixStack, posX, posY, 0, 0, imageWidth, imageHeight);

        blit(pMatrixStack, posX + 79, posY + 35, 176, 14, menu.getProgressArrowScale() + 1, 16);
    }
}
