package ar.fiuba.tdd.tp.nikoligames.engine.model.rules;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.AbstractCell;

import java.util.ArrayList;

public abstract class Rule {

    protected ArrayList<AbstractCell> cells;

    public Rule(ArrayList<AbstractCell> cells) {
        this.cells = cells;
    }

    public abstract boolean isBroken();
}
