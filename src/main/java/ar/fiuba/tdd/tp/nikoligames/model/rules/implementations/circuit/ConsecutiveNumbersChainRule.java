package ar.fiuba.tdd.tp.nikoligames.model.rules.implementations.circuit;

import ar.fiuba.tdd.tp.nikoligames.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.model.rules.RuleImplementation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by matias on 06/11/16.
 */
public class ConsecutiveNumbersChainRule extends RuleImplementation {
    public ConsecutiveNumbersChainRule(List<AbstractNode> region) {
        super(region, "");
    }

    @Override
    public boolean isBroken() {
        AbstractNode firstNode = this.getFirstNodeInChain();
        if (firstNode == null) {
            return true;
        }
        return !this.hasConsecutiveNumbers(firstNode);
    }

    @Override
    public boolean isActualBroken() {
        return this.isBroken();
    }

    private boolean hasConsecutiveNumbers(AbstractNode node) {
        ArrayList<AbstractNode> visitedNodes = new ArrayList<>();
        visitedNodes.add(node);
        return this.hasConsecutiveNumbers(node, visitedNodes);
    }

    private boolean hasConsecutiveNumbers(AbstractNode node, List<AbstractNode> visitedNodes) {
        boolean hasConsecutiveNumbers = true;
        int nodeValue = Integer.parseInt(node.getValue());
        for (AbstractNode edge : node.getEdgeList()) {
            if (visitedNodes.contains(edge)) {
                continue;
            }
            visitedNodes.add(edge);
            int edgeValue = Integer.parseInt(edge.getValue());
            if (Math.abs(nodeValue - edgeValue) > 1) {
                return false;
            }
            hasConsecutiveNumbers &= this.hasConsecutiveNumbers(edge, visitedNodes);
        }
        return hasConsecutiveNumbers;
    }

    private AbstractNode getFirstNodeInChain() {
        AbstractNode minNode = null;
        for (AbstractNode node : this.region) {
            if (node.isEmpty()) {
                continue;
            }
            if (minNode == null) {
                minNode = node;
            } else {
                minNode = this.getMinNode(minNode, node);
            }
        }
        return minNode;
    }

    private AbstractNode getMinNode(AbstractNode node1, AbstractNode node2) {
        int node1Value = Integer.parseInt(node1.getValue());
        int node2Value = Integer.parseInt(node2.getValue());
        if (node1Value <= node2Value) {
            return node1;
        } else {
            return node2;
        }
    }
}
