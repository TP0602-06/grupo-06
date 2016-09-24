package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Cell;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.CellInterface;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.Rule;

import java.util.ArrayList;

/**
 * Regla de adicion. Valida que la adicion de valores de un grupo de celdas.
 */
public class AdditionRule extends Rule {
    private Integer value;

    public AdditionRule(Integer value, ArrayList<CellInterface> cells) {
        super(cells);
        this.value = value;
    }

    @Override
    public boolean isBroken() {
        Integer addition = 0;
        for (CellInterface cell : this.cells) {
            addition += Integer.parseInt(cell.getValue());
        }
        return this.value.equals(addition);
    }
}
