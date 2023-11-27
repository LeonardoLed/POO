package mvc.view;

import mvc.controller.Game;
import mvc.model.*;

import java.awt.*;


public class GamePanel extends Panel {

    // ==============================================================
    // FIELDS
    // ==============================================================

    // The following "off" vars are used for the off-screen double-bufferred image.
    private Dimension dimOff;
    private Image imgOff;
    private Graphics grpOff;
    public Grid grid = new Grid();
    private GameFrame gmf;
    private Font fnt = new Font("SansSerif", Font.BOLD, 12);
    private Font fntBig = new Font("SansSerif", Font.BOLD + Font.ITALIC, 36);
    private FontMetrics fmt;
    private int nFontWidth;
    private int nFontHeight;
    private String strDisplay = "";
    public Tetromino tetrOnDeck;
    public Tetromino tetrCurrent;


    // ==============================================================
    // CONSTRUCTOR
    // ==============================================================

    public GamePanel(Dimension dim) {
        gmf = new GameFrame();
        gmf.getContentPane().add(this);
        gmf.pack();
        initView();

        gmf.setSize(dim);
        gmf.setTitle("Tetris");
        gmf.setResizable(false);
        gmf.setVisible(true);
        this.setFocusable(true);
    }


    // ==============================================================
    // METHODS
    // ==============================================================

    private void drawScore(Graphics g) {
        g.setColor(Color.white);
        g.setFont(fnt);
        if (CommandCenter.getInstance().getScore() != 0) {
            g.drawString("SCORE :  " + CommandCenter.getInstance().getScore() + "    HIGH SCORE : " + CommandCenter.getInstance().getHighScore(), nFontWidth, nFontHeight);
        } else {
            g.drawString("SCORE : 0 " + "   HIGH SCORE : " + CommandCenter.getInstance().getHighScore(), nFontWidth, nFontHeight);
        }
    }

    @SuppressWarnings("unchecked")
    public void update(Graphics g) {
        Dimension d = this.getSize();
        if (grpOff == null || d.width != dimOff.width
                || d.height != dimOff.height) {
            dimOff = d;
            imgOff = createImage(d.width, d.height);
            grpOff = imgOff.getGraphics();
        }
        // Fill in background with blue.
        grpOff.setColor(Color.blue);
        grpOff.fillRect(0, 0, d.width, d.height);
        grpOff.setColor(Color.white);
        grpOff.setFont(fnt);


        if (CommandCenter.getInstance().isGameOver()) {
            displayTextOnScreen();
        } else if (!CommandCenter.getInstance().isPlaying()) {
            strDisplay = "TETRIS";
//			grpOff.drawString(strDisplay, (d.width - fmt.stringWidth(strDisplay)) / 2, d.height/2);
            if (!CommandCenter.getInstance().isLoaded()) {
                strDisplay = "Loading sounds... ";
                grpOff.drawString(strDisplay, (d.width - fmt.stringWidth(strDisplay)) / 2, d.height / 4);
            } else {
                displayStartText();


            }
        } else if (CommandCenter.getInstance().isPaused()) {
            strDisplay = "Game Paused";
            grpOff.drawString(strDisplay,
                    (Game.DIM.width - fmt.stringWidth(strDisplay)) / 2, Game.DIM.height / 4);
        }


        //playing and not paused!
        else {
            int nBy = (d.height - 150) / Grid.ROWS;
            int nBx = (d.width - 150) / Grid.COLS;
            Block[][] b = grid.getBlocks();

            for (int i = 0; i < b.length; i++) {
                for (int j = 0; j < b[0].length; j++) {
                    grpOff.setColor(b[i][j].getColor());
                    grpOff.fill3DRect(j * nBx, i * nBy + 150, nBx, nBy, true);
                }
            }


            grpOff.setColor(Color.white);
            grpOff.draw3DRect(d.width - 150, 0, 150, d.height, true);
            grpOff.draw3DRect(d.width - 140, 10, 130, 130, true);
            boolean[][] lts = tetrOnDeck.getColoredSquares(tetrOnDeck.getOrientation());
            Color c = tetrOnDeck.getColor();
            for (int i = 0; i < Grid.DIM; i++) {
                for (int j = 0; j < Grid.DIM; j++) {
                    if (lts[j][i]) {
                        grpOff.setColor(c);
                        grpOff.fill3DRect(i * nBx + 360, j * nBy + 20, nBx, nBy, true);
                    }
                }
//
//			}
//			}

            }
            drawScore(grpOff);


        }
        g.drawImage(imgOff, 0, 0, this);

    }


    private void initView() {
        Graphics g = getGraphics();            // get the graphics context for the panel
        g.setFont(fnt);                        // take care of some simple font stuff
        fmt = g.getFontMetrics();
        nFontWidth = fmt.getMaxAdvance();
        nFontHeight = fmt.getHeight();
        g.setFont(fntBig);                    // set font info
    }

    // This method draws some text to the middle of the screen before/after a game
    private void displayStartText() {
        strDisplay = "TETRIS";
        grpOff.drawString(strDisplay,
                (Game.DIM.width - fmt.stringWidth(strDisplay)) / 2, Game.DIM.height / 4);

        strDisplay = "use the arrow keys to move the pieces";
        grpOff.drawString(strDisplay,
                (Game.DIM.width - fmt.stringWidth(strDisplay)) / 2, Game.DIM.height / 4
                        + nFontHeight + 40);

        strDisplay = "use the space bar to rotate the piece";
        grpOff.drawString(strDisplay,
                (Game.DIM.width - fmt.stringWidth(strDisplay)) / 2, Game.DIM.height / 4
                        + nFontHeight + 80);

        strDisplay = "black squares are bombs and will clear the board";
        grpOff.drawString(strDisplay, (Game.DIM.width - fmt.stringWidth(strDisplay)) / 2, Game.DIM.height / 4
                + nFontHeight + 120);

        strDisplay = "'S' to Start";
        grpOff.drawString(strDisplay,
                (Game.DIM.width - fmt.stringWidth(strDisplay)) / 2, Game.DIM.height / 4
                        + nFontHeight + 160);

        strDisplay = "'P' to Pause";
        grpOff.drawString(strDisplay,
                (Game.DIM.width - fmt.stringWidth(strDisplay)) / 2, Game.DIM.height / 4
                        + nFontHeight + 200);

        strDisplay = "'Q' to Quit";
        grpOff.drawString(strDisplay,
                (Game.DIM.width - fmt.stringWidth(strDisplay)) / 2, Game.DIM.height / 4
                        + nFontHeight + 240);
        strDisplay = "'M' to Mute or Play Music";
        grpOff.drawString(strDisplay,
                (Game.DIM.width - fmt.stringWidth(strDisplay)) / 2, Game.DIM.height / 4
                        + nFontHeight + 280);


    }

    private void displayTextOnScreen() {

        strDisplay = "GAME OVER";
        grpOff.drawString(strDisplay,
                (Game.DIM.width - fmt.stringWidth(strDisplay)) / 2, Game.DIM.height / 4);

        strDisplay = "use the arrow keys to move the pieces";
        grpOff.drawString(strDisplay,
                (Game.DIM.width - fmt.stringWidth(strDisplay)) / 2, Game.DIM.height / 4
                        + nFontHeight + 40);

        strDisplay = "use the space bar to rotate the piece";
        grpOff.drawString(strDisplay,
                (Game.DIM.width - fmt.stringWidth(strDisplay)) / 2, Game.DIM.height / 4
                        + nFontHeight + 80);

        strDisplay = "'S' to Start";
        grpOff.drawString(strDisplay,
                (Game.DIM.width - fmt.stringWidth(strDisplay)) / 2, Game.DIM.height / 4
                        + nFontHeight + 120);

        strDisplay = "'P' to Pause";
        grpOff.drawString(strDisplay,
                (Game.DIM.width - fmt.stringWidth(strDisplay)) / 2, Game.DIM.height / 4
                        + nFontHeight + 160);

        strDisplay = "'Q' to Quit";
        grpOff.drawString(strDisplay,
                (Game.DIM.width - fmt.stringWidth(strDisplay)) / 2, Game.DIM.height / 4
                        + nFontHeight + 200);
        strDisplay = "'M' to Mute or Play Music";
        grpOff.drawString(strDisplay,
                (Game.DIM.width - fmt.stringWidth(strDisplay)) / 2, Game.DIM.height / 4
                        + nFontHeight + 240);

    }

    public GameFrame getFrm() {
        return this.gmf;
    }

    public void setFrm(GameFrame frm) {
        this.gmf = frm;
    }
}