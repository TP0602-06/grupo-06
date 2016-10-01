package ar.fiuba.tdd.tp.nikoligames.engine.model.rules;

import ar.fiuba.tdd.tp.nikoligames.engine.model.Coordinates;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Board;

import java.util.ArrayList;

public interface Rule {
    void addCellToRegion(int row, int col);

    ArrayList<Coordinates> getRegion();

    String getValue();

    String getDefinition();

    boolean isBroken(Board board);
}
