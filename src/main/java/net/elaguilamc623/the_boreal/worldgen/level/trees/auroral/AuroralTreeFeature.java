package net.elaguilamc623.the_boreal.worldgen.level.trees.auroral;

import com.mojang.serialization.Codec;
import net.elaguilamc623.the_boreal.registries.BorealBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;

import java.util.Random;

public class AuroralTreeFeature extends Feature<AuroralTreeConfiguration> {

    public AuroralTreeFeature(Codec<AuroralTreeConfiguration> codec) {
        super(codec);
    }

    public boolean place(FeaturePlaceContext<AuroralTreeConfiguration> context) {
        AuroralTreeConfiguration treeConfiguration = context.config();
        BlockPos pos = context.origin();
        RandomSource randomSource = context.random();
        WorldGenLevel level = context.level();
        int height_main = context.random().nextInt(treeConfiguration.sizeVariation) + treeConfiguration.minimumSize;
        int height_2 = height_main>10 ? (height_main/2)+randomSource.nextInt(3) : (height_main/2);
        int height_ne = randomSource.nextInt(5);
        int height_nw = randomSource.nextInt(5);
        int height_se = randomSource.nextInt(5);
        int height_sw = randomSource.nextInt(5);

        int check = 0;
        BlockPos.MutableBlockPos checkPos = pos.mutable();
        while (check <= height_main) {
            if(!checkReplaceable(level, checkPos)){
                return false;
            }
            else{
                checkPos.move(Direction.UP);
                check = check + 1;
            }
        }
        int placeCheck = 0;
        BlockPos.MutableBlockPos placePos = pos.mutable();
        while (placeCheck <= height_main) {
            placeLog(level, placePos, randomSource, treeConfiguration, Direction.Axis.Y);
            if(placeCheck > 5 && randomSource.nextInt(10) == 0){
                int rd = randomSource.nextInt(4);

                if(rd == 0) placeAuroraBranch(level, placePos.north(), randomSource, treeConfiguration, Direction.NORTH);
                if(rd == 1) placeAuroraBranch(level, placePos.south(), randomSource, treeConfiguration, Direction.SOUTH);
                if(rd == 2) placeAuroraBranch(level, placePos.east(),  randomSource, treeConfiguration, Direction.EAST);
                if(rd == 3) placeAuroraBranch(level, placePos.west(),  randomSource, treeConfiguration, Direction.WEST);
            }

            if(placeCheck == 0){
                placeRoot(level, placePos.below(), randomSource, treeConfiguration);
                placeRoot(level, placePos.below().north(), randomSource, treeConfiguration);
                placeRoot(level, placePos.below().north().east(), randomSource, treeConfiguration);
                placeRoot(level, placePos.below().north().west(), randomSource, treeConfiguration);
                placeRoot(level, placePos.below().south(), randomSource, treeConfiguration);
                placeRoot(level, placePos.below().south().east(), randomSource, treeConfiguration);
                placeRoot(level, placePos.below().south().west(), randomSource, treeConfiguration);
                placeRoot(level, placePos.below().east(), randomSource, treeConfiguration);
                placeRoot(level, placePos.below().west(), randomSource, treeConfiguration);
                if(randomSource.nextInt(2)==0) {
                    placeRoot(level, placePos.north().north(), randomSource, treeConfiguration);
                }
                if(randomSource.nextInt(2)==0) {
                    placeRoot(level, placePos.south().south(), randomSource, treeConfiguration);
                }
                if(randomSource.nextInt(2)==0) {
                    placeRoot(level, placePos.east().east(), randomSource, treeConfiguration);
                }
                if(randomSource.nextInt(2)==0) {
                    placeRoot(level, placePos.west().west(), randomSource, treeConfiguration);
                }
            }
            if(placeCheck == height_main){
                placeTop(level, placePos, randomSource, treeConfiguration);
            }
            placePos.move(Direction.UP);
            placeCheck = placeCheck + 1;
        }
        return true;
    }

    public void placeTop(LevelAccessor level, BlockPos pos, RandomSource randomSource, AuroralTreeConfiguration treeConfiguration) {
        BlockPos.MutableBlockPos placePos = new BlockPos.MutableBlockPos(pos.getX(),pos.getY()-3,pos.getZ());
        placeLeavesBlob(level, pos, randomSource, treeConfiguration);
        placeBranchesShort(level, placePos, randomSource, treeConfiguration);
        placePos.move(Direction.DOWN);placePos.move(Direction.DOWN);placePos.move(Direction.DOWN);
        placeBranchesShort(level, placePos, randomSource, treeConfiguration);
        placePos.move(Direction.DOWN);placePos.move(Direction.DOWN);placePos.move(Direction.DOWN);
        placeBranchesLong(level, placePos, randomSource, treeConfiguration);
        placePos.move(Direction.DOWN);placePos.move(Direction.DOWN);placePos.move(Direction.DOWN);
        placeBranchesLong(level, placePos, randomSource, treeConfiguration);
        if(randomSource.nextInt(6)==0){
            placePos.move(Direction.DOWN);placePos.move(Direction.DOWN);placePos.move(Direction.DOWN);
            placeBranchesLong(level, placePos, randomSource, treeConfiguration);
        }
        placePos.move(Direction.DOWN);placePos.move(Direction.DOWN);placePos.move(Direction.DOWN);
        placeBranchesXLong(level, placePos, randomSource, treeConfiguration);
        placePos.move(Direction.DOWN);placePos.move(Direction.DOWN);placePos.move(Direction.DOWN);
        placeBranchesXLong(level, placePos, randomSource, treeConfiguration);
    }

    public void placeBranchesShort(LevelAccessor level, BlockPos pos, RandomSource randomSource, AuroralTreeConfiguration treeConfiguration) {
        int type = randomSource.nextInt(2);
        if(type==0){
            placeLog(level, pos.north(), randomSource, treeConfiguration, Direction.Axis.Z);
            placeLeavesBlob(level,pos.north(), randomSource, treeConfiguration);

            placeLog(level, pos.south(), randomSource, treeConfiguration, Direction.Axis.Z);
            placeLeavesBlob(level,pos.south(), randomSource, treeConfiguration);

            placeLog(level, pos.below().east(), randomSource, treeConfiguration, Direction.Axis.X);
            placeLeavesBlob(level,pos.below().east(), randomSource, treeConfiguration);

            placeLog(level, pos.below().west(), randomSource, treeConfiguration, Direction.Axis.X);
            placeLeavesBlob(level,pos.below().west(), randomSource, treeConfiguration);
        }
        else{
            placeLog(level, pos.below().north(), randomSource, treeConfiguration, Direction.Axis.Z);
            placeLeavesBlob(level,pos.below().north(), randomSource, treeConfiguration);

            placeLog(level, pos.below().south(), randomSource, treeConfiguration, Direction.Axis.Z);
            placeLeavesBlob(level,pos.below().south(), randomSource, treeConfiguration);

            placeLog(level, pos.east(), randomSource, treeConfiguration, Direction.Axis.X);
            placeLeavesBlob(level,pos.east(), randomSource, treeConfiguration);

            placeLog(level, pos.west(), randomSource, treeConfiguration, Direction.Axis.X);
            placeLeavesBlob(level,pos.west(), randomSource, treeConfiguration);
        }
    }

    public void placeBranchesLong(LevelAccessor level, BlockPos pos, RandomSource randomSource, AuroralTreeConfiguration treeConfiguration) {
        int type = randomSource.nextInt(2);
        if(type==0){
            placeLog(level, pos.north(), randomSource, treeConfiguration, Direction.Axis.Z);
            placeLog(level, pos.north().north(), randomSource, treeConfiguration, Direction.Axis.Z);
            placeLeavesBlob(level,pos.north().north(), randomSource, treeConfiguration);

            placeLog(level, pos.south(), randomSource, treeConfiguration, Direction.Axis.Z);
            placeLog(level, pos.south().south(), randomSource, treeConfiguration, Direction.Axis.Z);
            placeLeavesBlob(level,pos.south().south(), randomSource, treeConfiguration);

            placeLog(level, pos.below().east(), randomSource, treeConfiguration, Direction.Axis.X);
            placeLog(level, pos.below().east().east(), randomSource, treeConfiguration, Direction.Axis.X);
            placeLeavesBlob(level,pos.below().east().east(), randomSource, treeConfiguration);

            placeLog(level, pos.below().west(), randomSource, treeConfiguration, Direction.Axis.X);
            placeLog(level, pos.below().west().west(), randomSource, treeConfiguration, Direction.Axis.X);
            placeLeavesBlob(level,pos.below().west().west(), randomSource, treeConfiguration);
        }
        else{
            placeLog(level, pos.below().north(), randomSource, treeConfiguration, Direction.Axis.Z);
            placeLog(level, pos.below().north().north(), randomSource, treeConfiguration, Direction.Axis.Z);
            placeLeavesBlob(level,pos.below().north().north(), randomSource, treeConfiguration);

            placeLog(level, pos.below().south(), randomSource, treeConfiguration, Direction.Axis.Z);
            placeLog(level, pos.below().south().south(), randomSource, treeConfiguration, Direction.Axis.Z);
            placeLeavesBlob(level,pos.below().south().south(), randomSource, treeConfiguration);

            placeLog(level, pos.east(), randomSource, treeConfiguration, Direction.Axis.X);
            placeLog(level, pos.east().east(), randomSource, treeConfiguration, Direction.Axis.X);
            placeLeavesBlob(level,pos.east().east(), randomSource, treeConfiguration);

            placeLog(level, pos.west(), randomSource, treeConfiguration, Direction.Axis.X);
            placeLog(level, pos.west().west(), randomSource, treeConfiguration, Direction.Axis.X);
            placeLeavesBlob(level,pos.west().west(), randomSource, treeConfiguration);
        }
    }

    public void placeBranchesXLong(LevelAccessor level, BlockPos pos, RandomSource randomSource, AuroralTreeConfiguration treeConfiguration) {
        int type = randomSource.nextInt(2);
        placeLeavesBlock(level,pos.north().east(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.north().east().north().east(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.south().east(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.south().east().south().east(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.north().west(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.north().west().north().west(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.south().west(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.south().west().south().west(),randomSource,treeConfiguration);

        placeLeavesBlock(level,pos.above().north().east(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.above().north().east().north().east(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.above().south().east(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.above().south().east().south().east(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.above().north().west(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.above().north().west().north().west(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.above().south().west(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.above().south().west().south().west(),randomSource,treeConfiguration);

        placeLeavesBlock(level,pos.above().above().north().east(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.above().above().north().east().north().east(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.above().above().south().east(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.above().above().south().east().south().east(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.above().above().north().west(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.above().above().north().west().north().west(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.above().above().south().west(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.above().above().south().west().south().west(),randomSource,treeConfiguration);

        placeLeavesBlock(level,pos.below().north().east(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.below().north().east().north().east(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.below().south().east(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.below().south().east().south().east(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.below().north().west(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.below().north().west().north().west(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.below().south().west(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.below().south().west().south().west(),randomSource,treeConfiguration);
        if(type==0){
            placeLog(level, pos.north(), randomSource, treeConfiguration, Direction.Axis.Z);
            placeLog(level, pos.north().north(), randomSource, treeConfiguration, Direction.Axis.Z);
            placeLog(level, pos.north().north().north(), randomSource, treeConfiguration, Direction.Axis.Z);
            placeLeavesBlob(level,pos.north().north().north(), randomSource, treeConfiguration);

            placeLog(level, pos.south(), randomSource, treeConfiguration, Direction.Axis.Z);
            placeLog(level, pos.south().south(), randomSource, treeConfiguration, Direction.Axis.Z);
            placeLog(level, pos.south().south().south(), randomSource, treeConfiguration, Direction.Axis.Z);
            placeLeavesBlob(level,pos.south().south().south(), randomSource, treeConfiguration);

            placeLog(level, pos.below().east(), randomSource, treeConfiguration, Direction.Axis.X);
            placeLog(level, pos.below().east().east(), randomSource, treeConfiguration, Direction.Axis.X);
            placeLog(level, pos.below().east().east().east(), randomSource, treeConfiguration, Direction.Axis.X);
            placeLeavesBlob(level,pos.below().east().east().east(), randomSource, treeConfiguration);

            placeLog(level, pos.below().west(), randomSource, treeConfiguration, Direction.Axis.X);
            placeLog(level, pos.below().west().west(), randomSource, treeConfiguration, Direction.Axis.X);
            placeLog(level, pos.below().west().west().west(), randomSource, treeConfiguration, Direction.Axis.X);
            placeLeavesBlob(level,pos.below().west().west().west(), randomSource, treeConfiguration);
        }
        else{
            placeLog(level, pos.below().north(), randomSource, treeConfiguration, Direction.Axis.Z);
            placeLog(level, pos.below().north().north(), randomSource, treeConfiguration, Direction.Axis.Z);
            placeLog(level, pos.below().north().north().north(), randomSource, treeConfiguration, Direction.Axis.Z);
            placeLeavesBlob(level,pos.below().north().north().north(), randomSource, treeConfiguration);

            placeLog(level, pos.below().south(), randomSource, treeConfiguration, Direction.Axis.Z);
            placeLog(level, pos.below().south().south(), randomSource, treeConfiguration, Direction.Axis.Z);
            placeLog(level, pos.below().south().south().south(), randomSource, treeConfiguration, Direction.Axis.Z);
            placeLeavesBlob(level,pos.below().south().south().south(), randomSource, treeConfiguration);

            placeLog(level, pos.east(), randomSource, treeConfiguration, Direction.Axis.X);
            placeLog(level, pos.east().east(), randomSource, treeConfiguration, Direction.Axis.X);
            placeLog(level, pos.east().east().east(), randomSource, treeConfiguration, Direction.Axis.X);
            placeLeavesBlob(level,pos.east().east().east(), randomSource, treeConfiguration);

            placeLog(level, pos.west(), randomSource, treeConfiguration, Direction.Axis.X);
            placeLog(level, pos.west().west(), randomSource, treeConfiguration, Direction.Axis.X);
            placeLog(level, pos.west().west().west(), randomSource, treeConfiguration, Direction.Axis.X);
            placeLeavesBlob(level,pos.west().west().west(), randomSource, treeConfiguration);
        }
    }

    public boolean placeLog(LevelAccessor level, BlockPos pos, RandomSource randomSource, AuroralTreeConfiguration treeConfiguration, Direction.Axis axis) {
        Random random = new Random();
        if(level.isOutsideBuildHeight(pos)){
            return true;
        }
        if(level.getBlockState(pos).is(BorealBlocks.GLACIAL_GRASS_BLOCK.get())){
            level.setBlock(pos, BorealBlocks.GLACIAL_DIRT.get().defaultBlockState(), 2);
        }
        else if(isReplaceable(level, pos)) {
            level.setBlock(pos, treeConfiguration.trunkProvider.getState(randomSource, pos).setValue(RotatedPillarBlock.AXIS, axis), 2);
        }
        else if(level.getBlockState(pos.below()).is(Blocks.GRASS_BLOCK)){
            level.setBlock(pos.below(), Blocks.DIRT.defaultBlockState(), 2);
        }

        return true;
    }

    public void placeAuroraBranch(LevelAccessor level, BlockPos pos, RandomSource randomSource, AuroralTreeConfiguration treeConfiguration, Direction direction) {
        if(level.isOutsideBuildHeight(pos)) return;

        if(level.getBlockState(pos).canBeReplaced()) {
            level.setBlock(
                    pos,
                    treeConfiguration.trunkProvider.getState(randomSource, pos)
                            .setValue(RotatedPillarBlock.AXIS, direction.getAxis()),
                    2
            );

            placeLeavesBlock(level, pos.relative(direction), randomSource, treeConfiguration);
            placeLeavesBlock(level, pos.above(), randomSource, treeConfiguration);
        }
    }


    public void placeRoot(LevelAccessor level, BlockPos pos, RandomSource randomSource, AuroralTreeConfiguration treeConfiguration) {
        Random random = new Random();
        int rd = random.nextInt(2)+4;
        int i = 0;
        BlockPos.MutableBlockPos placePos = pos.mutable();
        while(i<=rd){
            if(level.getBlockState(placePos).canBeReplaced()&&level.getBlockState(placePos.above()).is(BlockTags.DIRT)){
                level.setBlock(placePos, Blocks.HANGING_ROOTS.defaultBlockState(), 2);
                break;
            }
            else if(level.getBlockState(placePos).is(BlockTags.DIRT)||level.getBlockState(placePos).is(BlockTags.REPLACEABLE_BY_TREES)||level.isEmptyBlock(placePos)){
                placeLog(level, placePos, randomSource, treeConfiguration, Direction.Axis.Y);
            }
            else{
                break;
            }
            placePos.move(Direction.DOWN);
            i++;
        }
    }

    public boolean placeLeavesBlob(LevelAccessor level, BlockPos pos, RandomSource randomSource, AuroralTreeConfiguration treeConfiguration) {
        Random random = new Random();
        int n = random.nextInt(3);

        placeLeavesBlock(level, pos, randomSource, treeConfiguration);

        placeLeavesBlock(level, pos, randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.north(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.south(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.west(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.north().north(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.south().south(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.east().east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.west().west(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.north().east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.north().west(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.south().east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.south().west(), randomSource, treeConfiguration);

        placeLeavesBlock(level, pos.above(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.above().north(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.above().south(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.above().east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.above().west(), randomSource, treeConfiguration);
        if(randomSource.nextInt(3)==0) {
            placeLeavesBlock(level, pos.above().north().east(), randomSource, treeConfiguration);
        }
        if(randomSource.nextInt(3)==0) {
            placeLeavesBlock(level, pos.above().north().west(), randomSource, treeConfiguration);
        }
        if(randomSource.nextInt(3)==0) {
            placeLeavesBlock(level, pos.above().south().east(), randomSource, treeConfiguration);
        }
        if(randomSource.nextInt(3)==0) {
            placeLeavesBlock(level, pos.above().south().west(), randomSource, treeConfiguration);
        }

        placeLeavesBlock(level, pos.above().above(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.above().above().north(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.above().above().south(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.above().above().east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.above().above().west(), randomSource, treeConfiguration);

        placeLeavesBlock(level, pos.below(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.below().north(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.below().south(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.below().east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.below().west(), randomSource, treeConfiguration);

        placeLeavesBlock(level, pos.above().above().above(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.above().above().above().above(), randomSource, treeConfiguration);
        return true;
    }

    public boolean placeLeavesBlock(LevelAccessor level, BlockPos pos, RandomSource randomSource, AuroralTreeConfiguration treeConfiguration) {
        Random random = new Random();
        if(level.isOutsideBuildHeight(pos)){
            return true;
        }
        if(level.getBlockState(pos).canBeReplaced()) {
            level.setBlock(pos, treeConfiguration.foliageProvider.getState(randomSource, pos).setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        return true;
    }

    public boolean checkReplaceable(LevelAccessor level, BlockPos pos) {
        if(level.isOutsideBuildHeight(pos)){
            return false;
        }
        if(!isReplaceable(level, pos)) {
            return false;
        }
        return true;
    }

    public static boolean isReplaceableBlock(BlockState state) {
        return state.is(BlockTags.REPLACEABLE_BY_TREES)
                || state.is(Blocks.AIR);
    }

    public static boolean isReplaceable(LevelSimulatedReader reader, BlockPos pos) {
        return reader.isStateAtPosition(pos, AuroralTreeFeature::isReplaceableBlock);
    }

}