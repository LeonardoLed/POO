package mvc.controller;

import mvc.model.*;
import mvc.view.GamePanel;
import sounds.Sound;
import javax.sound.sampled.Clip;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

// ===============================================
// == This Game class is the CONTROLLER
// ===============================================

public class Game implements Runnable, KeyListener {

    // ===============================================
    // FIELDS
    // ===============================================

    public static final Dimension DIM = new Dimension(500, 700); //the dimension of the game.
    public static final int THRESHOLD = 2400; // threshold to increase speed as score goes up
    public static int nAutoDelay = 300; // how fast the tetrominoes come down
    public static final int TETROMINO_NUMBER = 100; // for tetromino probability of which comes next
    private GamePanel gmpPanel;
    public static Random R = new Random();
    public final static int ANIM_DELAY = 45; // milliseconds between screen updates (animation)
    //	threads for game play
    private Thread thrAnim;
    private Thread thrAutoDown;
    private Thread thrLoaded;
    private long lTime; // time stamp
    private long lTimeStep;
    final static int PRESS_DELAY = 40; // avoid double pressing
    private boolean bMuted = true;


    private final int PAUSE = 80, // p key
            QUIT = 81, // q key
            LEFT = 37, // move piece left; left arrow
            RIGHT = 39, // move piece right; right arrow
            START = 83, // s key
            MUTE = 77, // m-key
            DOWN = 40, // move piece faster down
            SPACE = 32; // rotate piece


    private Clip clpMusicBackground; // background music
    private Clip clpBomb; // noise for when bomb (black square piece) hits


    // ===============================================
    // ==CONSTRUCTOR
    // ===============================================

    public Game() {

        gmpPanel = new GamePanel(DIM);
        gmpPanel.addKeyListener(this);
        clpBomb = Sound.clipForLoopFactory("explosion-02.wav");
        clpMusicBackground = Sound.clipForLoopFactory("tetris_tone_loop_1_.wav");


    }

    // ===============================================
    // ==METHODS
    // ===============================================

    public static void main(String args[]) {
        EventQueue.invokeLater(() -> {
            try {
                Game game = new Game(); // construct itself
                game.fireUpThreads();

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }


    private void fireUpThreads() { // called initially
        if (thrAnim == null) {
            thrAnim = new Thread(this); // pass the thread a runnable object (this)
            thrAnim.start();
        }
        if (thrAutoDown == null) {
            thrAutoDown = new Thread(this);
            thrAutoDown.start();
        }

        if (!CommandCenter.getInstance().isLoaded() && thrLoaded == null) {
            thrLoaded = new Thread(this);
            thrLoaded.start();
        }
    }

    // implements runnable - must have run method
    public void run() {

        // lower this thread's priority; let the "main" aka 'Event Dispatch'
        // thread do what it needs to do first
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);

        // and get the current time
        long lStartTime = System.currentTimeMillis();
        if (!CommandCenter.getInstance().isLoaded() && Thread.currentThread() == thrLoaded) {
            CommandCenter.getInstance().setLoaded(true);
        }

        // thread animates the scene
        while (Thread.currentThread() == thrAutoDown) {
            if (!CommandCenter.getInstance().isPaused() && CommandCenter.getInstance().isPlaying()) {
                tryMovingDown();
            }
            gmpPanel.repaint();
            try {
                lStartTime += nAutoDelay;
                Thread.sleep(Math.max(0, lStartTime - System.currentTimeMillis()));
            } catch (InterruptedException e) {
                break;
            }
        }
        while (Thread.currentThread() == thrAnim) {
            if (!CommandCenter.getInstance().isPaused() && CommandCenter.getInstance().isPlaying()) {
                updateGrid();
            }
            gmpPanel.repaint();


            try {
                // The total amount of time is guaranteed to be at least ANIM_DELAY long.  If processing (update)
                // between frames takes longer than ANIM_DELAY, then the difference between lStartTime -
                // System.currentTimeMillis() will be negative, then zero will be the sleep time
                lStartTime += ANIM_DELAY;
                Thread.sleep(Math.max(0, lStartTime - System.currentTimeMillis()));
            } catch (InterruptedException e) {
                // just skip this frame -- continue;
                break;
            }
        } // end while
    } // end run

    private void updateGrid() {
        gmpPanel.grid.setBlocks(gmpPanel.tetrCurrent);

    }


    private void tryMovingDown() {
//		uses a test tetromino to see if can move down in board
        Tetromino tetrTest = gmpPanel.tetrCurrent.cloneTetromino();
        tetrTest.moveDown();
        if (gmpPanel.grid.requestDown(tetrTest)) {
            gmpPanel.tetrCurrent.moveDown();
            tetrTest = null;
        }
//		once bomb hits the bottom, plays bomb noise, clears the board and adds to score
        else if (CommandCenter.getInstance().isPlaying() && gmpPanel.tetrCurrent instanceof Bomb) {
            clpBomb.stop();
            clpBomb.flush();
            clpBomb.setFramePosition(0);
            clpBomb.start();
            gmpPanel.grid.clearGrid();
            CommandCenter.getInstance().addScore(1000);
            // sets high score
            if (CommandCenter.getInstance().getHighScore() < CommandCenter.getInstance().getScore()) {
                CommandCenter.getInstance().setHighScore(CommandCenter.getInstance().getScore());
            }
            gmpPanel.tetrCurrent = gmpPanel.tetrOnDeck;
            gmpPanel.tetrOnDeck = createNewTetromino();
            tetrTest = null;
        }
//		once a tetromino hits the bottom, check if game is over (top row)
//  check if any full rows completed, generate new tetromino for on deck, switch on deck to current
        else if (CommandCenter.getInstance().isPlaying()) {
            gmpPanel.grid.addToOccupied(gmpPanel.tetrCurrent);
            gmpPanel.grid.checkTopRow();
            gmpPanel.grid.checkCompletedRow();
            gmpPanel.tetrCurrent = gmpPanel.tetrOnDeck;
            gmpPanel.tetrOnDeck = createNewTetromino();
            tetrTest = null;
        } else {
            tetrTest = null;
        }

    }


    // Called when user presses 's'
    private void startGame() {
        gmpPanel.tetrCurrent = createNewTetromino();
        gmpPanel.tetrOnDeck = createNewTetromino();

        CommandCenter.getInstance().clearAll();
        CommandCenter.getInstance().initGame();
        CommandCenter.getInstance().setPlaying(true);
        CommandCenter.getInstance().setPaused(false);
        CommandCenter.getInstance().setGameOver(false);
        if (!bMuted)
            clpMusicBackground.loop(Clip.LOOP_CONTINUOUSLY);
    }


    // creates the next tetromino from the different options available
    private Tetromino createNewTetromino() {
        int nKey = R.nextInt(TETROMINO_NUMBER);
        if (nKey >= 0 && nKey <= 12) {
            return new LongPiece();
        } else if (nKey > 12 && nKey <= 23) {
            return new SquarePiece();
        } else if (nKey > 23 && nKey <= 35) {
            return new SPiece();
        } else if (nKey > 35 && nKey <= 46) {
            return new TPiece();
        } else if (nKey > 46 && nKey <= 58) {
            return new ZPiece();
        } else if (nKey > 58 && nKey <= 71) {
            return new LPiece();
        } else if (nKey > 71 && nKey <= 84) {
            return new JPiece();
        } else if (nKey > 84 && nKey <= 98) {
            return new PlusPiece();
        } else {
            return new Bomb();
        }
    }


    // Varargs for stopping looping-music-clips
    private static void stopLoopingSounds(Clip... clpClips) {
        for (Clip clp : clpClips) {
            clp.stop();
        }
    }

    // ===============================================
    // KEYLISTENER METHODS
    // ===============================================

    @Override
    public void keyPressed(KeyEvent e) {
        lTime = System.currentTimeMillis();
        int nKeyPressed = e.getKeyCode();
        if (nKeyPressed == START && CommandCenter.getInstance().isLoaded() && !CommandCenter.getInstance().isPlaying())
            startGame();

        if (nKeyPressed == PAUSE & lTime > lTimeStep + PRESS_DELAY) {
            CommandCenter.getInstance().setPaused(!CommandCenter.getInstance().isPaused());
            lTimeStep = System.currentTimeMillis();
        }
        if (nKeyPressed == QUIT && lTime > lTimeStep + PRESS_DELAY) {
            System.exit(0);
        }
        if (nKeyPressed == DOWN && (lTime > lTimeStep + PRESS_DELAY - 35) && CommandCenter.getInstance().isPlaying()) {
            tryMovingDown();
            lTimeStep = System.currentTimeMillis();
        }
        if (nKeyPressed == RIGHT && lTime > lTimeStep + PRESS_DELAY) {
            Tetromino tetrTest = gmpPanel.tetrCurrent.cloneTetromino();
            tetrTest.moveRight();
            if (gmpPanel.grid.requestLateral(tetrTest)) {
                gmpPanel.tetrCurrent.moveRight();
                tetrTest = null;
                lTimeStep = System.currentTimeMillis();
            } else {
                tetrTest = null;
            }
        }
        if (nKeyPressed == LEFT && lTime > lTimeStep + PRESS_DELAY) {
            Tetromino tetrTest = gmpPanel.tetrCurrent.cloneTetromino();
            tetrTest.moveLeft();
            if (gmpPanel.grid.requestLateral(tetrTest)) {
                gmpPanel.tetrCurrent.moveLeft();
                tetrTest = null;
                lTimeStep = System.currentTimeMillis();
            } else {
                tetrTest = null;
            }
        }
        // space = rotate
        if (nKeyPressed == SPACE) {
            Tetromino tetrTest = gmpPanel.tetrCurrent.cloneTetromino();
            tetrTest.rotate();
            if (gmpPanel.grid.requestLateral(tetrTest)) {
                gmpPanel.tetrCurrent.rotate();
                tetrTest = null;
                lTimeStep = System.currentTimeMillis();
            } else {
                tetrTest = null;
            }
        }
        if (nKeyPressed == MUTE) {
            if (!bMuted) {
                stopLoopingSounds(clpMusicBackground);
                stopLoopingSounds(clpBomb);
                bMuted = !bMuted;
            } else {
                clpMusicBackground.loop(Clip.LOOP_CONTINUOUSLY);
                bMuted = !bMuted;
            }
        }

    }


    @Override
    // Needed because of KeyListener implementation
    public void keyReleased(KeyEvent e) {

    }

    @Override
    // Needed because of KeyListener implementation
    public void keyTyped(KeyEvent e) {
    }

}


