package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.Rule;

import java.util.ArrayList;

public abstract class RuleImplementation extends Rule {

    protected ArrayList<AbstractNode> region;
    protected String value;

    public RuleImplementation(ArrayList<AbstractNode> listOfCells, String value) {
        this.value = value;
        this.region = listOfCells;
    }



    public String getValue() {
        return value;
    }

    public abstract boolean isBroken();

    public ArrayList<AbstractNode> getRegion() {
        return region;
    }
}
