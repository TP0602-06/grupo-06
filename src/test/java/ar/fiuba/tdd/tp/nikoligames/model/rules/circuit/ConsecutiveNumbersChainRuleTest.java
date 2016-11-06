package ar.fiuba.tdd.tp.nikoligames.model.rules.circuit;

import ar.fiuba.tdd.tp.nikoligames.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.model.rules.implementations.circuit.ConsecutiveNumbersChainRule;
import ar.fiuba.tdd.tp.nikoligames.model.rules.utils.ChainEdgeCreator;
import ar.fiuba.tdd.tp.nikoligames.model.rules.utils.NodeWithValueCreator;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by matias on 06/11/16.
 */
public class ConsecutiveNumbersChainRuleTest {
    @Test
    public void ruleWithConsecutiveNumbersChain() {
        List<String> nodeValues = Arrays.asList("1", "", "", "2", "", "3", "", "4");
        List<AbstractNode> nodes = NodeWithValueCreator.createNodesWithValues(nodeValues, false);
        ChainEdgeCreator.createChain(nodes, 0, nodes.size() - 1);

        ConsecutiveNumbersChainRule rule = new ConsecutiveNumbersChainRule(nodes);
        Assert.assertEquals(false, rule.isBroken());
    }

    @Test
    public void ruleWithoutConsecutiveNumbersChain() {
        List<String> nodeValues = Arrays.asList("1", "", "3", "", "4", "", "", "2");
        List<AbstractNode> nodes = NodeWithValueCreator.createNodesWithValues(nodeValues, false);
        ChainEdgeCreator.createChain(nodes, 0, nodes.size() - 1);

        ConsecutiveNumbersChainRule rule = new ConsecutiveNumbersChainRule(nodes);
        Assert.assertEquals(true, rule.isBroken());
    }

    @Test
    public void ruleWithConsecutiveNumbersCycle() {
        List<String> nodeValues = Arrays.asList("1", "", "", "2", "", "3", "", "4");
        List<AbstractNode> nodes = NodeWithValueCreator.createNodesWithValues(nodeValues, false);
        ChainEdgeCreator.createCycle(nodes, 0, nodes.size() - 1);

        ConsecutiveNumbersChainRule rule = new ConsecutiveNumbersChainRule(nodes);
        Assert.assertEquals(false, rule.isBroken());
    }
}
