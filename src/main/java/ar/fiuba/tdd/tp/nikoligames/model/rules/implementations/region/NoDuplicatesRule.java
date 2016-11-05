package ar.fiuba.tdd.tp.nikoligames.model.rules.implementations.region;

import ar.fiuba.tdd.tp.nikoligames.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.model.rules.RuleImplementation;

import java.util.HashSet;
import java.util.List;

/**
 * Created by german on 9/30/2016.
 * Responsabilites:
 * 1. Checks that  values in a certain region dont repeat
 */
public class NoDuplicatesRule extends RegionAbstractRule {
    public NoDuplicatesRule(List<AbstractNode> nodes) {
        super(nodes);
    }

    @Override
    protected boolean check() {
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
