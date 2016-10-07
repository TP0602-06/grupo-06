package ar.fiuba.tdd.tp.nikoligames.engine.model.rules;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;

import java.util.ArrayList;

public abstract class Rule {

    public ArrayList<AbstractNode> getRegion;

    public abstract String getValue();

    public abstract  boolean isBroken();
}
