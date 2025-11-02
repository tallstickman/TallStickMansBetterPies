package tv.tallstickman.betterpies;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.event.GameEvent;

public class BlackberryBushBlock
        extends SweetBerryBushBlock {

    public BlackberryBushBlock(Settings settings) {
        super(settings);

    }

    @Override
    public ItemStack getPickStack(WorldView world, BlockPos pos, BlockState state) {
        return new ItemStack(Fruits.BLACKBERRIES_ITEM);
    }

    // If we don't give these natural spawns immunity it's a horror show.
    private static final List<EntityType<?>> IMMUNE_ENTITY_TYPES = List.of(
            EntityType.BEE,
            EntityType.FOX,
            EntityType.CHICKEN,
            EntityType.COW,
            EntityType.LLAMA,
            EntityType.PIG,
            EntityType.SHEEP);

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (!(entity instanceof LivingEntity) || IMMUNE_ENTITY_TYPES.contains(entity.getType())) {
            return;
        }
        entity.slowMovement(state, new Vec3d(0.8f, 0.75, 0.8f));
        ServerWorld serverWorld = (ServerWorld) world;
        if ((Integer) state.get(AGE) != 0) {
            Vec3d vec3d = entity.isControlledByPlayer() ? entity.getMovement()
                    : entity.getLastRenderPos().subtract(entity.getPos());
            if (vec3d.horizontalLengthSquared() > 0.0) {
                double d = Math.abs(vec3d.getX());
                double e = Math.abs(vec3d.getZ());
                if (d >= 0.003000000026077032 || e >= 0.003000000026077032) {
                    entity.damage(serverWorld, world.getDamageSources().sweetBerryBush(), 1.0F);
                }
            }
        }
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        TallStickMansBetterPies.LOGGER.info("Used a blackberry bush!");
        boolean bl;
        int i = state.get(AGE);
        bl = i == 3;
        // if (!bl && player.getStackInHand(hand).isOf(Items.BONE_MEAL)) {
        // return ActionResult.PASS;
        // }
        if (i > 1) {
            int j = 1 + world.random.nextInt(2);
            SweetBerryBushBlock.dropStack(world, pos, new ItemStack(Fruits.BLACKBERRIES_ITEM, j + (bl ? 1 : 0)));
            world.playSound(null, pos, SoundEvents.BLOCK_SWEET_BERRY_BUSH_PICK_BERRIES, SoundCategory.BLOCKS, 1.0f,
                    0.8f + world.random.nextFloat() * 0.4f);
            BlockState blockState = (BlockState) state.with(AGE, 1);
            world.setBlockState(pos, blockState, Block.NOTIFY_LISTENERS);
            world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(player, blockState));
            return ActionResult.SUCCESS;
        }
        return super.onUse(state, world, pos, player, hit);
    }

}
