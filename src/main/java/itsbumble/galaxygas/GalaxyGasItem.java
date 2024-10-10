package itsbumble.galaxygas;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.world.World;

public class GalaxyGasItem extends Item {
    public GalaxyGasItem(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        // Play sound on consumption
        if (!world.isClient()) {
            world.playSound(null, user.getX(), user.getY(), user.getZ(),
                    GalaxyGas.SOUNDEVENT, SoundCategory.PLAYERS, 2.0F, 1.0F);
        }

        return super.finishUsing(stack, world, user);
    }
}
