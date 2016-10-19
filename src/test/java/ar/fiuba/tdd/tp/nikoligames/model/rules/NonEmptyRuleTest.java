package ar.fiuba.tdd.tp.nikoligames.model.rules;

import ar.fiuba.tdd.tp.nikoligames.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.model.rules.implementations.region.NonEmptyRegionRule;
import ar.fiuba.tdd.tp.nikoligames.model.rules.utils.NodeWithValueCreator;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by matias on 11/10/16.
 */
public class NonEmptyRuleTest {

    @Test
    public void ruleWithEmptyNodes() {
        List<String> nodeValues = Arrays.asList("1", "", "3", "4");
        List<AbstractNode> nodes = NodeWithValueCreator.createNodesWithValues(nodeValues, true);

        NonEmptyRegionRule rule = new NonEmptyRegionRule(nodes);
        Assert.assertEquals(true, rule.isBroken());
        Assert.assertEquals(false, rule.isActualBroken());
    }
}
