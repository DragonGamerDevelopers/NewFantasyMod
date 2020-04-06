package mod.dragonita.fantasymod.client.models;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import mod.dragonita.fantasymod.entities.UnicornEntity;
import mod.dragonita.fantasymod.util.PCEntityModel;
import mod.dragonita.fantasymod.util.PCRenderModel;

/**
 * ModelUnicornTabula - DragonITA
 * Animation Functions - Andrew0030
 * Created using Tabula 7.1.0
 */
public class ModelUnicorn<T extends UnicornEntity> extends PCEntityModel<T> {
    public PCRenderModel Body;
    public PCRenderModel NeckHair;
    public PCRenderModel BackLeftLeg1;
    public PCRenderModel BackRightLeg1;
    public PCRenderModel FrontRightLeg1;
    public PCRenderModel FrontLeftLeg1;
    public PCRenderModel Tail1;
    public PCRenderModel Head;
    public PCRenderModel RightEar1;
    public PCRenderModel LeftEar1;
    public PCRenderModel Neck;
    public PCRenderModel LeftMouthSaddleLine;
    public PCRenderModel RightMouthSaddleLine;
    public PCRenderModel CenterSaddle;
    public PCRenderModel RightSaddleMouthButton;
    public PCRenderModel LeftSaddleMouthButton;
    public PCRenderModel BackLeftLeg2;
    public PCRenderModel BackLeftLeg3;
    public PCRenderModel BackRightLeg2;
    public PCRenderModel BackRightLeg3;
    public PCRenderModel FrontRightLeg2;
    public PCRenderModel FrontRightLeg3;
    public PCRenderModel FrontLeftLeg2;
    public PCRenderModel FrontLeftLeg3;
    public PCRenderModel Tail2;
    public PCRenderModel Tail3;
    public PCRenderModel UpperMouth;
    public PCRenderModel UnderMouth;
    public PCRenderModel Corn1;
    public PCRenderModel Corn2;
    public PCRenderModel Corn3;
    public PCRenderModel RightEar2;
    public PCRenderModel LeftEar2;
    public PCRenderModel BackUpperSaddlePart;
    public PCRenderModel FrontUpperSaddlePart;
    public PCRenderModel LeftSaddleLine;
    public PCRenderModel RightSaddleLine;
    public PCRenderModel LeftSaddlePart;
    public PCRenderModel RightSaddlePart;

    
    public ModelUnicorn() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.BackRightLeg3 = new PCRenderModel(this, 96, 51);
        this.BackRightLeg3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.BackRightLeg3.addBox(-1.5F, 5.1F, -2.0F, 4, 3, 4, 0.0F);
        this.LeftSaddleLine = new PCRenderModel(this, 71, 0);
        this.LeftSaddleLine.setRotationPoint(5.0F, 3.0F, 2.0F);
        this.LeftSaddleLine.addBox(-0.5F, 0.0F, -0.5F, 1, 6, 1, 0.0F);
        this.BackLeftLeg1 = new PCRenderModel(this, 78, 29);
        this.BackLeftLeg1.setRotationPoint(4.0F, -2.0F, 2.0F);
        this.BackLeftLeg1.addBox(-2.5F, -2.0F, -2.5F, 4, 9, 5, 0.0F);
        this.RightSaddlePart = new PCRenderModel(this, 75, 4);
        this.RightSaddlePart.setRotationPoint(-5.0F, 3.0F, 2.0F);
        this.RightSaddlePart.addBox(-0.5F, 6.0F, -1.0F, 1, 2, 2, 0.0F);
        this.Corn3 = new PCRenderModel(this, 30, 70);
        this.Corn3.setRotationPoint(0.5F, -2.0F, 0.5F);
        this.Corn3.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.LeftSaddleMouthButton = new PCRenderModel(this, 74, 13);
        this.LeftSaddleMouthButton.setRotationPoint(0.2F, -7.0F, -18.5F);
        this.LeftSaddleMouthButton.addBox(1.5F, -8.0F, -4.0F, 1, 2, 2, 0.0F);
        this.setRotateAngle(LeftSaddleMouthButton, 0.5235987755982988F, 0.0F, 0.0F);
        this.Corn2 = new PCRenderModel(this, 15, 70);
        this.Corn2.setRotationPoint(0.5F, -2.0F, 0.5F);
        this.Corn2.addBox(0.0F, -1.0F, 0.0F, 2, 2, 2, 0.0F);
        this.BackRightLeg1 = new PCRenderModel(this, 96, 29);
        this.BackRightLeg1.setRotationPoint(-4.0F, -2.0F, 2.0F);
        this.BackRightLeg1.addBox(-1.5F, -2.0F, -2.5F, 4, 9, 5, 0.0F);
        this.FrontRightLeg1 = new PCRenderModel(this, 60, 29);
        this.FrontRightLeg1.setRotationPoint(-4.0F, -2.0F, -17.0F);
        this.FrontRightLeg1.addBox(-1.1F, -1.0F, -2.1F, 3, 8, 4, 0.0F);
        this.LeftMouthSaddleLine = new PCRenderModel(this, 61, 5);
        this.LeftMouthSaddleLine.setRotationPoint(0.0F, -7.0F, -19.0F);
        this.LeftMouthSaddleLine.addBox(2.6F, -6.0F, -6.0F, 0, 3, 16, 0.0F);
        this.UpperMouth = new PCRenderModel(this, 24, 14);
        this.UpperMouth.setRotationPoint(0.0F, 0.02F, 0.02F);
        this.UpperMouth.addBox(-2.0F, -10.0F, -8.0F, 4, 3, 7, 0.0F);
        this.FrontRightLeg2 = new PCRenderModel(this, 60, 41);
        this.FrontRightLeg2.setRotationPoint(0.0F, 7.0F, 0.0F);
        this.FrontRightLeg2.addBox(-1.1F, 0.0F, -1.6F, 3, 5, 3, 0.0F);
        this.NeckHair = new PCRenderModel(this, 59, 0);
        this.NeckHair.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.NeckHair.addBox(-1.0F, -11.5F, 5.0F, 2, 16, 4, 0.0F);
        this.Tail1 = new PCRenderModel(this, 44, 0);
        this.Tail1.setRotationPoint(0.0F, -8.0F, 5.0F);
        this.Tail1.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 3, 0.0F);
        this.setRotateAngle(Tail1, -1.3089969389957472F, 0.0F, 0.0F);
        this.RightSaddleMouthButton = new PCRenderModel(this, 74, 13);
        this.RightSaddleMouthButton.setRotationPoint(-0.2F, -7.0F, -18.5F);
        this.RightSaddleMouthButton.addBox(-2.5F, -8.0F, -4.0F, 1, 2, 2, 0.0F);
        this.setRotateAngle(RightSaddleMouthButton, 0.5235987755982988F, 0.0F, 0.0F);
        this.Head = new PCRenderModel(this, 0, 0);
        this.Head.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Head.addBox(-2.5F, -10.0F, -1.5F, 5, 5, 7, 0.0F);
        this.LeftSaddlePart = new PCRenderModel(this, 75, 0);
        this.LeftSaddlePart.setRotationPoint(5.0F, 3.0F, 2.0F);
        this.LeftSaddlePart.addBox(-0.5F, 6.0F, -1.0F, 1, 2, 2, 0.0F);
        this.FrontUpperSaddlePart = new PCRenderModel(this, 106, 9);
        this.FrontUpperSaddlePart.setRotationPoint(0.0F, 2.0F, 2.0F);
        this.FrontUpperSaddlePart.addBox(-1.5F, -1.0F, -3.0F, 3, 1, 2, 0.0F);
        this.RightEar1 = new PCRenderModel(this, 0, 12);
        this.RightEar1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.RightEar1.addBox(0.0F, -16.0F, 4.0F, 2, 7, 1, 0.0F);
        this.setRotateAngle(RightEar1, 0.0F, 0.0F, -0.2617993877991494F);
        this.Corn1 = new PCRenderModel(this, 0, 70);
        this.Corn1.setRotationPoint(-1.5F, -11.0F, -5.5F);
        this.Corn1.addBox(0.0F, -1.0F, 0.0F, 3, 2, 3, 0.0F);
        this.BackUpperSaddlePart = new PCRenderModel(this, 80, 9);
        this.BackUpperSaddlePart.setRotationPoint(0.0F, 2.0F, 2.0F);
        this.BackUpperSaddlePart.addBox(-4.0F, -1.0F, 3.0F, 8, 1, 2, 0.0F);
        this.RightMouthSaddleLine = new PCRenderModel(this, 61, 5);
        this.RightMouthSaddleLine.setRotationPoint(0.0F, -7.0F, -19.0F);
        this.RightMouthSaddleLine.addBox(-2.6F, -6.0F, -6.0F, 0, 3, 16, 0.0F);
        this.BackLeftLeg2 = new PCRenderModel(this, 78, 43);
        this.BackLeftLeg2.setRotationPoint(0.0F, 7.0F, 0.0F);
        this.BackLeftLeg2.addBox(-2.0F, 0.0F, -1.5F, 3, 5, 3, 0.0F);
        this.LeftEar2 = new PCRenderModel(this, 0, 80);
        this.LeftEar2.setRotationPoint(0.0F, -0.2F, -0.1F);
        this.LeftEar2.addBox(0.45F, -12.0F, 4.0F, 2, 3, 1, 0.0F);
        this.setRotateAngle(LeftEar2, 0.0F, -0.13962634015954636F, -0.20943951023931953F);
        this.FrontLeftLeg3 = new PCRenderModel(this, 44, 51);
        this.FrontLeftLeg3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.FrontLeftLeg3.addBox(-2.4F, 5.1F, -2.1F, 4, 3, 4, 0.0F);
        this.Tail3 = new PCRenderModel(this, 24, 3);
        this.Tail3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Tail3.addBox(-1.5F, -4.5F, 9.0F, 3, 4, 7, 0.0F);
        this.setRotateAngle(Tail3, -0.2617993877991494F, 0.0F, 0.0F);
        this.FrontLeftLeg2 = new PCRenderModel(this, 44, 41);
        this.FrontLeftLeg2.setRotationPoint(0.0F, 7.0F, 0.0F);
        this.FrontLeftLeg2.addBox(-1.9F, 0.0F, -1.6F, 3, 5, 3, 0.0F);
        this.Body = new PCRenderModel(this, 0, 34);
        this.Body.setRotationPoint(0.0F, 11.0F, 9.0F);
        this.Body.addBox(-5.0F, -8.0F, -19.0F, 10, 10, 24, 0.0F);
        this.FrontLeftLeg1 = new PCRenderModel(this, 46, 29);
        this.FrontLeftLeg1.setRotationPoint(4.0F, -2.0F, -17.0F);
        this.FrontLeftLeg1.addBox(-1.9F, -1.0F, -2.1F, 3, 8, 4, 0.0F);
        this.Neck = new PCRenderModel(this, 0, 12);
        this.Neck.setRotationPoint(0.0F, -6.5F, -19.0F);
        this.Neck.addBox(-2.05F, -9.8F, -2.0F, 4, 14, 8, 0.0F);
        this.setRotateAngle(Neck, 0.5235987755982988F, 0.0F, 0.0F);
        this.CenterSaddle = new PCRenderModel(this, 80, 0);
        this.CenterSaddle.setRotationPoint(0.0F, -9.0F, -7.0F);
        this.CenterSaddle.addBox(-5.0F, 0.0F, -3.0F, 10, 1, 8, 0.0F);
        this.RightSaddleLine = new PCRenderModel(this, 81, 0);
        this.RightSaddleLine.setRotationPoint(-5.0F, 3.0F, 2.0F);
        this.RightSaddleLine.addBox(-0.5F, 0.0F, -0.5F, 1, 6, 1, 0.0F);
        this.UnderMouth = new PCRenderModel(this, 24, 24);
        this.UnderMouth.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.UnderMouth.addBox(-2.0F, -7.0F, -8.0F, 4, 2, 7, 0.0F);
        this.BackLeftLeg3 = new PCRenderModel(this, 78, 51);
        this.BackLeftLeg3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.BackLeftLeg3.addBox(-2.5F, 5.1F, -2.0F, 4, 3, 4, 0.0F);
        this.Tail2 = new PCRenderModel(this, 39, 7);
        this.Tail2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Tail2.addBox(-1.5F, -2.0F, 3.0F, 3, 4, 7, 0.0F);
        this.FrontRightLeg3 = new PCRenderModel(this, 60, 51);
        this.FrontRightLeg3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.FrontRightLeg3.addBox(-1.6F, 5.1F, -2.1F, 4, 3, 4, 0.0F);
        this.RightEar2 = new PCRenderModel(this, 0, 0);
        this.RightEar2.setRotationPoint(0.0F, -0.2F, -0.1F);
        this.RightEar2.addBox(-2.45F, -12.0F, 4.0F, 2, 3, 1, 0.0F);
        this.setRotateAngle(RightEar2, 0.0F, 0.13962634015954636F, 0.20943951023931953F);
        this.LeftEar1 = new PCRenderModel(this, 10, 80);
        this.LeftEar1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.LeftEar1.addBox(-2.0F, -16.0F, 4.0F, 2, 7, 1, 0.0F);
        this.setRotateAngle(LeftEar1, 0.0F, 0.0F, 0.2617993877991494F);
        this.BackRightLeg2 = new PCRenderModel(this, 96, 43);
        this.BackRightLeg2.setRotationPoint(0.0F, 7.0F, 0.0F);
        this.BackRightLeg2.addBox(-1.0F, 0.0F, -1.5F, 3, 5, 3, 0.0F);
        this.BackRightLeg2.addChild(this.BackRightLeg3);
        this.Body.addChild(this.BackLeftLeg1);
        this.Corn2.addChild(this.Corn3);
        this.Body.addChild(this.LeftSaddleMouthButton);
        this.Corn1.addChild(this.Corn2);
        this.Body.addChild(this.BackRightLeg1);
        this.Body.addChild(this.FrontRightLeg1);
        this.Body.addChild(this.LeftMouthSaddleLine);
        this.Head.addChild(this.UpperMouth);
        this.FrontRightLeg1.addChild(this.FrontRightLeg2);
        this.Neck.addChild(this.NeckHair);
        this.Body.addChild(this.Tail1);
        this.Body.addChild(this.RightSaddleMouthButton);
        this.Neck.addChild(this.Head);
        this.Head.addChild(this.RightEar1);
        this.UpperMouth.addChild(this.Corn1);
        this.Body.addChild(this.RightMouthSaddleLine);
        this.BackLeftLeg1.addChild(this.BackLeftLeg2);
        this.LeftEar1.addChild(this.LeftEar2);
        this.FrontLeftLeg2.addChild(this.FrontLeftLeg3);
        this.Tail2.addChild(this.Tail3);
        this.FrontLeftLeg1.addChild(this.FrontLeftLeg2);
        this.Body.addChild(this.FrontLeftLeg1);
        this.Body.addChild(this.Neck);
        this.Body.addChild(this.CenterSaddle);
        this.Head.addChild(this.UnderMouth);
        this.BackLeftLeg2.addChild(this.BackLeftLeg3);
        this.Tail1.addChild(this.Tail2);
        this.FrontRightLeg2.addChild(this.FrontRightLeg3);
        this.RightEar1.addChild(this.RightEar2);
        this.Head.addChild(this.LeftEar1);
        this.BackRightLeg1.addChild(this.BackRightLeg2);
        bodyParts = new PCRenderModel[] {Body, NeckHair, BackLeftLeg1, BackRightLeg1, FrontRightLeg1, FrontLeftLeg1, Tail1, Head, RightEar1, LeftEar1, Neck, LeftMouthSaddleLine, RightMouthSaddleLine, CenterSaddle, RightSaddleMouthButton, LeftSaddleMouthButton, BackLeftLeg2, BackLeftLeg3, BackRightLeg2, BackRightLeg3, FrontRightLeg2, FrontRightLeg3, FrontLeftLeg2, FrontLeftLeg3, Tail2, Tail3, UpperMouth, UnderMouth, Corn1, Corn2, Corn3, RightEar2, LeftEar2, BackUpperSaddlePart, FrontUpperSaddlePart, LeftSaddleLine, RightSaddleLine, LeftSaddlePart, RightSaddlePart};
        saveAsDefaultPose();
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(PCRenderModel PCRenderModel, float x, float y, float z) {
        PCRenderModel.rotateAngleX = x;
        PCRenderModel.rotateAngleY = y;
        PCRenderModel.rotateAngleZ = z;
    }

    @Override
    public void render(MatrixStack arg0, IVertexBuilder arg1, int arg2, int arg3, float arg4, float arg5, float arg6,
    		float arg7) {
        this.LeftSaddleLine.render(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
        this.RightSaddlePart.render(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
        this.LeftSaddlePart.render(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
        this.FrontUpperSaddlePart.render(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
        this.BackUpperSaddlePart.render(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
        this.Body.render(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
        this.RightSaddleLine.render(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }
    
    @Override
    public void setLivingAnimations(T entity, float limbSwing, float limbSwingAmount, float partialTick) {
    	super.setLivingAnimations(entity, limbSwing, limbSwingAmount, partialTick);
		
    	limbSwing = entity.ticksExisted;
		limbSwingAmount = 1;
		
		loadDefaultPose();

		@SuppressWarnings("unused")
		float globalHeight = 1;
		@SuppressWarnings("unused")
		float globalSpeed = 1;
		float globalDegree = 1;
    	
		if(entity.prevPosX != entity.getPosX() || entity.prevPosY != entity.getPosY() || entity.prevPosZ != entity.getPosZ()){
    		if(entity.getDataManager().get(UnicornEntity.PANIC) || entity.hasAttacker == true) {
    			//Body 0.00000000009F
    			bounce(Body, 0.5F, 4000000F, true, limbSwing, limbSwingAmount);
    			
    			//BackLeftLeg
    			swing(BackLeftLeg1, 2500F, -0.45F*globalDegree, false, 0.4F, 0F, limbSwing, limbSwingAmount);
    			swing(BackLeftLeg2, 2500F, -0.45F*globalDegree, false, 0.4F, 0F, limbSwing, limbSwingAmount);
    				    	
    			//BackRightLeg
    			swing(BackRightLeg1, 250, -0.45F*globalDegree, false, 0.4F, 0F, limbSwing, limbSwingAmount);
    			swing(BackRightLeg2, 250, -0.45F*globalDegree, false, 0.4F, 0F, limbSwing, limbSwingAmount);
    				    		
    			//FrontLeftLeg
    			swing(FrontLeftLeg1, 250, 0.5F*globalDegree, false, 0.4F, 0F, limbSwing, limbSwingAmount);
    			swing(FrontLeftLeg2, 250, 0.5F*globalDegree, false, 0.4F, 0F, limbSwing, limbSwingAmount);
    						
    			//FrontRightLeg
    			swing(FrontRightLeg1, 250, 0.5F*globalDegree, false, 0.4F, 0F, limbSwing, limbSwingAmount);
    			swing(FrontRightLeg2, 250, 0.5F*globalDegree, false, 0.4F, 0F, limbSwing, limbSwingAmount);
    			
	    	}else{
	    		/*
	    	    //Body
	    	    bounce(Body, -0.2F*globalSpeed, -0.2F*globalHeight, false, limbSwing, limbSwingAmount);
	    	       		
	    	   	//BackLeftLeg
	    	   	bounce(BackLeftLeg1, -0.2F*globalSpeed, 0.2F*globalHeight, false, limbSwing, limbSwingAmount);
	    	    	
	    	   	//BackRightLeg
	    	   	bounce(BackRightLeg1, -0.2F*globalSpeed, 0.2F*globalHeight, false, limbSwing, limbSwingAmount);
	    	    		
	        	//FrontLeftLeg
	   	    	bounce(FrontLeftLeg1, -0.2F*globalSpeed, 0.2F*globalHeight, false, limbSwing, limbSwingAmount);
	    	    
	    	    //FrontRightLeg
	    	    bounce(FrontRightLeg1, -0.2F*globalSpeed, 0.2F*globalHeight, false, limbSwing, limbSwingAmount);
	    		*/
	    	}             
	    }
    }
    
    @Override
    public void setRotationAngles(UnicornEntity entity, float limbSwing, float limbSwingAmount, float ageInTick, float netHeadYaw, float headPitch) {

		this.Neck.rotateAngleY = (netHeadYaw*((float)Math.PI / 180)) / 2;
		//this.Head.rotateAngleZ = (netHeadYaw*((float)Math.PI / 180)) / 4;
		//this.Head.rotateAngleY = (netHeadYaw*((float)Math.PI / 180)) / 4;
        		
		boolean flag = entity.isHorseSaddled();
        this.LeftSaddleLine.showModel = flag;
        this.RightSaddlePart.showModel = flag ;
        this.LeftSaddlePart.showModel = flag;
        this.FrontUpperSaddlePart.showModel = flag;
        this.BackUpperSaddlePart.showModel = flag;
        this.RightSaddleLine.showModel = flag;
								
	}
}
