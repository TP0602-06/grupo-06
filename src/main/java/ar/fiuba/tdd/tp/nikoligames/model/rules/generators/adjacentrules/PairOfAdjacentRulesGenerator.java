package ar.fiuba.tdd.tp.nikoligames.model.rules.generators.adjacentrules;

import ar.fiuba.tdd.tp.nikoligames.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.model.rules.Rule;
import ar.fiuba.tdd.tp.nikoligames.model.rules.implementations.circuit.NoNotVisitedAdjacentNodesInSameRegionRule;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by german on 10/7/2016.
 * Responsibilites:
 * 1.Creates a list of NoNotVisitedAdjacentNodesInSameRegion rules.
 */
public class PairOfAdjacentRulesGenerator extends AbstractAdjacentRulesGenerator {

    private final List<List<AbstractNode>> regions;

    public PairOfAdjacentRulesGenerator(Map<AbstractNode, List<AbstractNode>> adjacentList, List<List<AbstractNode>> regions) {
        super(adjacentList);
        this.regions = regions;
    }

    @Override
    void createRule(AbstractNode node, List<AbstractNode> nodeAdjacentList, List<Rule> rulesGenerated) {

        Iterator<AbstractNode> iterator = nodeAdjacentList.iterator();
        while (iterator.hasNext()) {
            List<AbstractNode> ruleRegion = new ArrayList<AbstractNode>();
            AbstractNode nextNode = iterator.next();
            ruleRegion.add(node);
            ruleRegion.add(nextNode);
            Rule rule = new NoNotVisitedAdjacentNodesInSameRegionRule(ruleRegion, regions);
            rulesGenerated.add(rule);
        }

    }
}
