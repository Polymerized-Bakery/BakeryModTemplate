package xyz.merith.Bakery.Template;

import net.fabricmc.api.ModInitializer;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.merith.oven.ItemGroups.GroupFactory;
import xyz.merith.oven.Tools.ToolFactory;
import xyz.merith.oven.Tools.ToolMaterialFactory;

public class BakersEntrypoint implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "bakers-template";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	@Override
	public void onInitialize() {
		LOGGER.info(MOD_ID+" Loading!");
		ItemGroup.Builder TEMPLATE_GROUP = new GroupFactory().createGroup(Identifier.of(MOD_ID, "template"), Text.literal("Template"), Items.SCAFFOLDING);
		ToolMaterial TEMPLATE_TOOL_MATERIAL = ToolMaterialFactory.Generate(
				BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
				1024,
				10F,
				5F,
				10,
				() -> Ingredient.ofItems(Items.DIRT) // this is what is used to repair
		);
		ToolFactory.Tools TEMPLATE_TOOLS = new ToolFactory().registerTools(MOD_ID, "template", TEMPLATE_TOOL_MATERIAL);

		TEMPLATE_GROUP.entries((ctx, e) -> {
			e.add(TEMPLATE_TOOLS.SHOVEL); // duplicate THIS LINE for every ITEM you wish to add to the group
		});
		new GroupFactory().register(Identifier.of(MOD_ID, "template"), TEMPLATE_GROUP.build());
		LOGGER.info(MOD_ID+" Done!");
	}
}