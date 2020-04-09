package mod.dragonita.fantasymod.world.dimensions;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.ChunkGenerator;

public class FantasyDimension extends Dimension {

	public FantasyDimension(World worldIn, DimensionType typeIn) {
		super(worldIn, typeIn, 0.0F);
	}

	@Override
	public ChunkGenerator<?> createChunkGenerator() {
		return new FantasyChunkGenerator(world, new FantasyBiomeProvider(), new FantasyGenSettings());
	}

	@Override
	public BlockPos findSpawn(ChunkPos chunkPosIn, boolean checkValid) {
		return null;
	}

	@Override
	public BlockPos findSpawn(int posX, int posZ, boolean checkValid) {
		return null;
	}

	@Override
	public float calculateCelestialAngle(long worldTime, float partialTicks) {
		int j = 7000;
		float f1 = (j + partialTicks) / 30000.0f - 0.25f;
		if(f1 < 0) {
			f1+= 1;
		}
		
		if(f1 > 1) {
			f1 -= 1;
		}
		
		float f2 = f1;
		f1 = 1 - (float)((Math.cos(f1 * Math.PI) + 1) / 2);
		f1 = f2 + (f1 - f2) / 3;
		return f1;
	}

	@Override
	public boolean isSurfaceWorld() {
		return true;
	}

	@Override
	public Vec3d getFogColor(float celestialAngle, float partialTicks) {
		return Vec3d.ZERO;
	}

	@Override
	public boolean canRespawnHere() {
		return true;
	}

	@Override
	public boolean doesXZShowFog(int x, int z) {
		return false;
	}

	@Override
	public SleepResult canSleepAt(PlayerEntity player, BlockPos pos) {
		return SleepResult.ALLOW;
	}
	
	@Override
	public int getActualHeight() {
		return 10;
	}
}