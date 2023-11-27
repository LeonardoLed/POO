package mvc.model;

import java.awt.*;

/**
 * Created by jahnaariellegoldman on 5/24/16.
 * <p>
 * Represents 1 block of the grid
 */
public class Block {


    private boolean mOccupied;
    private Color mColor;
    private int mRow;
    private int mCol;
    private static int POINTS = 100;

    public int getRow() {
        return mRow;
    }

    public void setRow(int row) {
        mRow = row;
    }

    public boolean isOccupied() {
        return mOccupied;
    }

    public Color getColor() {
        return mColor;
    }

    public void setColor(Color color) {
        mColor = color;
    }

    public int getCol() {
        return mCol;
    }

    public Block(boolean bOccupied, Color color, int nRow, int nCol) {
        mOccupied = bOccupied;
        mColor = color;
        mRow = nRow;
        mCol = nCol;
    }

    public int getPoints() {
        return POINTS;
    }

}
