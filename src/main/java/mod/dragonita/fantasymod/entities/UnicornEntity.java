package mod.dragonita.fantasymod.entities;

import mod.dragonita.fantasymod.customthings.PacketHandler;
import mod.dragonita.fantasymod.customthings.PanicMessage;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.passive.horse.AbstractHorseEntity;
import net.minecraft.entity.passive.horse.HorseEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.IPacket;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.PacketDistributor;

public class UnicornEntity extends HorseEntity{
	//private static Logger LOGGER = Main.LOGGER;
	
	public UnicornEntity(final EntityType<? extends UnicornEntity> entityType, final World world) {
		super(entityType, world);
	}

	@Override
	protected void registerAttributes() {
		super.registerAttributes();

		final double baseSpeed = this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getBaseValue();
		final double baseHealth = this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).getBaseValue();
		// Multiply base health and base speed by one and a half
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(baseSpeed * 1.5D);
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(baseHealth * 1.5D);
	}
	
	/**
	 * This Function return true if the running Goal was the same as in the parameters
	 * 
	 * @param The Class of the Goal we want to compare
	 * @return true if it was the same, else false
	 * @see The goals
	 */
	public boolean CompareGoal(Class<PanicGoal> TargetGoal, PlayerEntity player) {
		PacketHandler.INSTANCE.send(PacketDistributor.TRACKING_CHUNK.with(() -> player.chunk), PanicMessage::new);
		return this.goalSelector.getRunningGoals().anyMatch(goal -> goal.getGoal().getClass() == TargetGoal);
	}
	
	/**
	 * Creates a child new entity from the parent entity.
	 * Can be used to set additional on the child entity based on the parent.
	 *
	 * @param parent The entity that made this child
	 * @return A new Unicorn
	 * @see AbstractHorseEntity#setOffspringAttributes(AgeableEntity, AbstractHorseEntity)
	 */
	@Override
	public UnicornEntity createChild(final AgeableEntity parent) {
		// Use getType to support overrides in subclasses
		return (UnicornEntity)getType().create(this.world);
	}
	
	/**
	 * Called on the logical server to get a packet to send to the client containing data necessary to spawn your entity.
	 * Using Forge's method instead of the default vanilla one allows extra stuff to work such as sending extra data,
	 * using a non-default entity factory and having {@link IEntityAdditionalSpawnData} work.
	 *
	 * It is not actually necessary for our WildBoarEntity to use Forge's method as it doesn't need any of this extra
	 * functionality, however, this is an example mod and many modders are unaware that Forge's method exists.
	 *
	 * @return The packet with data about your entity
	 * @see FMLPlayMessages.SpawnEntity
	 */
	@Override
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}
}