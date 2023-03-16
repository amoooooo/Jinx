package yourmod.name.here.mixin;

import at.petrak.hexcasting.common.items.ItemStaff;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import yourmod.name.here.client.ClientCastingStack;

@Mixin(ItemStaff.class)
public class ItemStaffMixin {
    @Inject(method = "use", at = @At(value = "INVOKE", target = "Lat/petrak/hexcasting/xplat/IXplatAbstractions;clearCastingData(Lnet/minecraft/server/level/ServerPlayer;)V"))
    private void onItemStaffUse(Level world, Player player, InteractionHand hand, CallbackInfoReturnable<InteractionResultHolder<ItemStack>> cir) {
        ClientCastingStack.clear();
    }
}
