package farmanimals.client;

import net.minecraft.client.model.ModelQuadruped;
import net.minecraft.client.model.ModelRenderer;

public class ModelBetterCow extends ModelQuadruped
{
    private static final String __OBFID = "CL_00000836";

    public ModelBetterCow()
    {
        super(12, 0.0F);
        
	    textureWidth = 64;
	    textureHeight = 64;
        
        this.head = new ModelRenderer(this, 0, 0);
        this.head.addBox(-4.0F, -4.0F, -6.0F, 8, 8, 6, 0.0F);
        this.head.setRotationPoint(0.0F, 4.0F, -8.0F);
        this.head.setTextureOffset(22, 0).addBox(-5.0F, -5.0F, -4.0F, 1, 3, 1, 0.0F);
        this.head.setTextureOffset(22, 0).addBox(4.0F, -5.0F, -4.0F, 1, 3, 1, 0.0F);
        
        this.body = new ModelRenderer(this, 18, 4);
        this.body.addBox(-6.0F, -10.0F, -7.0F, 12, 18, 10, 0.0F);
        this.body.setRotationPoint(0.0F, 5.0F, 2.0F);
        this.body.setTextureOffset(52, 0).addBox(-2.0F, 2.0F, -9.0F, 4, 6, 2);           
        
        this.leg1 = new ModelRenderer(this, 0, 16);
        this.leg1.addBox(-3.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.leg1.setRotationPoint(-3.0F, 12.0F, 7.0F);
        
        this.leg2 = new ModelRenderer(this, 0, 32);
        this.leg2.addBox(-1.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.leg2.setRotationPoint(3.0F, 12.0F, 7.0F);
        
        this.leg3 = new ModelRenderer(this, 0, 48);
        this.leg3.addBox(-3.0F, 0.0F, -3.0F, 4, 12, 4, 0.0F);
        this.leg3.setRotationPoint(-3.0F, 12.0F, -5.0F);
        
        this.leg4 = new ModelRenderer(this, 16, 48);
        this.leg4.addBox(-1.0F, 0.0F, -3.0F, 4, 12, 4, 0.0F);
        this.leg4.setRotationPoint(3.0F, 12.0F, -5.0F);
    }
}
