package ar.fiuba.tdd.tp.nikoligames.model.rules.arithmetic;

import ar.fiuba.tdd.tp.nikoligames.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.model.rules.implementations.arithmetic.MultiplicationRule;
import ar.fiuba.tdd.tp.nikoligames.model.rules.utils.NodeWithValueCreator;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class MultiplicationRuleTest {
    @Test
    public void validRuleWithoutEmptyNodes() {
        List<String> nodeValues = Arrays.asList("1", "2", "3", "4");
        List<AbstractNode> nodes = NodeWithValueCreator.createNodesWithValues(nodeValues, false);

        MultiplicationRule rule = new MultiplicationRule(nodes, "24");
        Assert.assertEquals(false, rule.isBroken());
    }

    @Test
    public void validRuleWithEmptyNodes() {
        List<String> nodeValues = Arrays.asList("1", "2", "", "4");
        List<AbstractNode> nodes = NodeWithValueCreator.createNodesWithValues(nodeValues, false);

        MultiplicationRule rule = new MultiplicationRule(nodes, "8");
        Assert.assertEquals(false, rule.isBroken());
    }

    @Test
    public void invalidRuleWithoutEmptyNodes() {
        List<String> nodeValues = Arrays.asList("1", "2", "3", "4");
        List<AbstractNode> nodes = NodeWithValueCreator.createNodesWithValues(nodeValues, false);

        MultiplicationRule rule = new MultiplicationRule(nodes, "6");
        Assert.assertEquals(true, rule.isBroken());
    }

    @Test
    public void invalidRuleWithEmptyNodes() {
        List<String> nodeValues = Arrays.asList("1", "", "3", "4");
        List<AbstractNode> nodes = NodeWithValueCreator.createNodesWithValues(nodeValues, false);

        MultiplicationRule rule = new MultiplicationRule(nodes, "4");
        Assert.assertEquals(true, rule.isBroken());
    }

    @Test
    public void checkActualBrokenRule() {
        List<String> nodeValues = Arrays.asList("1", "", "3", "4");
        List<AbstractNode> nodes = NodeWithValueCreator.createNodesWithValues(nodeValues, false);

        MultiplicationRule rule = new MultiplicationRule(nodes, "24");
        Assert.assertEquals(false, rule.isActualBroken());
    }
}
