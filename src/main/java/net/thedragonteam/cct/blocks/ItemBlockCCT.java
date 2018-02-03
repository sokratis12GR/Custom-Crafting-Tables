package net.thedragonteam.cct.blocks;

import net.minecraft.item.ItemBlock;

public class ItemBlockCCT extends ItemBlock {

    private CCT cct;
    private int blockNumber;

    public ItemBlockCCT(BlockCCT block) {
        super(block);
        cct = block.getCct();
        blockNumber = block.getBlockNumber();
    }

    public CCT getCct() {
        return cct;
    }

    public int getBlockNumber() {
        return blockNumber;
    }
}
