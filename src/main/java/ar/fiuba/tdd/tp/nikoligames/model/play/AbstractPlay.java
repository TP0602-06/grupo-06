package ar.fiuba.tdd.tp.nikoligames.model.play;

import ar.fiuba.tdd.tp.nikoligames.model.board.EdgeAlreadyExistsExpection;
import ar.fiuba.tdd.tp.nikoligames.model.board.EdgeNotExistsExpection;
import ar.fiuba.tdd.tp.nikoligames.model.board.node.NotEditableExpection;
import ar.fiuba.tdd.tp.nikoligames.model.game.Game;

/**
 * Created by german on 10/16/2016.
 * Responsibilities:
 * 1. Play of the game, it  models all the plays of the game.
 * 2. It makes a change of the status of the game and saves the status of the game after.
 */
public abstract class AbstractPlay implements UndoablePlay {
    protected final int number;
    protected final Game game;
    private boolean boardStatus = true;

    public AbstractPlay(Game game, int number) {
        this.number = number;
        this.game = game;
    }

    public boolean process() throws EdgeAlreadyExistsExpection, NotEditableExpection, EdgeNotExistsExpection {
        updateGame();
        boardStatus = game.getBoardStatus();
        return boardStatus;
    }

    public abstract void undo();

    public int getNumber() {
        return number;
    }

    public boolean getBoardStatus() {
        return boardStatus;
    }

    public abstract void updateGame() throws NotEditableExpection, EdgeAlreadyExistsExpection, EdgeNotExistsExpection;
}
