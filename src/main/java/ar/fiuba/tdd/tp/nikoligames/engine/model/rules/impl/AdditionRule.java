package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.impl;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.AbstractCell;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.Rule;

import java.util.ArrayList;

/**
 * Regla de adicion. Valida que la adicion de valores de un grupo de celdas.
 */
public class AdditionRule extends Rule {
    private Integer value;

    public AdditionRule(Integer value, ArrayList<AbstractCell> cells) {
        super(cells);
        this.value = value;
    }

    @Override
    public boolean isBroken() {
        Integer addition = 0;
        for (AbstractCell cell : this.cells) {
            addition += Integer.parseInt(cell.getValue());
        }
        return this.value.equals(addition);
    }
}
