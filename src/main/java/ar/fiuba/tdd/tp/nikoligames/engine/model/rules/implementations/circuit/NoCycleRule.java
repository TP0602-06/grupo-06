package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.circuit;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.RuleImplementation;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.circuit.helper.CycleDetectorHelper;

import java.util.List;

/**
 * Created by german on 10/8/2016.
 */
public class NoCycleRule extends RuleImplementation {
    public NoCycleRule(List<AbstractNode> region) {
        super(region, "");
    }

    @Override
    public boolean isBroken() {
        return hasCycle();
    }

    @Override
    public boolean isActualBroken() {
        return hasCycle();
    }

    public boolean hasCycle() {
        CycleDetectorHelper cycleDetectorHelper = new CycleDetectorHelper(region);
        return cycleDetectorHelper.hasCycle();
    }
}
