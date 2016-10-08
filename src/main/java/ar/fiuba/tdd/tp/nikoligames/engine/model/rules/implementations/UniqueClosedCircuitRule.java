package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.RuleImplementation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Responsabilidades:
 * Checkear que haya un sólo camino cerrado en un grafo planar.
 */
public class UniqueClosedCircuitRule extends RuleImplementation {
    public UniqueClosedCircuitRule(ArrayList<AbstractNode> region) {
        super(region, "");
    }

    @Override
    public boolean isBroken() {
        List<AbstractNode> nodesInCircuit = new ArrayList<AbstractNode>();
        Iterator<AbstractNode> regionIterator = region.iterator();
        while (regionIterator.hasNext()) {
            AbstractNode node = regionIterator.next();
            List<AbstractNode> edgelist = node.getEdgeList();
            int edgeListSize = edgelist.size();
            if (!((edgeListSize == 2) || (edgeListSize == 0))) {
                return true;
            } else if (edgeListSize == 2) {
                nodesInCircuit.add(node);
            }
        }
        return (!checkOnlyOneClosedCircuit(nodesInCircuit));
    }

    @Override
    public boolean isActualBroken() {
        return isBroken();//TODO revisar
    }

    private boolean checkOnlyOneClosedCircuit(List<AbstractNode> nodesInCircuit) {

        List<AbstractNode> seenNodes = new ArrayList<AbstractNode>();
        AbstractNode firstNode = nodesInCircuit.get(0);
        List<AbstractNode> edgelistFirstNode = firstNode.getEdgeList();
        AbstractNode nextNode = edgelistFirstNode.get(0);

        seenNodes.add(firstNode);
        seenNodes.add(nextNode);

        return recursive(firstNode, nextNode, seenNodes, firstNode, nodesInCircuit);

    }

    private boolean recursive(AbstractNode lastNode, AbstractNode currentNode, List<AbstractNode> seenNodes, AbstractNode firstNode, List<AbstractNode> nodesInCircuit) {
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
