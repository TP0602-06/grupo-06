package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.Node;

import java.util.ArrayList;

/**
 * Created by german on 9/30/2016.
 */
public class MultiplicationRule extends RuleImplementation {

    public MultiplicationRule(ArrayList<Node> listOfCells, String value) {
        super(listOfCells, value);
    }

    @Override
    public boolean isBroken() {
        int multiplication = 1;
        for (Node cell : region) {
            if (cell.isEmpty()) {
                return true;
            }
            multiplication *= Integer.parseInt(cell.getValue());
        }
        int value = Integer.parseInt(this.value);
        boolean result = (value == multiplication);
        return (!result);

    }
}
