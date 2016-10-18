package ar.fiuba.tdd.tp.nikoligames.model.rules.nodecondition;

import ar.fiuba.tdd.tp.nikoligames.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.model.rules.Rule;
import ar.fiuba.tdd.tp.nikoligames.model.rules.implementations.nodecondition.ValidInputValueRule;
import ar.fiuba.tdd.tp.nikoligames.model.rules.utils.NodeWithValueCreator;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * Created by matias on 13/10/16.
 */
public class ValidInputValueRuleTest {


    private Rule setup(List<String> nodeValues, List<String> validValues) {
        List<AbstractNode> nodes = NodeWithValueCreator.createNodesWithValues(nodeValues, false);
        Set<String> validValuesSet = getValidValuesSet(validValues);

        return new ValidInputValueRule(nodes, validValuesSet);
    }

    private Set<String> getValidValuesSet(List<String> validValues) {
        return new HashSet<String>(validValues);
    }

    @Test
    public void ruleWithAllValidValues() {

        List<String> nodeValues = Arrays.asList("1", "2", "3");
        List<String> validValues = Arrays.asList("1", "2", "3");
        Rule rule = setup(nodeValues, validValues);

        Assert.assertEquals(false, rule.isBroken());
    }

    @Test
    public void ruleWithInvalidValue() {

        List<String> nodeValues = Arrays.asList("1", "5", "3");
        List<String> validValues = Arrays.asList("1", "2", "3");
        Rule rule = setup(nodeValues, validValues);

        Assert.assertEquals(true, rule.isBroken());
    }

    @Test
    public void ruleWithEmptyValidValue() {
        List<String> nodeValues = Arrays.asList("1", "", "3");
        List<String> validValues = Arrays.asList("1", "2", "3");
        Rule rule = setup(nodeValues, validValues);

        Assert.assertEquals(false, rule.isBroken());
    }
}
