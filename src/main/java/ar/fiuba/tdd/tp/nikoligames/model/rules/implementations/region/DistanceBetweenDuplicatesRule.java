package ar.fiuba.tdd.tp.nikoligames.model.rules.implementations.region;

import ar.fiuba.tdd.tp.nikoligames.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.model.rules.RuleImplementation;

import java.util.List;

/**
 * Responsabilities:
 * 1. Check if a number is duplicated in a row or a column, the space between the duplicated
 * numbers must be equal to or larger than the value of the number.
 */
public class DistanceBetweenDuplicatesRule extends RegionAbstractRule {
    private static final int NO_DUPLICATES_DISTANCE = -1;

    public DistanceBetweenDuplicatesRule(List<AbstractNode> region) {
        super(region);
    }

    @Override
    protected boolean check() {
        for (int index = 0; index < this.region.size(); index++) {
            AbstractNode currentNode = this.region.get(index);
            int distanceToNextDuplicate = this.getDistanceToNextDuplicate(index);

            if ((currentNode.isEmpty()) || (distanceToNextDuplicate == NO_DUPLICATES_DISTANCE)) {
                continue;
            }

            int currentValue = Integer.parseInt(currentNode.getValue());
            if (currentValue > distanceToNextDuplicate) {
                return true;
            }
        }
        return false;
    }

    private int getDistanceToNextDuplicate(int nodeIndex) {
        AbstractNode node = this.region.get(nodeIndex);

        for (int index = 0; index < this.region.size(); index++) {
            AbstractNode currentNode = this.region.get(index);
            if ((index == nodeIndex) || currentNode.isEmpty()) {
                continue;
            }

            if (node.getValue().equals(currentNode.getValue())) {
                return Math.abs(nodeIndex - index) - 1;
            }
        }
        return NO_DUPLICATES_DISTANCE;
    }
}
