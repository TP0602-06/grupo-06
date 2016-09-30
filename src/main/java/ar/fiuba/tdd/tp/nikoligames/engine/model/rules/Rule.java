package ar.fiuba.tdd.tp.nikoligames.engine.model.rules;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.ConcreteBoard;
import ar.fiuba.tdd.tp.nikoligames.engine.model.Position;

import java.util.ArrayList;

public interface Rule {
    void addCellToRegion(int row, int col);
    ArrayList<Position> getRegion();
    String getValue();

    boolean isBroken(ConcreteBoard board);
}
