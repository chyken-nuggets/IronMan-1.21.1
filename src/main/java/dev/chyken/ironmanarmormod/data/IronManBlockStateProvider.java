package dev.chyken.ironmanarmormod.data;

import dev.chyken.ironmanarmormod.IronManArmorMod;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class IronManBlockStateProvider extends BlockStateProvider {
    public IronManBlockStateProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, IronManArmorMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
    }

    private void blockWithItem(Block block) {
        simpleBlockWithItem(block, cubeAll(block));
    }
}