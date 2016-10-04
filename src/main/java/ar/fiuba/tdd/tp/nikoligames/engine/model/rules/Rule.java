package ar.fiuba.tdd.tp.nikoligames.engine.model.rules;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.engine.model.position.Position;

import java.util.ArrayList;

public interface Rule {
    void addCellToRegion(int row, int col);

    ArrayList<Position> getRegion();

    String getValue();

    boolean isBroken(Board board);

    boolean isActualBroken(Board board);
}
