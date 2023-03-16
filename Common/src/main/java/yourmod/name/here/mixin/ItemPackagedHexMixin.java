package yourmod.name.here.mixin;

import at.petrak.hexcasting.api.spell.casting.CastingContext;
import at.petrak.hexcasting.api.spell.casting.CastingHarness;
import at.petrak.hexcasting.api.spell.iota.Iota;
import at.petrak.hexcasting.api.spell.iota.PatternIota;
import at.petrak.hexcasting.common.items.magic.ItemPackagedHex;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import yourmod.name.here.client.ClientCastingStack;

import java.util.List;

@Mixin(ItemPackagedHex.class)
public class ItemPackagedHexMixin {
    @Inject(method = "use", at = @At(value = "INVOKE", target = "Lat/petrak/hexcasting/api/spell/casting/CastingHarness;executeIotas(Ljava/util/List;Lnet/minecraft/server/level/ServerLevel;)Lat/petrak/hexcasting/api/spell/casting/ControllerInfo;"), locals = LocalCapture.CAPTURE_FAILHARD, remap = false)
    private void onItemPackagedHexUse(Level world, Player player, InteractionHand usedHand, CallbackInfoReturnable<InteractionResultHolder<ItemStack>> cir, ItemStack stack, List<Iota> instrs, ServerPlayer sPlayer, CastingContext ctx, CastingHarness harness) {
        for(Iota i : instrs){
            if(i instanceof PatternIota pi){
                ClientCastingStack.addPattern(pi.getPattern(), 140);
            }
        }
    }
}
