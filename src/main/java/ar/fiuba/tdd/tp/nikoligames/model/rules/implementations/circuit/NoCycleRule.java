package ar.fiuba.tdd.tp.nikoligames.model.rules.implementations.circuit;

import ar.fiuba.tdd.tp.nikoligames.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.model.rules.RuleImplementation;
import ar.fiuba.tdd.tp.nikoligames.model.rules.implementations.circuit.helper.CycleDetectorHelper;
import utils.Constants;

import java.util.List;

/**
 * Created by german on 10/8/2016.
 * Resposibilities:
 * 1. Detects if there is a cycle in a region.
 */
public class NoCycleRule extends RuleImplementation {
    public NoCycleRule(List<AbstractNode> region) {
        super(region, Constants.CLEAR_STRING);
    }


    @Override
    public boolean isActualBroken() {
        return hasCycle();
    }

    public boolean hasCycle() {
        CycleDetectorHelper cycleDetectorHelper = new CycleDetectorHelper(region);
        return cycleDetectorHelper.hasCycle();
    }

    @Override
    public boolean isBroken() {
        return hasCycle();
    }
}
