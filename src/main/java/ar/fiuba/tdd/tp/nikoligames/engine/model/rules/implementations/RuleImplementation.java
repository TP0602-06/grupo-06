package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations;

import ar.fiuba.tdd.tp.nikoligames.engine.model.ClassicCoordinates;
import ar.fiuba.tdd.tp.nikoligames.engine.model.Coordinates;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.ConcreteBoard;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.Rule;

import java.util.ArrayList;

public abstract class RuleImplementation implements Rule {

    public static final String NO_VALUE_RULE = "";

    protected ArrayList<Coordinates> region;
    protected String value;

    public RuleImplementation(ArrayList<Coordinates>  region, String value){
        this.value = value;
        this.region = region;
    }
    public RuleImplementation(ArrayList<Coordinates>  region){
        this(region , NO_VALUE_RULE);
    }

    public void addCellToRegion(int row, int col){
        ClassicCoordinates pos = new ClassicCoordinates(row,col);
        this.region.add(pos);
    }

    public ArrayList<Coordinates> getRegion(){
        return region;
    }

    public String getValue(){
        return value;
    }

    public abstract boolean isBroken(ConcreteBoard board);
}
