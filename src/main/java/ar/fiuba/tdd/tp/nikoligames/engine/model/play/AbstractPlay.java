package ar.fiuba.tdd.tp.nikoligames.engine.model.play;

import ar.fiuba.tdd.tp.nikoligames.engine.model.game.Game;
import org.json.simple.JSONObject;

/**
 * Created by german on 10/16/2016.
 */
public abstract class AbstractPlay {
    public static final String NUM_KEY = "number";

    protected final int number;

    private boolean boardStatus = true;
    protected final Game game;

    public AbstractPlay(Game game, int number){
        this.number = number;
        this.game = game;
    }

    public boolean process(){
        updateGame();
        boardStatus = game.getBoardStatus();
        return boardStatus;
    }
    public int getNumber() {
        return number;
    }

    public boolean getBoardStatus() {
        return boardStatus;
    }
    public abstract void updateGame();
}
