package farmanimals.client;

import farmanimals.FarmAnimals;
import farmanimals.entity.BetterCow;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


@SideOnly(Side.CLIENT)
public class RenderBetterCow extends RenderLiving
{
    private static final ResourceLocation cow = new ResourceLocation(FarmAnimals.MODID + ":textures/entities/BetterCow.png");
    private static final ResourceLocation blond = new ResourceLocation(FarmAnimals.MODID + ":textures/entities/BlondeCow.png");
    private static final ResourceLocation black = new ResourceLocation(FarmAnimals.MODID + ":textures/entities/BlackCow.png");
    private static final ResourceLocation brown = new ResourceLocation(FarmAnimals.MODID + ":textures/entities/BrownCow.png");
    private static final ResourceLocation milka = new ResourceLocation(FarmAnimals.MODID + ":textures/entities/MilkaCow.png");

    public RenderBetterCow(RenderManager renderManager, ModelBase ModelBase, float f) {
        super(renderManager, ModelBase, f);
    }

    protected ResourceLocation getEntityTexture(BetterCow entity) { 
        int i = entity.getType();
        switch (i) {
            case 0:
            default:
                return cow; 
            case 1:
                return blond; 
            case 2:
                return black; 
            case 3:
                return brown; 
            case 4:
                return milka;
        }
    }
    
    protected ResourceLocation getEntityTexture(Entity entity) {
        return this.getEntityTexture((BetterCow)entity);
    }
}
