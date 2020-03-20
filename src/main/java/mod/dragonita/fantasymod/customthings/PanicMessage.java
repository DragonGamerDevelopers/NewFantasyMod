package mod.dragonita.fantasymod.customthings;

import java.util.function.Supplier;

import org.apache.commons.lang3.tuple.Pair;

import io.netty.buffer.Unpooled;
import net.minecraft.entity.ai.brain.task.PanicTask;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.IPacket;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.network.NetworkInstance;
import net.minecraftforge.fml.network.PacketDistributor;
import net.minecraftforge.fml.network.simple.IndexedMessageCodec;

public class PanicMessage{
	private static int data;
	public PanicMessage(PacketBuffer buf){
		PanicMessage.data = buf.readInt();
	}
	
	public PanicMessage(int data) {
		PanicMessage.data = data;
	}
	
	public static void handle(PanicMessage message, Supplier<NetworkEvent.Context> context) {
		context.get().enqueueWork(() ->  {
			@SuppressWarnings("unused")
			ServerPlayerEntity sender = context.get().getSender();
		});
		context.get().setPacketHandled(true);
	}
	
	public static <MSG> void encode(MSG message ,PacketBuffer buf) {
		buf.writeInt(data);
	}
	
	public PanicMessage getInstance() {
		return this;
	}
	
}