package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.Node;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by german on 9/30/2016.
 */
public class NoDuplicatesRule extends RuleImplementation {
    public NoDuplicatesRule(ArrayList<Node> listOfCells) {
        super(listOfCells, "");
    }

    @Override
    public boolean isBroken() {
        HashSet<Integer> seenValues = new HashSet<Integer>();
        for (Node cell : region) {
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
