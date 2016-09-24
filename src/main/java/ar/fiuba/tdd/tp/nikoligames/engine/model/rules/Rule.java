package ar.fiuba.tdd.tp.nikoligames.engine.model.rules;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Cell;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.CellInterface;


import java.util.ArrayList;

public abstract class Rule {

    protected ArrayList<CellInterface> cells;

    public Rule(ArrayList<CellInterface> cells) {
        this.cells = cells;
    }

    public abstract boolean isBroken();
}
