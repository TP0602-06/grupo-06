package ar.fiuba.tdd.tp.nikoligames.model.rules.implementations.circuit;

import ar.fiuba.tdd.tp.nikoligames.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.model.rules.RuleImplementation;

import java.util.ArrayList;
import java.util.List;

/**
 * Responsibilities:
 * 1. Checks if exists a chain of consecutive numbers
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
        return this.hasConsecutiveNumbers(0, node, visitedNodes);
    }

    private boolean hasConsecutiveNumbers(int currentValue, AbstractNode node, List<AbstractNode> visitedNodes) {
        boolean hasConsecutiveNumbers = true;
        currentValue = this.getCurrentValue(node, currentValue);
        for (AbstractNode edge : node.getEdgeList()) {
            if (visitedNodes.contains(edge)) {
                continue;
            }
            visitedNodes.add(edge);
            if (!this.validEdge(edge, currentValue)) {
                return false;
            }
            hasConsecutiveNumbers &= this.hasConsecutiveNumbers(currentValue, edge, visitedNodes);
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

    private int getCurrentValue(AbstractNode node, int currentValue) {
        if (node.isEmpty()) {
            return currentValue;
        }
        return Integer.parseInt(node.getValue());
    }

    private boolean validEdge(AbstractNode edge, int currentValue) {
        if (edge.isEmpty()) {
            return true;
        }
        int edgeValue = Integer.parseInt(edge.getValue());
        return (Math.abs(currentValue - edgeValue) == 1);
    }
}
