package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.impl;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.AbstractCell;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.Rule;

import java.util.ArrayList;


/**
 * Regla de no duplicidad. Valida la no repeticion de valores de un grupo de celdas.
 */
public class NoDuplicatesRule extends Rule {

    public NoDuplicatesRule(ArrayList<AbstractCell> cells) {
        super(cells);
    }

    @Override
    public boolean isBroken() {
        ArrayList<Integer> values = new ArrayList<Integer>();
        for (AbstractCell cell : this.cells) {
            if (values.contains(Integer.parseInt(cell.getValue()))) {
                return false;
            }
            values.add(Integer.parseInt(cell.getValue()));
        }
        return true;
    }
}
