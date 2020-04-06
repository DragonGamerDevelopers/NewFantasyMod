package mod.dragonita.fantasymod.entities;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.passive.horse.AbstractHorseEntity;
import net.minecraft.entity.passive.horse.HorseEntity;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.network.NetworkHooks;

public class UnicornEntity extends HorseEntity{
	//private static Logger LOGGER = Main.LOGGER;
	public static DataParameter<Boolean> PANIC = EntityDataManager.createKey(UnicornEntity.class, DataSerializers.BOOLEAN);
	public boolean hasAttacker;
	public UnicornEntity(final EntityType<? extends UnicornEntity> entityType, final World world) {
		super(entityType, world);
		dataManager.register(PANIC, false);
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
	public boolean isPanic() {
		//LOGGER.info("The AttackingEntity will be: " + this.getAttackingEntity());
		return this.goalSelector.getRunningGoals().anyMatch(goal -> goal.getGoal().getClass() == PanicGoal.class);
	}
	
	public boolean hasAttackerFunc() {
		return this.getAttackingEntity() != null ? true : false;
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
	 * It is not actually necessary for our UnicornEntity to use Forge's method as it doesn't need any of this extra
	 * functionality, however, this is an example mod and many modders are unaware that Forge's method exists.
	 *
	 * @return The packet with data about your entity
	 * @see FMLPlayMessages.SpawnEntity
	 */
	@Override
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}
	
	@Override
	public void tick() {
		super.tick();
		if(!world.isRemote) {
			if(hasAttackerFunc()) {
				this.hasAttacker = true;
			}else {
				this.hasAttacker = false;
			}
			
			if(isPanic() && !dataManager.get(PANIC)) {
				dataManager.set(PANIC, true);
			}else {
				dataManager.set(PANIC, false);
			}
		}
	}
}