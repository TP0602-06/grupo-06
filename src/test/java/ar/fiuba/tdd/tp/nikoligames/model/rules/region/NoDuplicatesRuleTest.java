package ar.fiuba.tdd.tp.nikoligames.model.rules.region;

import ar.fiuba.tdd.tp.nikoligames.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.model.rules.implementations.region.NoDuplicatesRule;
import ar.fiuba.tdd.tp.nikoligames.model.rules.utils.NodeWithValueCreator;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class NoDuplicatesRuleTest {
    @Test
    public void ruleWithoutNoDuplicates() {
        List<String> nodeValues = Arrays.asList("1", "2", "3", "4");
        List<AbstractNode> nodes = NodeWithValueCreator.createNodesWithValues(nodeValues, false);

        NoDuplicatesRule rule = new NoDuplicatesRule(nodes);
        Assert.assertEquals(false, rule.isBroken());
    }

    @Test
    public void ruleWithDuplicates() {
        List<String> nodeValues = Arrays.asList("1", "2", "2", "4");
        List<AbstractNode> nodes = NodeWithValueCreator.createNodesWithValues(nodeValues, false);

        NoDuplicatesRule rule = new NoDuplicatesRule(nodes);
        Assert.assertEquals(true, rule.isBroken());
    }

    @Test
    public void ruleEmptysWithDuplicates() {
        List<String> nodeValues = Arrays.asList("1", "2", "3", "");
        List<AbstractNode> nodes = NodeWithValueCreator.createNodesWithValues(nodeValues, false);

        NoDuplicatesRule rule = new NoDuplicatesRule(nodes);
        Assert.assertEquals(false, rule.isBroken());
    }
}
