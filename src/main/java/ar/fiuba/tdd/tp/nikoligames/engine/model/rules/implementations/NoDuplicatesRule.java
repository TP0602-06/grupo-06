package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by german on 9/30/2016.
 */
public class NoDuplicatesRule extends RuleImplementation {
    public NoDuplicatesRule(ArrayList<AbstractNode> nodes) {
        super(nodes, "");
    }

    @Override
    public boolean isBroken() {
        HashSet<Integer> seenValues = new HashSet<Integer>();
        for (AbstractNode node : this.region) {
            if (node.isEmpty()) {
                return true;
            }
            if (seenValues.contains(Integer.parseInt(node.getValue()))) {
                return true;
            }
            seenValues.add(Integer.parseInt(node.getValue()));
        }
        return false;
    }
}
