package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Cell;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.Rule;

/**
 * Regla de adicion. Valida que la adicion de valores de un grupo de celdas.
 */
public class AdditionRule implements Rule {
    private Integer value;
    private Iterable<Cell> cells;

    public AdditionRule(Integer value, Iterable<Cell> cells) {
        this.value = value;
        this.cells = cells;
    }

    @Override
    public boolean isBroken() {
        Integer addition = 0;
        for (Cell cell : this.cells) {
            addition += cell.getValue();
        }
        return this.value.equals(addition);
    }
}
