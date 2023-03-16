package yourmod.name.here.mixin;

import at.petrak.hexcasting.api.spell.casting.CastingHarness;
import at.petrak.hexcasting.api.spell.casting.eval.SpellContinuation;
import at.petrak.hexcasting.api.spell.iota.Iota;
import at.petrak.hexcasting.api.spell.iota.PatternIota;
import at.petrak.hexcasting.api.spell.math.HexPattern;
import net.minecraft.client.Minecraft;
import net.minecraft.server.level.ServerLevel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import yourmod.name.here.client.ClientCastingStack;

@Mixin(CastingHarness.class)
public class CastingHarnessMixin {

    @Inject(method = "updateWithPattern", at = @At(value = "INVOKE", target = "Lat/petrak/hexcasting/api/spell/casting/CastingHarness;getFunctionalData()Lat/petrak/hexcasting/api/spell/casting/eval/FunctionalData;", ordinal = -1), remap = false)
    private void onCastingHarnessUpdateWithPattern(HexPattern newPat, ServerLevel world, SpellContinuation continuation, CallbackInfoReturnable<CastingHarness.CastResult> cir) {
        //ClientCastingStack.addPattern(newPat);
    }

    @Inject(method = "getUpdate", at = @At("HEAD"), remap = false)
    private void onCastingHarnessGetUpdate(Iota iota, ServerLevel world, SpellContinuation continuation, CallbackInfoReturnable<CastingHarness.CastResult> cir) {
        if(iota instanceof PatternIota pi){
            ClientCastingStack.addPattern(pi.getPattern(), 140);
        }
    }
}
