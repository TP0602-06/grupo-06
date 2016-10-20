package ar.fiuba.tdd.tp.nikoligames.model.rules.arithmetic;

import ar.fiuba.tdd.tp.nikoligames.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.model.rules.implementations.arithmetic.AdditionRule;
import ar.fiuba.tdd.tp.nikoligames.model.rules.utils.NodeWithValueCreator;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by matias on 11/10/16.
 */
public class AdditionRuleTest {
    @Test
    public void validRuleWithoutEmptyNodes() {
        List<String> nodeValues = Arrays.asList("1", "2", "3", "4");
        List<AbstractNode> nodes = NodeWithValueCreator.createNodesWithValues(nodeValues, false);

        AdditionRule rule = new AdditionRule(nodes, "10");
        Assert.assertEquals(false, rule.isBroken());
    }

    @Test
    public void validRuleWithEmptyNodes() {
        List<String> nodeValues = Arrays.asList("1", "2", "", "4");
        List<AbstractNode> nodes = NodeWithValueCreator.createNodesWithValues(nodeValues, false);

        AdditionRule rule = new AdditionRule(nodes, "7");
        Assert.assertEquals(false, rule.isBroken());
    }

    @Test
    public void invalidRuleWithoutEmptyNodes() {
        List<String> nodeValues = Arrays.asList("1", "2", "3", "4");
        List<AbstractNode> nodes = NodeWithValueCreator.createNodesWithValues(nodeValues, false);

        AdditionRule rule = new AdditionRule(nodes, "6");
        Assert.assertEquals(true, rule.isBroken());
    }

    @Test
    public void invalidRuleWithEmptyNodes() {
        List<String> nodeValues = Arrays.asList("1", "2", "", "4");
        List<AbstractNode> nodes = NodeWithValueCreator.createNodesWithValues(nodeValues, false);

        AdditionRule rule = new AdditionRule(nodes, "4");
        Assert.assertEquals(true, rule.isBroken());
    }
}
