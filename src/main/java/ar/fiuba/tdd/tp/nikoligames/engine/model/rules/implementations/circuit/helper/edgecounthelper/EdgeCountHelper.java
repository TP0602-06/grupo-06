package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.circuit.helper.edgecounthelper;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;

import java.util.Iterator;
import java.util.List;

/**
 * Created by german on 10/12/2016.
 */
public abstract class EdgeCountHelper {
    protected final List<AbstractNode> region;

    public EdgeCountHelper(List<AbstractNode> region) {
        this.region = region;
    }

    public int getCount() {
        int count = 0;
        Iterator<AbstractNode> nodeIterator = region.iterator();
        while (nodeIterator.hasNext()) {
            AbstractNode node = nodeIterator.next();
            List<AbstractNode> edgeList = node.getEdgeList();
            Iterator<AbstractNode> edgeListIterator = edgeList.iterator();
            while (edgeListIterator.hasNext()) {
                AbstractNode edgeListNextNode = edgeListIterator.next();
                if (hasToCount(edgeListNextNode)) {
                    count++;
                }
            }
        }
        return count;
    }

    abstract boolean hasToCount(AbstractNode node);//!region.contains(edgeListNextNode)
}
