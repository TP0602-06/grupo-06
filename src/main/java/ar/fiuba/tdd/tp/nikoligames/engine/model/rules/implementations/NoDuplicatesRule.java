package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.cell.AbstractCell;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.cell.Cell;
import ar.fiuba.tdd.tp.nikoligames.engine.model.position.Position;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by german on 9/30/2016.
 */
public class NoDuplicatesRule extends RuleImplementation {
    public NoDuplicatesRule(ArrayList<AbstractCell> listOfCells) {
        super(listOfCells, "");
    }

    @Override
    public boolean isBroken() {
        HashSet<Integer> seenValues = new HashSet<Integer>();
        for (AbstractCell cell : listOfCells) {
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
