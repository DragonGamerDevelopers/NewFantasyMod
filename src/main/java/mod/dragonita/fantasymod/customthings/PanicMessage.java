package mod.dragonita.fantasymod.customthings;

import java.util.function.Supplier;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

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