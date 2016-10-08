package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.regionrules;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;

import java.util.HashSet;
import java.util.List;

/**
 * Created by german on 10/7/2016.
 */
public class ValidInputValueRule extends RegionRule {
    public static final String CLEAR = "";
    private HashSet<String> validInputs;

    public ValidInputValueRule(List<AbstractNode> region, HashSet<String> validInputs) {
        super(region, "");
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
        return (validInputs.contains(input) || input.equals(CLEAR));
    }
}