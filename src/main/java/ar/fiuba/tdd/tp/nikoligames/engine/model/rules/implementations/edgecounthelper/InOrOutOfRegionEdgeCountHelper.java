package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.edgecounthelper;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;

import java.util.List;

/**
 * Created by german on 10/12/2016.
 */
public class InOrOutOfRegionEdgeCountHelper extends EdgeCountHelper {
    public InOrOutOfRegionEdgeCountHelper(List<AbstractNode> region) {
        super(region);
    }

    @Override
    boolean hasToCount(AbstractNode node) {
        return (!(super.region.contains(node)));
    }
}
