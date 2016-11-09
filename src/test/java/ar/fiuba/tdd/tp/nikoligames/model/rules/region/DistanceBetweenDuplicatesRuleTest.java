package ar.fiuba.tdd.tp.nikoligames.model.rules.region;

import ar.fiuba.tdd.tp.nikoligames.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.model.rules.implementations.region.DistanceBetweenDuplicatesRule;
import ar.fiuba.tdd.tp.nikoligames.model.rules.utils.NodeWithValueCreator;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DistanceBetweenDuplicatesRuleTest {
    @Test
    public void ruleWithoutDuplicates() {
        List<String> nodeValues = Arrays.asList("1", "2", "3", "4");
        List<AbstractNode> nodes = NodeWithValueCreator.createNodesWithValues(nodeValues, true);

        DistanceBetweenDuplicatesRule rule = new DistanceBetweenDuplicatesRule(nodes);
        Assert.assertEquals(false, rule.isBroken());
        Assert.assertEquals(false, rule.isActualBroken());
    }

    @Test
    public void ruleWithDuplicatesAtCorrectDistance() {
        List<String> nodeValues = Arrays.asList("2", "1", "3", "2");
        List<AbstractNode> nodes = NodeWithValueCreator.createNodesWithValues(nodeValues, true);

        DistanceBetweenDuplicatesRule rule = new DistanceBetweenDuplicatesRule(nodes);
        Assert.assertEquals(false, rule.isBroken());
        Assert.assertEquals(false, rule.isActualBroken());
    }

    @Test
    public void ruleWithDuplicatesAtLessDistance() {
        List<String> nodeValues = Arrays.asList("2", "1", "2");
        List<AbstractNode> nodes = NodeWithValueCreator.createNodesWithValues(nodeValues, true);

        DistanceBetweenDuplicatesRule rule = new DistanceBetweenDuplicatesRule(nodes);
        Assert.assertEquals(true, rule.isBroken());
        Assert.assertEquals(true, rule.isActualBroken());
    }
}
