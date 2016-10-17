package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.circuit.helper;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by german on 10/12/2016.
 */
public class CycleDetectorHelper {
    private final List<AbstractNode> region;

    private Map<AbstractNode, Boolean> marked;
    private boolean hasCycle = false;

    public CycleDetectorHelper(List<AbstractNode> region) {
        this.region = region;
        if (!region.isEmpty()) {
            initMarkedMap(region);

            AbstractNode startingNode = region.get(0);
            findCycle(startingNode, startingNode);
        }
    }

    public boolean hasCycle() {
        return hasCycle;
    }

    private void initMarkedMap(List<AbstractNode> region) {
        marked = new HashMap<AbstractNode, Boolean>();
        Iterator<AbstractNode> iterator = region.iterator();
        while (iterator.hasNext()) {
            AbstractNode nextNode = iterator.next();
            marked.put(nextNode, false);
        }
    }

    private void findCycle(AbstractNode rootNode, AbstractNode previusNode) {
        marked.put(rootNode, true);

        List<AbstractNode> edgelist = rootNode.getEdgeList();
        Iterator<AbstractNode> iterator = edgelist.iterator();
        while (iterator.hasNext()) {
            AbstractNode nextNode = iterator.next();
            if (previusNode != nextNode) {
                if (!marked.get(nextNode)) {
                    marked.put(nextNode, true);
                    findCycle(nextNode, rootNode);
                } else if (rootNode != previusNode) {
                    hasCycle = true;
                    return;
                }
            }
        }
    }

}
