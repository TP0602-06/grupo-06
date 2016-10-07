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
        return check(false);
    }

    @Override
    public boolean isActualBroken() {
        return check(true);
    }
    private boolean check(boolean isActual){
        HashSet<Integer> seenValues = new HashSet<Integer>();
        for (AbstractNode node : this.region) {
            if (node.isEmpty()&&(seenValues.contains(Integer.parseInt(node.getValue())))&&(!isActual)) {
                return true;
            }
            if (isActual) {
                continue;
            }
            seenValues.add(Integer.parseInt(node.getValue()));
        }
        return false;
    }
}
