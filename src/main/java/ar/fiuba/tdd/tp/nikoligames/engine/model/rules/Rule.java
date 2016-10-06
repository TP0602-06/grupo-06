package ar.fiuba.tdd.tp.nikoligames.engine.model.rules;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.cell.Node;

import java.util.ArrayList;

public abstract class Rule {

    public ArrayList<Node> getRegion;

    public abstract String getValue();

    public abstract  boolean isBroken();
}
