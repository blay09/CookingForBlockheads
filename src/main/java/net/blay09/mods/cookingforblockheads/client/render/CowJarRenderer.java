package net.blay09.mods.cookingforblockheads.client.render;

import net.blay09.mods.cookingforblockheads.tile.TileMilkJar;
import net.minecraft.client.model.ModelCow;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.util.ResourceLocation;

public class CowJarRenderer extends MilkJarRenderer {

	private static final ResourceLocation COW_TEXTURES = new ResourceLocation("textures/entity/cow/cow.png");

	private static final ModelCow model = new ModelCow();
	private static EntityCow entity;

	@Override
	public void renderTileEntityAt(TileMilkJar tileEntity, double x, double y, double z, float partialTicks, int destroyStage) {
		super.renderTileEntityAt(tileEntity, x, y, z, partialTicks, destroyStage);
		if(entity == null && tileEntity.hasWorldObj()) {
			entity = new EntityCow(tileEntity.getWorld());
			entity.setScaleForAge(false);
		}
		bindTexture(COW_TEXTURES);
		if(entity != null) {
			GlStateManager.pushMatrix();
			GlStateManager.translate(x + 0.5, y + 0.5, z + 0.5);
			GlStateManager.rotate(180f, 0f, 0f, 1f);
			GlStateManager.scale(0.02, 0.02, 0.02);
			model.render(entity, 0f, 0f, 0f, 0f, 0f, 1f);
			GlStateManager.popMatrix();
		}
	}

}
