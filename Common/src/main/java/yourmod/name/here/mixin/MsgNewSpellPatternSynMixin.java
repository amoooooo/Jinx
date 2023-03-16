package yourmod.name.here.mixin;

import at.petrak.hexcasting.api.spell.casting.CastingHarness;
import at.petrak.hexcasting.api.spell.casting.ControllerInfo;
import at.petrak.hexcasting.common.network.MsgNewSpellPatternSyn;
import kotlin.Triple;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import yourmod.name.here.client.ClientCastingStack;

@Mixin(MsgNewSpellPatternSyn.class)
public class MsgNewSpellPatternSynMixin {

    @Inject(method = "lambda$handle$0", at = @At(value = "INVOKE", target = "Lat/petrak/hexcasting/api/spell/casting/CastingHarness;executeIota(Lat/petrak/hexcasting/api/spell/iota/Iota;Lnet/minecraft/server/level/ServerLevel;)Lat/petrak/hexcasting/api/spell/casting/ControllerInfo;"), remap = false)
    public void onMsgNewSpellPatternSynHandle(ServerPlayer sender, CallbackInfo ci) {
        ClientCastingStack.addPattern(((MsgNewSpellPatternSyn)(Object)this).pattern(), 1238467235);
    }
}
