package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations;

import ar.fiuba.tdd.tp.nikoligames.engine.model.Coordinates;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.ConcreteBoard;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.cell.Cell;

import java.util.ArrayList;

/**
 * Created by german on 9/30/2016.
 */
public class AdditionRule extends RuleImplementation {
    public AdditionRule(ArrayList<Coordinates> region, String value) {
        super(region, value);
    }

    @Override
    public boolean isBroken(ConcreteBoard board) {
        Integer addition = 0;
        for (Coordinates position : super.region) {
            Cell cell = board.getCell(position);
            if (cell.isEmpty()) {
                return true;
            }
            addition += Integer.parseInt(cell.getValue());
        }
        return (!this.value.equals(addition));
    }
}
