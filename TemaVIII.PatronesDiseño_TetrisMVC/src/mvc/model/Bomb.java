package mvc.model;

import java.awt.*;

/**
 * Created by jahnaariellegoldman on 6/1/16.
 *
 * bomb piece looks like a square piece, but is black in color and clears the board (1000 points)
 */
public class Bomb extends SquarePiece {
    public Bomb() {
        super();
        initialize();
        mColor = Color.black;
    }


    }
