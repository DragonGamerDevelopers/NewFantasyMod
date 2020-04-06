package mod.dragonita.fantasymod.block;

import java.util.stream.Stream;

import mod.dragonita.fantasymod.init.ModTileEntityTypes;
import mod.dragonita.fantasymod.tileentity.RainbowChestTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class RainbowChestBlock extends Block {
	
	public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
	public static final VoxelShape SHAPE_N = Stream.of(
			Block.makeCuboidShape(0, 12, 0, 16, 16, 16),
			Block.makeCuboidShape(7, 10, -1, 9, 14, 0),
			Block.makeCuboidShape(0, 0, 0, 16, 12, 16)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	public static final VoxelShape SHAPE_W = Stream.of(
			Block.makeCuboidShape(0, 12, 0, 16, 16, 16),
			Block.makeCuboidShape(-1, 10, 7, 0, 14, 9),
			Block.makeCuboidShape(0, 0, 0, 16, 12, 16)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	public static final VoxelShape SHAPE_O = Stream.of(
			Block.makeCuboidShape(0, 12, 0, 16, 16, 16),
			Block.makeCuboidShape(16, 10, 7, 17, 14, 9),
			Block.makeCuboidShape(0, 0, 0, 16, 12, 16)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	
	public static final VoxelShape SHAPE_S = Stream.of(
			Block.makeCuboidShape(0, 12, 0, 16, 16, 16),
			Block.makeCuboidShape(7, 10, 16, 9, 14, 17),
			Block.makeCuboidShape(0, 0, 0, 16, 12, 16)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	
	public RainbowChestBlock(final Properties properties) {
		super(properties);
		setDefaultState(getDefaultState().with(FACING, Direction.NORTH));
	}
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		switch(state.get(FACING)) {
		case NORTH:
			return SHAPE_N;
		case EAST:
			return SHAPE_O;
		case WEST:
			return SHAPE_W;
		case SOUTH:
			return SHAPE_S;
		default:
			return SHAPE_N;
		}
	}
	@Override
	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.toRotation(state.get(FACING)));
	}
	
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
	}
	
	@Override
	protected void fillStateContainer(Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}
	
	@Override
	public boolean hasTileEntity(final BlockState state) {
		return true;
	}
	
	@Override
	public BlockState rotate(BlockState state, Rotation rot) {
		return state.with(FACING, rot.rotate(state.get(FACING)));
	}
	
	@Override
	public TileEntity createTileEntity(final BlockState state, final IBlockReader world) {
		return ModTileEntityTypes.RAINBOW_CHEST.get().create();
	}

	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
			Hand handIn, BlockRayTraceResult p_225533_6_) {
		if(!worldIn.isRemote) {
			TileEntity tile = worldIn.getTileEntity(pos);
			if(tile instanceof RainbowChestTileEntity) {
				NetworkHooks.openGui((ServerPlayerEntity) player, (RainbowChestTileEntity)tile, pos);
				return ActionResultType.SUCCESS;
			}
		}
		return ActionResultType.FAIL;
	}
	
	@Override
	public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
		if(state.getBlock() != newState.getBlock()) {
			TileEntity tile = worldIn.getTileEntity(pos);
			if(tile instanceof RainbowChestTileEntity) {
				InventoryHelper.dropItems(worldIn, pos, ((RainbowChestTileEntity) tile).getItems());
			}
		}
	}
	
}