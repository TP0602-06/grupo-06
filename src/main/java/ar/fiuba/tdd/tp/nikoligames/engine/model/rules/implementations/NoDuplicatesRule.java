package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations;

import ar.fiuba.tdd.tp.nikoligames.engine.model.Coordinates;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.ConcreteBoard;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.cell.Cell;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by german on 9/30/2016.
 */
public class NoDuplicatesRule extends RuleImplementation {
    public NoDuplicatesRule(ArrayList<Coordinates> region) {
        super(region);
    }

    @Override
    public boolean isBroken(ConcreteBoard board) {
        HashSet<Integer> seenValues = new HashSet<>();
        for (Coordinates position : super.region) {

            Cell cell = board.getCell(position);
            if (cell.isEmpty()) {
                return true;
            }
            if (seenValues.contains(Integer.parseInt(cell.getValue()))) {
                return true;
            }
            seenValues.add(Integer.parseInt(cell.getValue()));
        }
        return false;
    }
}
