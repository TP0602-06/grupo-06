package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.Node;

import java.util.ArrayList;

/**
 * Created by german on 9/30/2016.
 */
public class AdditionRule extends RuleImplementation {
    public AdditionRule(ArrayList<Node> listOfCell, String value) {
        super(listOfCell, value);
    }

    @Override
    public boolean isBroken() {
        int addition = 0;
        for (Node cell : region) {
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
