package xyz.merith.bakery.template;

import net.fabricmc.api.ModInitializer;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.merith.oven.ItemGroups.GroupFactory;

public class Entrypoint implements ModInitializer {
    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.
    public static final String MOD_ID = "bakers_template";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info(MOD_ID+" Loading!");

        SimpleBlocks.register();
        SimpleTools.register();

        ItemGroup.Builder TEMPLATE_GROUP = new GroupFactory().createGroup(Identifier.of(MOD_ID, "template"), Text.literal("Template"), Items.SCAFFOLDING);

        TEMPLATE_GROUP.entries((ctx, e) -> {
            // Add all tools from SIMPLE_TOOLS
            e.add(SimpleTools.SIMPLE_TOOLS.AXE);
            e.add(SimpleTools.SIMPLE_TOOLS.PICKAXE);
            e.add(SimpleTools.SIMPLE_TOOLS.SHOVEL);
            e.add(SimpleTools.SIMPLE_TOOLS.HOE);
            e.add(SimpleTools.SIMPLE_TOOLS.SWORD);

            // Add blocks
            e.add(SimpleBlocks.BLOCK_SOLID);
            e.add(SimpleBlocks.BLOCK_CLEAR);
        });
        new GroupFactory().register(Identifier.of(MOD_ID, "simple"), TEMPLATE_GROUP.build());
        LOGGER.info(MOD_ID+" Done!");
    }
}