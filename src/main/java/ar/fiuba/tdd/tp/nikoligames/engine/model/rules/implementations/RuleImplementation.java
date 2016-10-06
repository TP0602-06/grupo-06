package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.cell.AbstractCell;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.Rule;

import java.util.ArrayList;

public abstract class RuleImplementation extends Rule {

    public static final String NO_VALUE_RULE = "";

    protected ArrayList<AbstractCell> listOfCells;
    protected String value;

    public RuleImplementation(ArrayList<AbstractCell> listOfCells, String value) {
        this.value = value;
        this.listOfCells = listOfCells;
    }



    public String getValue() {
        return value;
    }

    public abstract boolean isBroken();
}
