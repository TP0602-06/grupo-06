package ar.fiuba.tdd.tp.nikoligames.engine.model.board.boardcommandaction;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.position.Position;

/**
 * Created by Andres on 16/10/2016.
 */
public  abstract class BoardCommandAction {
    public abstract void execute(Board board, Position position1 ,Position position2);
}



