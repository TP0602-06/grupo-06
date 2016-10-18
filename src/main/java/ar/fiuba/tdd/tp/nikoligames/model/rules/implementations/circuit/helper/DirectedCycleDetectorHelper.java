package ar.fiuba.tdd.tp.nikoligames.model.rules.implementations.circuit.helper;

import ar.fiuba.tdd.tp.nikoligames.model.board.node.AbstractNode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by german on 10/12/2016.
 */
public class DirectedCycleDetectorHelper {

    private Map<AbstractNode, Boolean> onStack = new HashMap<AbstractNode, Boolean>();
    private Map<AbstractNode, Boolean> marked = new HashMap<AbstractNode, Boolean>();

    private boolean hasCycle = false;

    public DirectedCycleDetectorHelper(List<AbstractNode> region) {
        if (!region.isEmpty()) {
            initMap(region,marked);
            initMap(region,onStack);
            AbstractNode startingNode = region.get(0);
            findCycle(startingNode);
        }
    }

    public boolean hasCycle() {
        return hasCycle;
    }

    private void initMap(List<AbstractNode> region,Map<AbstractNode, Boolean> map ) {
        map.clear();
        Iterator<AbstractNode> iterator = region.iterator();
        while (iterator.hasNext()) {
            AbstractNode nextNode = iterator.next();
            map.put(nextNode, false);
        }
    }

    private void findCycle(AbstractNode rootNode) {
        marked.put(rootNode, true);
        onStack.put(rootNode,true);

        List<AbstractNode> edgelist = rootNode.getEdgeList();
        Iterator<AbstractNode> iterator = edgelist.iterator();
        while (iterator.hasNext()) {
            AbstractNode nextNode = iterator.next();
            if (!marked.get(nextNode)) {
                marked.put(nextNode, true);
                findCycle(nextNode);
            } else if (onStack.get(nextNode)) {
                hasCycle = true;
                return;
            }
        }

        onStack.put(rootNode,false);
    }

}
