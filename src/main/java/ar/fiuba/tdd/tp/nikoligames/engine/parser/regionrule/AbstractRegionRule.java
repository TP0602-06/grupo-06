package ar.fiuba.tdd.tp.nikoligames.engine.parser.regionrule;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Position;

import java.util.ArrayList;

public interface AbstractRegionRule {
    void addCellToRegion(int row, int col);
    String getRuleDefinition();
    ArrayList<Position> getRegion();
    String getNumber();
}
