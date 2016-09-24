package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Cell;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.Rule;

import java.util.ArrayList;

// Regla de no duplicidad. Valida la no repeticion de valores de un grupo de celdas.
public class NoDuplicatesRule implements Rule {
    private Iterable<Cell> cells;

    public NoDuplicatesRule(Iterable<Cell> cells) {
        this.cells = cells;
    }

    @Override
    public boolean isBroken() {
        ArrayList<Integer> values = new ArrayList<Integer>();
        for (Cell cell : this.cells) {
            if (values.contains(cell.getValue())) {
                return false;
            }
            values.add(cell.getValue());
        }
        return true;
    }
}
