package ar.fiuba.tdd.tp.nikoligames.model.rules;

import ar.fiuba.tdd.tp.nikoligames.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.model.rules.implementations.region.ConsecutiveNumbersRule;
import ar.fiuba.tdd.tp.nikoligames.model.rules.utils.NodeWithValueCreator;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by matias on 05/11/16.
 */
public class ConsecutiveNumbersRuleTest {
    @Test
    public void ruleWithConsecutiveNumbers() {
        List<String> nodeValues = Arrays.asList("1", "2", "3", "4");
        List<AbstractNode> nodes = NodeWithValueCreator.createNodesWithValues(nodeValues, false);

        ConsecutiveNumbersRule rule = new ConsecutiveNumbersRule(nodes);
        Assert.assertEquals(false, rule.isBroken());
    }

    @Test
    public void ruleWithoutConsecutiveNumbers() {
        List<String> nodeValues = Arrays.asList("1", "2", "5", "6");
        List<AbstractNode> nodes = NodeWithValueCreator.createNodesWithValues(nodeValues, false);

        ConsecutiveNumbersRule rule = new ConsecutiveNumbersRule(nodes);
        Assert.assertEquals(true, rule.isBroken());
    }
}
