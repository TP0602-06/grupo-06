package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.CellInterface;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.Rule;

import java.util.ArrayList;


/**
 * Regla de no duplicidad. Valida la no repeticion de valores de un grupo de celdas.
 */
public class NoDuplicatesRule extends Rule {

    public NoDuplicatesRule(ArrayList<CellInterface> cells) {
        super(cells);
    }

    @Override
    public boolean isBroken() {
        ArrayList<Integer> values = new ArrayList<Integer>();
        for (CellInterface cell : this.cells) {
            if (values.contains(Integer.parseInt(cell.getValue()))) {
                return false;
            }
            values.add(Integer.parseInt(cell.getValue()));
        }
        return true;
    }
}
