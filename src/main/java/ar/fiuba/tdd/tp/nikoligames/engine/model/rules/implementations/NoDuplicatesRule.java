package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.RuleImplementation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by german on 9/30/2016.
 */
public class NoDuplicatesRule extends RuleImplementation {
    public NoDuplicatesRule(List<AbstractNode> nodes) {
        super(nodes, "");
    }

    @Override
    public boolean isBroken() {
        return check();
    }

    @Override
    public boolean isActualBroken() {
        return check();
    }

    private boolean check() {
        HashSet<String> seenValues = new HashSet<String>();
        for (AbstractNode node : this.region) {
            if (node.isEmpty()) {
                continue;
            }

            if (seenValues.contains(node.getValue())) {
                return true;
            }

            seenValues.add(node.getValue());
        }
        return false;
    }
}
