package ar.fiuba.tdd.tp.nikoligames.model.rules.implementations.region;

import ar.fiuba.tdd.tp.nikoligames.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.model.rules.RuleImplementation;

import java.util.List;

/**
 * Created by matias on 05/11/16.
 */
public class DistanceBetweenDuplicatesRule extends RuleImplementation {
    private static final int NO_DUPLICATES_DISTANCE = -1;

    public DistanceBetweenDuplicatesRule(List<AbstractNode> region) {
        super(region, "");
    }

    @Override
    public boolean isBroken() {
        return this.check();
    }

    @Override
    public boolean isActualBroken() {
        return this.check();
    }

    private boolean check() {
        for (int index = 0; index < this.region.size(); index++) {
            AbstractNode currentNode = this.region.get(index);
            if (currentNode.isEmpty()) {
                continue;
            }

            int currentValue = Integer.parseInt(currentNode.getValue());
            int distanceToNextDuplicate = this.getDistanceToNextDuplicate(index);
            if (distanceToNextDuplicate == NO_DUPLICATES_DISTANCE) {
                continue;
            }

            if (currentValue > distanceToNextDuplicate) {
                return true;
            }
        }
        return false;
    }

    private int getDistanceToNextDuplicate(int nodeIndex) {
        AbstractNode node = this.region.get(nodeIndex);

        for (int index = 0; index < this.region.size(); index++) {
            if (index == nodeIndex) {
                continue;
            }

            AbstractNode currentNode = this.region.get(index);
            if (currentNode.isEmpty()) {
                continue;
            }

            if (node.getValue() == currentNode.getValue()) {
                return Math.abs(nodeIndex - index) - 1;
            }
        }
        return NO_DUPLICATES_DISTANCE;
    }
}
