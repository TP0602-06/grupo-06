package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.engine.model.position.ClassicPosition;
import ar.fiuba.tdd.tp.nikoligames.engine.model.position.Position;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.Rule;

import java.util.ArrayList;

public abstract class RuleImplementation implements Rule {

    public static final String NO_VALUE_RULE = "";

    protected ArrayList<Position> region;
    protected String value;
    protected String definition;

    public RuleImplementation(ArrayList<Position> region, String value, String definition) {
        this.value = value;
        this.region = region;
        this.definition = definition;
    }

    @Override
    public String getDefinition() {
        return definition;
    }

    public void addCellToRegion(int row, int col) {
        ClassicPosition pos = new ClassicPosition(row, col);
        this.region.add(pos);
    }

    public ArrayList<Position> getRegion() {
        return region;
    }

    public String getValue() {
        return value;
    }

    public abstract boolean isBroken(Board board);
}
