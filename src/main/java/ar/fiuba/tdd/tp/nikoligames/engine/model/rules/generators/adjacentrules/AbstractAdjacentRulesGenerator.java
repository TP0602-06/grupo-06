package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.generators.adjacentrules;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.Rule;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by german on 10/8/2016.
 */
public abstract class AbstractAdjacentRulesGenerator {

    protected final Map<AbstractNode, List<AbstractNode>> adjacentList;

    public AbstractAdjacentRulesGenerator(Map<AbstractNode, List<AbstractNode>> adjacentList) {
        this.adjacentList = adjacentList;
    }

    public List<Rule> getAdjacentRules() {
        List<Rule> rulesGenerated = new ArrayList<Rule>();

        Iterator<Map.Entry<AbstractNode, List<AbstractNode>>> entries = adjacentList.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<AbstractNode, List<AbstractNode>> pair = entries.next();

            AbstractNode node = pair.getKey();

            List<AbstractNode> nodeAdjacentList = pair.getValue();

            createRule(node, nodeAdjacentList,rulesGenerated);

        }

        return rulesGenerated;
    }

    abstract void createRule(AbstractNode node, List<AbstractNode> nodeAdjacentList, List<Rule> rulesGenerated);
}
