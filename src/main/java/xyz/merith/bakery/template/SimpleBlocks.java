package xyz.merith.bakery.template;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import xyz.merith.oven.Blocks.BlockFactory;

public class SimpleBlocks {
    public static final Block BLOCK_SOLID;
    public static final Block BLOCK_CLEAR;

    static {
        BLOCK_SOLID = new BlockFactory().registerSolidBlock(Entrypoint.MOD_ID, "block_solid", AbstractBlock.Settings.create());
        BLOCK_CLEAR = new BlockFactory().registerSolidBlock(Entrypoint.MOD_ID, "block_clear", AbstractBlock.Settings.create());
    }

    public static void register() { }
}
