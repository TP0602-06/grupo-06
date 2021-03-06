package ar.fiuba.tdd.tp.nikoligames.model.rules.implementations.circuit;

import ar.fiuba.tdd.tp.nikoligames.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.model.rules.RuleImplementation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Responsibilities:
 * 1. Checks that there is only one cycle on a region
 *
 */
public class OneCycleRule extends RuleImplementation {
    public OneCycleRule(List<AbstractNode> region) {
        super(region, "");
    }

    @Override
    public boolean isBroken() {
        List<AbstractNode> nodesInCircuit = new ArrayList<AbstractNode>();

        Iterator<AbstractNode> regionIterator = region.iterator();
        while (regionIterator.hasNext()) {
            AbstractNode node = regionIterator.next();
            int edgeListSize = getEdgeListSize(node);

            if (!closedIsVisitedAtMostOnce(edgeListSize)) {
                return true;
            }
            if (isInSomeCircuit(edgeListSize)) {
                nodesInCircuit.add(node);
            }
        }
        return (!checkOnlyOneClosedCircuit(nodesInCircuit));
    }

    private boolean isInSomeCircuit(int edgeListSize) {
        if (edgeListSize == 2) {
            return true;
        }
        return false;
    }

    private boolean closedIsVisitedAtMostOnce(int edgeListSize) {
        if ((edgeListSize == 2) || (edgeListSize == 0)) {
            return true;
        }
        return false;
    }

    private int getEdgeListSize(AbstractNode node) {
        List<AbstractNode> edgelist = node.getEdgeList();
        return edgelist.size();
    }

    @Override
    public boolean isActualBroken() {
        Iterator<AbstractNode> regionIterator = region.iterator();
        while (regionIterator.hasNext()) {
            AbstractNode node = regionIterator.next();
            int edgeListSize = getEdgeListSize(node);
            if (!nodeVisitedAtMostOnce(edgeListSize)) {
                return true;
            }
        }
        return false;
    }

    private boolean nodeVisitedAtMostOnce(int edgeListSize) {
        if (((edgeListSize >= 0) && (edgeListSize <= 2))) {
            return true;
        }
        return false;
    }

    private boolean checkOnlyOneClosedCircuit(List<AbstractNode> nodesInCircuit) {

        List<AbstractNode> seenNodes = new ArrayList<AbstractNode>();
        if (nodesInCircuit.isEmpty()) {
            return false;
        }
        AbstractNode firstNode = nodesInCircuit.get(0);
        List<AbstractNode> edgelistFirstNode = firstNode.getEdgeList();
        AbstractNode nextNode = edgelistFirstNode.get(0);

        seenNodes.add(firstNode);
        seenNodes.add(nextNode);

        return recursive(firstNode, nextNode, seenNodes, firstNode, nodesInCircuit);

    }

    private boolean recursive(AbstractNode lastNode, AbstractNode currentNode, List<AbstractNode> seenNodes,
                              AbstractNode firstNode, List<AbstractNode> nodesInCircuit) {
        List<AbstractNode> edgelistCurrentNode = currentNode.getEdgeList();
        AbstractNode node1 = edgelistCurrentNode.get(0);
        AbstractNode node2 = edgelistCurrentNode.get(1);

        AbstractNode newCurrentNode = getNextNode(lastNode, node1, node2);

        //condicion de corte
        if (newCurrentNode == firstNode) {
            return seenNodes.containsAll(nodesInCircuit);
        }
        seenNodes.add(newCurrentNode);
        return recursive(currentNode, newCurrentNode, seenNodes, firstNode, nodesInCircuit);

    }

    private AbstractNode getNextNode(AbstractNode lastNode, AbstractNode node1, AbstractNode node2) {
        AbstractNode newCurrentNode;
        if (node1 != lastNode) {
            newCurrentNode = node1;
        } else {
            newCurrentNode = node2;
        }
        return newCurrentNode;
    }
}
