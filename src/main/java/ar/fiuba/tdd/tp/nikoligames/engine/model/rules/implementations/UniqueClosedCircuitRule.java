package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.Node;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Responsabilidades:
 * Checkear que haya un sólo camino cerrado en un grafo planar
 */
public class UniqueClosedCircuitRule extends RuleImplementation {
    public UniqueClosedCircuitRule(ArrayList<Node> region) {
        super(region, "");
    }

    @Override
    public boolean isBroken() {
        List<Node> nodesInCircuit = new ArrayList<Node>();

        Iterator<Node> regionIterator = region.iterator();
        while (regionIterator.hasNext()) {
            Node node = regionIterator.next();
            List<Node> edgelist = node.getEdgeList();
            int edgeListSize = edgelist.size();
            if (!(edgeListSize == 2) || (edgeListSize == 0)) {
                return true;
            } else if (edgeListSize == 2) {
                nodesInCircuit.add(node);
            }
        }
        return (!checkOnlyOneClosedCircuit(nodesInCircuit));
    }

    private boolean checkOnlyOneClosedCircuit(List<Node> nodesInCircuit) {

        List<Node> seenNodes = new ArrayList<Node>();
        Node firstNode = nodesInCircuit.get(0);
        List<Node> edgelistFirstNode = firstNode.getEdgeList();
        Node nextNode = edgelistFirstNode.get(0);

        seenNodes.add(firstNode);
        seenNodes.add(nextNode);

        return recursive(firstNode, nextNode, seenNodes, firstNode, nodesInCircuit);

    }

    private boolean recursive(Node lastNode, Node currentNode, List<Node> seenNodes, Node firstNode, List<Node> nodesInCircuit) {
        List<Node> edgelistCurrentNode = currentNode.getEdgeList();
        Node node1 = edgelistCurrentNode.get(0);
        Node node2 = edgelistCurrentNode.get(1);

        Node newCurrentNode = getNextNode(lastNode, node1, node2);

        //condicion de corte
        if (newCurrentNode == firstNode) {
            return seenNodes.containsAll(nodesInCircuit);
        }
        seenNodes.add(newCurrentNode);
        return recursive(currentNode, newCurrentNode, seenNodes, firstNode, nodesInCircuit);

    }

    private Node getNextNode(Node lastNode, Node node1, Node node2) {
        Node newCurrentNode;
        if (node1 != lastNode) {
            newCurrentNode = node1;
        } else {
            newCurrentNode = node2;
        }
        return newCurrentNode;
    }
}
