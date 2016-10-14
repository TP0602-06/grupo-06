package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.nodecondition;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.ConcreteNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.Rule;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.nodecondition.ValidInputValueRule;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * Created by matias on 13/10/16.
 */
public class ValidInputValueRuleTest {


    private Rule setup(List<String> nodeValues, List<String> validValues) {
        List<AbstractNode> nodes = this.createNodesWithValues(nodeValues);
        Set<String> validValuesSet = getValidValuesSet(validValues);

        return new ValidInputValueRule(nodes, validValuesSet);
    }

    private List<AbstractNode> createNodesWithValues(List<String> values) {
        List<AbstractNode> nodes = new ArrayList<AbstractNode>();
        Iterator<String> valueIterator = values.iterator();
        while (valueIterator.hasNext()) {
            String value = valueIterator.next();
            AbstractNode node = new ConcreteNode(value, false);
            nodes.add(node);
        }
        return nodes;
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
