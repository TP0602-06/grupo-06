package ar.fiuba.tdd.tp.nikoligames.model.rules.implementations.nodecondition;

import ar.fiuba.tdd.tp.nikoligames.model.board.node.AbstractNode;
import utils.Constants;

import java.util.List;
import java.util.Set;

/**
 * Created by german on 10/7/2016.
 * Responsabilities:
 * 1.Checks that the values of nodes in a region are from a valid set of strings.
 */
public class ValidInputValueRule extends AbstractRegionRule {
    private Set<String> validInputs;

    public ValidInputValueRule(List<AbstractNode> region, Set<String> validInputs) {
        super(region, Constants.EMPTY_STRING);
        this.validInputs = validInputs;
    }

    @Override
    protected boolean nodeCondition(AbstractNode node) {
        return (!isValidInput(node.getValue()));
    }

    @Override
    public boolean isActualBroken() {
        return isBroken();
    }

    public boolean isValidInput(String input) {
        return (validInputs.contains(input) || input.equals(Constants.EMPTY_STRING));
    }
}
