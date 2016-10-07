package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * Created by german on 10/7/2016.
 */
public class ValidInputValueRule extends RuleImplementation {
    public static final String CLEAR = "";
    private HashSet<String> validInputs;

    public ValidInputValueRule(List<AbstractNode> region, HashSet<String> validInputs) {
        super(region, "");
    }

    @Override
    public boolean isBroken() {
        Iterator<AbstractNode> nodeIterator = region.iterator();
        while (nodeIterator.hasNext()) {
            AbstractNode node = nodeIterator.next();
            if (!isValidInput(node.getValue())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isActualBroken() {
        return isBroken();
    }

    public boolean isValidInput(String input) {
        return (validInputs.contains(input) || input.equals(CLEAR));
    }
}
