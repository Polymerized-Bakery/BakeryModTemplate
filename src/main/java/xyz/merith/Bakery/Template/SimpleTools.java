package xyz.merith.bakery.template;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BlockTags;
import xyz.merith.oven.Tools.ToolFactory;
import xyz.merith.oven.Tools.ToolMaterialFactory;

public class SimpleTools {
    public static final ToolMaterial SIMPLE_TOOL_MATERIAL;
    public static final ToolFactory.Tools SIMPLE_TOOLS;

    static {
        SIMPLE_TOOL_MATERIAL = ToolMaterialFactory.Generate(
                BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
                128,
                8F,
                4F,
                8,
                () -> Ingredient.ofItems(Items.DIRT) // this is what is used to repair
        );
        SIMPLE_TOOLS = new ToolFactory().registerTools(Entrypoint.MOD_ID, "simple", SIMPLE_TOOL_MATERIAL);
    }

    public static void register() { }
}
