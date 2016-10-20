package ar.fiuba.tdd.tp.nikoligames.model.rules.rulesfactories;

import ar.fiuba.tdd.tp.nikoligames.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.model.rules.Rule;
import ar.fiuba.tdd.tp.nikoligames.model.rules.generators.adjacentlist.AdjacentListGenerator;
import ar.fiuba.tdd.tp.nikoligames.model.rules.generators.adjacentrules.AbstractAdjacentRulesGenerator;
import ar.fiuba.tdd.tp.nikoligames.parser.utils.RuleConfig;

import java.util.List;
import java.util.Map;

/**
 * Created by Andres on 16/10/2016.
 */
public abstract class AbstractAdjacentRulesGeneratorFactory extends AbstractMultipleRuleFactory {
    @Override
    protected final List<Rule> createRules(RuleConfig ruleConfig, Board board) {
        AbstractAdjacentRulesGenerator abstractAdjacentRulesGenerator = this.getAbstractAdjacentRulesGenerator(ruleConfig, board);
        return abstractAdjacentRulesGenerator.getAdjacentRules();
    }

    protected Map<AbstractNode, List<AbstractNode>> adjacentList(Board board) {
        AdjacentListGenerator adjacentListGenerator = this.getAdjacentListGenerator(board);
        Map<AbstractNode, List<AbstractNode>> adjacentList = adjacentListGenerator.getAdjacentList();
        return adjacentList;
    }

    protected abstract AbstractAdjacentRulesGenerator getAbstractAdjacentRulesGenerator(RuleConfig ruleConfig, Board board);

    protected abstract AdjacentListGenerator getAdjacentListGenerator(Board board);
}
