package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.RuleImplementation;

import java.util.Iterator;
import java.util.List;

/**
 * Created by german on 10/8/2016.
 */
public class NonEmptyRule extends RuleImplementation {
    public NonEmptyRule(List<AbstractNode> region) {
        super(region, "");
    }

    @Override
    public boolean isBroken() {
        Iterator<AbstractNode> regionIterator = region.iterator();
        while (regionIterator.hasNext()) {
            AbstractNode node = regionIterator.next();
            if(node.isEmpty()){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isActualBroken() {
        return false;
    }
}
