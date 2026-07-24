package dev.chyken.ironmanarmormod.block;

import dev.chyken.ironmanarmormod.IronManArmorMod;
import dev.chyken.ironmanarmormod.item.IronManItems;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class IronManBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(IronManArmorMod.MODID);

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> supplier) {
        DeferredBlock<T> block = BLOCKS.register(name, supplier);
        IronManItems.ITEMS.registerSimpleBlockItem(block);

        return block;
    }
}
