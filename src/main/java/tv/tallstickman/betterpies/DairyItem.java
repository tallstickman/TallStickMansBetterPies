package tv.tallstickman.betterpies;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;

public class DairyItem
extends Item{

    public DairyItem(Settings settings) {
        super(settings);
    }
    
    // Override the finishUsing() method so that we can give back the empty buckets used to make the cheese.  Buckets are expensive!  Let's be nice.
    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        ItemStack itemStack = super.finishUsing(stack, world, user);
        if (user instanceof PlayerEntity && ((PlayerEntity)user).getAbilities().creativeMode) {
            return itemStack;
        }
        return new ItemStack(Items.BUCKET);
    }

}
