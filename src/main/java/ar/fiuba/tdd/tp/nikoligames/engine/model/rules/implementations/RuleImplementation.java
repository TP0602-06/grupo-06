package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.Node;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.Rule;

import java.util.ArrayList;

public abstract class RuleImplementation extends Rule {

    protected ArrayList<Node> region;
    protected String value;

    public RuleImplementation(ArrayList<Node> listOfCells, String value) {
        this.value = value;
        this.region = listOfCells;
    }

    public String getValue() {
        return value;
    }

    public abstract boolean isBroken();

    public ArrayList<Node> getRegion() {
        return region;
    }
}
