package yourmod.name.here.mixin;

import at.petrak.hexcasting.api.spell.casting.CastingHarness;
import at.petrak.hexcasting.api.spell.casting.eval.FrameEvaluate;
import at.petrak.hexcasting.api.spell.casting.eval.SpellContinuation;
import at.petrak.hexcasting.api.spell.iota.PatternIota;
import net.minecraft.server.level.ServerLevel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import yourmod.name.here.client.ClientCastingStack;

@Mixin(FrameEvaluate.class)
public class FrameEvaluateMixin {
    @Inject(method = "evaluate", at = @At("HEAD"), remap = false)
    private void onFrameEvaluateEvaluate(SpellContinuation continuation, ServerLevel level, CastingHarness harness, CallbackInfoReturnable<CastingHarness.CastResult> cir) {
//        if(((FrameEvaluate)(Object)this).getList().getCdr().getNonEmpty()){
//            for(int i = 0; i < ((FrameEvaluate)(Object)this).getList().size(); i++){
//                if(((FrameEvaluate)(Object)this).getList().getAt(i) instanceof PatternIota pi){
//                    ClientCastingStack.addPattern(pi.getPattern(), 140);
//                }
//            }
//        }
    }
}
