package dev.chyken.ironmanarmormod.event;

import dev.chyken.ironmanarmormod.item.IronManItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.AnvilUpdateEvent;

import java.util.Set;

public class IronManAnvilRecipeHandler {
    @SubscribeEvent
    public void onAnvilUpdate(AnvilUpdateEvent event) {
        Set<Item> input = Set.of(event.getLeft().getItem(), event.getRight().getItem());
        if ((input.contains(Items.COAL) || input.contains(Items.CHARCOAL)) && input.contains(Items.IRON_INGOT)) {
            ItemStack output = new ItemStack(IronManItems.STEEL_SHEET.get());

            event.setOutput(output);
            event.setCost(1);
        }
    }
}
