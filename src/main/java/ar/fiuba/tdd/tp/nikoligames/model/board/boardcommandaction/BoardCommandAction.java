package ar.fiuba.tdd.tp.nikoligames.model.board.boardcommandaction;

import ar.fiuba.tdd.tp.nikoligames.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.Position;

/**
 * Created by Andres on 16/10/2016.
 * Responsibilities:
 * 1.Execute an action to change the state of the board.
 */

public abstract class BoardCommandAction {
    public abstract void execute(Board board, Position position1, Position position2);
}



