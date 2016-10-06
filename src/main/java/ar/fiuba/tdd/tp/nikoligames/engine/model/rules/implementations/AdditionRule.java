package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.cell.AbstractCell;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.cell.Cell;
import ar.fiuba.tdd.tp.nikoligames.engine.model.position.Position;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.RuleDefinitionValidator;

import java.util.ArrayList;

/**
 * Created by german on 9/30/2016.
 */
public class AdditionRule extends RuleImplementation {
    public AdditionRule(ArrayList<AbstractCell> listOfCell, String value) {
        super(listOfCell, value);
    }

    @Override
    public boolean isBroken() {
        int addition = 0;
        for (AbstractCell cell : listOfCells) {
            if (cell.isEmpty()) {
                return true;
            }
            addition += Integer.parseInt(cell.getValue());
        }
        int value = Integer.parseInt(this.value);
        boolean result = (value == addition);
        return (!result);
    }
}
