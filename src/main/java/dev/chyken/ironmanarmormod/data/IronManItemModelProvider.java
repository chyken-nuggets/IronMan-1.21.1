package dev.chyken.ironmanarmormod.data;

import dev.chyken.ironmanarmormod.IronManArmorMod;
import dev.chyken.ironmanarmormod.item.IronManItems;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.BlockItem;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class IronManItemModelProvider extends ItemModelProvider {
    public IronManItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, IronManArmorMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        IronManItems.ITEMS.getEntries().forEach(item -> {
            if (item.get() instanceof BlockItem blockItem) {
                String blockName = blockItem.getBlock().builtInRegistryHolder().key().location().getPath();
                withExistingParent(item.getId().getPath(), modLoc("block/" + blockName));
            } else {
                basicItem(item.get());
            }
        });
    }
}