package yourmod.name.here.mixin;

import at.petrak.hexcasting.common.network.MsgNewSpellPatternAck;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import yourmod.name.here.client.ClientCastingStack;

@Mixin(at.petrak.hexcasting.common.network.MsgNewSpellPatternAck.class)
public class MsgNewSpellPatternAckMixin {

    @Inject(method = "handle", at = @At("HEAD"), remap = false)
    private static void onMsgNewSpellPatternAckHandle(MsgNewSpellPatternAck self, CallbackInfo ci) {
        if(self.info().isStackClear()){
            ClientCastingStack.getPatterns().forEach(hex -> {
                hex.setLifetime(140);
            });
        }
    }
}
