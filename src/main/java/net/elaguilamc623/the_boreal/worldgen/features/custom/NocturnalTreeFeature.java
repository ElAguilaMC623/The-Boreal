package net.elaguilamc623.the_boreal.worldgen.features.custom;

import com.google.common.collect.Lists;
import net.elaguilamc623.complementary_core.world.features.custom.AbstractTreeFeature;
import net.elaguilamc623.the_boreal.worldgen.features.custom.config.NocturnalTreeConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NocturnalTreeFeature extends AbstractTreeFeature<NocturnalTreeConfig> {
    private static final Direction[] HORIZONTALS = new Direction[]{Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST};

    private int calculatedHeight;
    private final Set<Branch> calculatedBranches = new HashSet<>();

    public NocturnalTreeFeature() {
        super(NocturnalTreeConfig.CODEC);
    }

    @Override
    protected boolean canTreeFit(WorldGenLevel level, BlockPos pos, NocturnalTreeConfig config) {
        this.calculatedHeight = config.heightRange().sample(level.getRandom());
        this.calculatedBranches.clear();

        if (pos.getY() < level.getMinBuildHeight() || pos.getY() + this.calculatedHeight + 2 > level.getMaxBuildHeight()) {
            return false;
        }

        BlockPos min = pos.offset(-1, 1, -1);
        BlockPos max = pos.offset(1, this.calculatedHeight, 1);

        for (BlockPos checkPos : BlockPos.betweenClosed(min, max)) {
            BlockState state = level.getBlockState(checkPos);

            if (!state.isAir() && !state.canBeReplaced() && !(state.getBlock() instanceof LeavesBlock)) {
                return false;
            }
        }
        return true;
    }


    @Override
    protected boolean placeTrunk(WorldGenLevel level, RandomSource random, BlockPos pos, NocturnalTreeConfig config) {
        BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos().set(pos);

        for (int localY = 0; localY < this.calculatedHeight; ++localY) {
            mutablePos.setY(pos.getY() + localY);
            level.setBlock(mutablePos, config.toPlace().getState(random, pos), 2);
        }

        List<Direction> availableSides = Lists.newArrayList(HORIZONTALS);
        int rootCount = random.nextInt(3) + 1;

        for (int i = 0; i < rootCount; ++i) {
            if (availableSides.isEmpty()) break;
            Direction side = availableSides.remove(random.nextInt(availableSides.size()));
            BlockPos rootOrigin = pos.relative(side);
            int rootHeight = random.nextInt(3) + 1;

            for (int localY = 0; localY < rootHeight; ++localY) {
                mutablePos.set(rootOrigin.getX(), rootOrigin.getY() + localY, rootOrigin.getZ());
                level.setBlock(mutablePos, config.toPlace().getState(random, pos), 2);
            }
        }

        this.calculateBranches(level, random, pos, this.calculatedHeight);
        for (Branch branch : this.calculatedBranches) {
            BlockState branchState = config.toPlace().getState(random, pos).setValue(RotatedPillarBlock.AXIS, branch.getAxis());
            level.setBlock(branch.pos, branchState, 2);
        }

        return true;
    }

    @Override
    protected void placeLeaves(WorldGenLevel level, RandomSource random, BlockPos pos, NocturnalTreeConfig config) {
        BlockState leavesState = config.leavesProvider().getState(random, pos);

        if (leavesState.isAir()) {
            this.calculatedBranches.clear();
            return;
        }

        if (this.calculatedBranches.isEmpty()) {
            this.calculateBranches(level, random, pos, this.calculatedHeight);
        }

        BlockPos canopyCenter = pos.above(this.calculatedHeight - 1);
        Set<BlockPos> leafPositions = this.produceSafeBlob(canopyCenter, 2, 1, 2);
        leafPositions = this.droopLeaves(leafPositions, random, 3);

        for (Branch branch : this.calculatedBranches) {
            leafPositions.addAll(this.collectBranchLeavesSafe(branch, random));
        }

        if (leavesState.hasProperty(LeavesBlock.DISTANCE)) {
            leavesState = leavesState.setValue(LeavesBlock.DISTANCE, 1);
        }

        for (BlockPos leafPos : leafPositions) {
            BlockState currentState = level.getBlockState(leafPos);
            if (currentState.isAir() || currentState.canBeReplaced() || currentState.getBlock() instanceof LeavesBlock) {
                level.setBlock(leafPos, leavesState, 2);
            }
        }

        this.calculatedBranches.clear();
    }


    private Set<BlockPos> collectBranchLeavesSafe(Branch branch, RandomSource random) {
        Set<BlockPos> branchLeaves = new HashSet<>();
        BlockPos.MutableBlockPos currentPos = branch.pos.mutable();

        for (int step = 0; step < 3; ++step) {
            currentPos.move(branch.direction);
            if (step % 2 == 0) {
                currentPos.move(Direction.DOWN);
            }

            branchLeaves.addAll(this.produceSafeBlob(currentPos.immutable(), 1, 1, 1));
        }

        return this.droopLeaves(branchLeaves, random, 2);
    }

    private Set<BlockPos> produceSafeBlob(BlockPos center, int radiusX, int radiusY, int radiusZ) {
        Set<BlockPos> positions = new HashSet<>();

        for (int x = -radiusX; x <= radiusX; ++x) {
            for (int y = -radiusY; y <= radiusY; ++y) {
                for (int z = -radiusZ; z <= radiusZ; ++z) {
                    if ((x * x) + (y * y) + (z * z) <= (radiusX * radiusZ) + 1) {
                        positions.add(center.offset(x, y, z));
                    }
                }
            }
        }

        return positions;
    }

    private void calculateBranches(WorldGenLevel world, RandomSource random, BlockPos origin, int height) {
        int minBranchHeight = 3;
        int maxBranchHeight = height - 4;
        int heightRange = maxBranchHeight - minBranchHeight;

        if (heightRange <= 0) return;

        int branchCount = heightRange / 3;
        if (branchCount <= 0) branchCount = 1;
        double normalizedSpacing = (double) heightRange / (double) branchCount;
        Direction lastDirection = null;

        for (int branch = 0; branch < branchCount; ++branch) {
            int y = Mth.floor((double) (minBranchHeight + 1) + (double) branch * normalizedSpacing);

            Direction direction = null;
            while (direction == null || direction == lastDirection) {
                direction = HORIZONTALS[random.nextInt(HORIZONTALS.length)];
            }

            lastDirection = direction;
            BlockPos branchPos = origin.above(y).relative(direction);

            if (world.isEmptyBlock(branchPos) || world.getBlockState(branchPos).getBlock() instanceof LeavesBlock) {
                float outerAngle = direction.toYRot();
                float angle = random.nextFloat() * 90.0F + outerAngle - 45.0F;
                this.calculatedBranches.add(new Branch(branchPos, direction, angle));
            }
        }
    }

    private Set<BlockPos> droopLeaves(Set<BlockPos> leafPositions, RandomSource random, int amount) {
        Set<BlockPos> droopedLeaves = new HashSet<>(leafPositions);
        for (BlockPos leafPos : leafPositions) {
            int droopAmount = random.nextInt(amount);
            for (int i = 0; i < droopAmount; ++i) {
                droopedLeaves.add(leafPos.below(i));
            }
        }
        return droopedLeaves;
    }

    private static class Branch {
        protected final BlockPos pos;
        protected final Direction direction;
        protected final float angle;

        public Branch(BlockPos pos, Direction direction, float angle) {
            this.pos = pos;
            this.direction = direction;
            this.angle = angle;
        }

        public Direction.Axis getAxis() {
            return this.direction.getAxis();
        }
    }
}
