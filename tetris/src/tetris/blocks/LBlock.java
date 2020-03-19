package tetris.blocks;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import tetris.TetrisGameLogic;

public class LBlock extends AbstractBlock {
    public LBlock(Rectangle a, Rectangle b, Rectangle c, Rectangle d, Color color) {
        super(a, b, c, d, color);
    }

    @Override
    public void rotateBlock(TetrisGameLogic gameLogic) {

    }
}
