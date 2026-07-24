package dev.chyken.ironmanarmormod.block;

import dev.chyken.ironmanarmormod.IronManArmorMod;
import dev.chyken.ironmanarmormod.item.IronManItems;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class IronManBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(IronManArmorMod.MODID);

    public static final DeferredBlock<DropExperienceBlock> MAGNESIUM_ORE = registerBlock(
            "magnesium_ore", () -> new DropExperienceBlock(
                    ConstantInt.of(0),
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.STONE)
                            .instrument(NoteBlockInstrument.BASEDRUM)
                            .requiresCorrectToolForDrops()
                            .strength(3.0F, 3.0F)
            )
    );

    public static final DeferredBlock<DropExperienceBlock> TITANIUM_ORE = registerBlock(
            "titanium_ore", () -> new DropExperienceBlock(
                    UniformInt.of(3, 7),
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.STONE)
                            .instrument(NoteBlockInstrument.BASEDRUM)
                            .requiresCorrectToolForDrops()
                            .strength(3.0F, 3.0F)
            )
    );

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> supplier) {
        DeferredBlock<T> block = BLOCKS.register(name, supplier);
        IronManItems.ITEMS.registerSimpleBlockItem(block);

        return block;
    }
}
