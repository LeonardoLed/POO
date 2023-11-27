package mvc.model;

import mvc.controller.Game;

import java.util.ArrayList;
import java.util.List;


public class CommandCenter {

    private long mHighScore;
    private int mThreshold;
    private long mScore;
    private boolean mPlaying;
    private boolean mPaused;
    private boolean mLoaded;
    private boolean mGameOver;


    // These ArrayLists with capacities set
    private List<Movable> movTetrominoes = new ArrayList<Movable>(300);
    private GameOpsList opsList = new GameOpsList();


    private static CommandCenter instance = null;


    // Constructor made private - static Utility class only
    private CommandCenter() {
    }


    public static CommandCenter getInstance() {
        if (instance == null) {
            instance = new CommandCenter();
        }
        return instance;
    }


    public void initGame() {
        setScore(0);
        setThreshold(2400);

    }


    public int getThreshold() {
        return mThreshold;
    }

    public void setThreshold(int nThresh) {
        this.mThreshold = nThresh;
    }


    public long getHighScore() {
        return mHighScore;
    }

    public void setHighScore(long lHighScore) {
        this.mHighScore = lHighScore;
    }


    public boolean isLoaded() {
        return mLoaded;
    }

    public void setLoaded(boolean bLoaded) {
        this.mLoaded = bLoaded;
    }


    public boolean isGameOver() {
        return mGameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.mGameOver = gameOver;
    }


    public List<Movable> getMovTetromino() {
        return movTetrominoes;
    }


    public GameOpsList getOpsList() {
        return opsList;
    }


    public void clearAll() {
        movTetrominoes.clear();
    }

    public boolean isPlaying() {
        return mPlaying;
    }

    public void setPlaying(boolean bPlaying) {
        this.mPlaying = bPlaying;
    }

    public boolean isPaused() {
        return mPaused;
    }

    public void setPaused(boolean bPaused) {
        this.mPaused = bPaused;
    }


    public long getScore() {
        return mScore;
    }

    public void setScore(long lParam) {
        mScore = lParam;
    }

    public void addScore(long lParam) {
        mScore += lParam;
    }

    //	once the score gets above threshold, the game gets quicker
    public void checkThreshold() {
        if (mScore > mThreshold && Game.nAutoDelay > 30) {
            mThreshold += Game.THRESHOLD;
            Game.nAutoDelay -= 15;
        }
    }


}
