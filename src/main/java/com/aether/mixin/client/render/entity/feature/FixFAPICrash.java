package com.aether.mixin.client.render.entity.feature;

import net.fabricmc.fabric.impl.client.rendering.ArmorRenderingRegistryImpl;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ArmorRenderingRegistryImpl.class)
public class FixFAPICrash {
    @Inject(method = "getArmorTexture", at = @At("RETURN"), remap = false, cancellable = true)
    private static void getArmorTexture(LivingEntity entity, ItemStack stack, EquipmentSlot slot, boolean secondLayer, @Nullable String suffix, Identifier defaultTexture, CallbackInfoReturnable<Identifier> cir) {
        if (cir.getReturnValue() == null) {
            cir.setReturnValue(defaultTexture);
        }
    }
}
