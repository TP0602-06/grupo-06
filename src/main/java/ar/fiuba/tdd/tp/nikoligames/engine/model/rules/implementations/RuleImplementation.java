package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.ConcreteBoard;
import ar.fiuba.tdd.tp.nikoligames.engine.model.Position;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.Rule;

import java.util.ArrayList;

public abstract class RuleImplementation implements Rule {

    public static final String NO_VALUE_RULE = "";

    protected ArrayList<Position> region;
    protected String value;

    public RuleImplementation(ArrayList<Position>  region, String value){
        this.value = value;
        this.region = region;
    }
    public RuleImplementation(ArrayList<Position>  region){
        this(region , NO_VALUE_RULE);
    }

    public void addCellToRegion(int row, int col){
        Position pos = new Position(row,col);
        this.region.add(pos);
    }

    public ArrayList<Position> getRegion(){
        return region;
    }

    public String getValue(){
        return value;
    }

    public abstract boolean isBroken(ConcreteBoard board);
}
