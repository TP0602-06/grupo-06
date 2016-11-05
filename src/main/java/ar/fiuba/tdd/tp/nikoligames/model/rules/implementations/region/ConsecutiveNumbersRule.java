package ar.fiuba.tdd.tp.nikoligames.model.rules.implementations.region;

import ar.fiuba.tdd.tp.nikoligames.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.model.rules.RuleImplementation;

import java.util.List;

/**
 * Created by matias on 05/11/16.
 */
public class ConsecutiveNumbersRule extends RuleImplementation {
    public ConsecutiveNumbersRule(List<AbstractNode> nodes) {
        super(nodes, "");
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
        this.region.sort((node1, node2) -> node1.getValue().compareTo(node2.getValue()));
        for (int index = 0; index < (this.region.size() - 1); index++) {
            AbstractNode currentNode = this.region.get(index);
            AbstractNode nextNode = this.region.get(index + 1);

            if (currentNode.isEmpty() || nextNode.isEmpty()) {
                continue;
            }

            int currentValue = Integer.parseInt(currentNode.getValue());
            int nextValue = Integer.parseInt(nextNode.getValue());

            if (nextValue != (currentValue + 1)) {
                return true;
            }
        }
        return false;
    }
}
