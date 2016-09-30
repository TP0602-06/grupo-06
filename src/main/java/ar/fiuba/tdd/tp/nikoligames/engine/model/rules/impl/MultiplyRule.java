package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.impl;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.AbstractCell;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.Rule;

import java.util.ArrayList;

/**
 * Created by fedebrasburg on 9/29/16.
 */
public class MultiplyRule extends Rule {

    private Integer value;

    public MultiplyRule(Integer value, ArrayList<AbstractCell> cells) {
        super(cells);
        this.value = value;
    }

    @Override
    public boolean isBroken() {
        Integer addition = 1;
        for (AbstractCell cell : this.cells) {
            if (cell.isEmpty()) {
                return true;
            }
            addition *= Integer.parseInt(cell.getValue());
        }
        return (!this.value.equals(addition));
    }

    @Override
    public boolean isActualBroken() {
        Integer addition = 1;
        for (AbstractCell cell : this.cells) {
            if (cell.isEmpty()) {
                return false;
            }
            addition *= Integer.parseInt(cell.getValue());
        }
        return (!this.value.equals(addition));
    }

}
