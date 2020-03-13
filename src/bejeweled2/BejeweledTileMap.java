package bejeweled2;

import tmge.Tile;
import tmge.TileEntity;
import tmge.TileMap;

import java.util.Random;

public class BejeweledTileMap extends TileMap {
    Tile[] fruits;

    public BejeweledTileMap(int row, int col) {
        super(row, col);
        fruits = new Tile[7];
        fruits[0] = new Tile("images/bejeweled2/fruits/blue.png");
        fruits[1] = new Tile("images/bejeweled2/fruits/green.png");
        fruits[2] = new Tile("images/bejeweled2/fruits/orange.png");
        fruits[3] = new Tile("images/bejeweled2/fruits/purple.png");
        fruits[4] = new Tile("images/bejeweled2/fruits/red.png");
        fruits[5] = new Tile("images/bejeweled2/fruits/white.png");
        fruits[6] = new Tile("images/bejeweled2/fruits/yellow.png");
    }

    @Override
    public void fillMap() {
        Random random = new Random();
        TileEntity tempTileEntity;
        int row = this.getWidth();
        int column = this.getLength();
        for(int r = 0; r < row; r++) {
            for(int c = 0; c < column; c++) {
                int randImageIndex = random.nextInt(this.fruits.length);
                tempTileEntity = new TileEntity(fruits[randImageIndex].getTileEntity().getIconSrc());
                this.cellInsert(r,c,tempTileEntity);
                this.boardInsert(r,c,randImageIndex);
            }
        }
    }

    public Tile[] getFruits() {
        return fruits;
    }

    public void setFruits(Tile[] fruits) {
        this.fruits = fruits;
    }
}
