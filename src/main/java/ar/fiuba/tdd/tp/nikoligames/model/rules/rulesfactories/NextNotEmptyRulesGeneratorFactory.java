package ar.fiuba.tdd.tp.nikoligames.model.rules.rulesfactories;

import ar.fiuba.tdd.tp.nikoligames.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.model.rules.generators.adjacentlist.AdjacentListGenerator;
import ar.fiuba.tdd.tp.nikoligames.model.rules.generators.adjacentlist.HorizontalVerticalAdjacentListGen;
import ar.fiuba.tdd.tp.nikoligames.model.rules.generators.adjacentrules.AbstractAdjacentRulesGenerator;
import ar.fiuba.tdd.tp.nikoligames.model.rules.generators.adjacentrules.PairOfAdjacentRulesGenerator;
import ar.fiuba.tdd.tp.nikoligames.parser.utils.RuleConfig;

import java.util.List;

/**
 * Created by Andres on 16/10/2016.
 */
public class NextNotEmptyRulesGeneratorFactory extends AbstractAdjacentRulesGeneratorFactory {


    @Override
    protected AbstractAdjacentRulesGenerator getAbstractAdjacentRulesGenerator(RuleConfig ruleConfig, Board board) {
        List<List<AbstractNode>> regions = this.getRegionList(ruleConfig, board);
        return new PairOfAdjacentRulesGenerator(this.adjacentList(board), regions);
    }

    @Override
    protected AdjacentListGenerator getAdjacentListGenerator(Board board) {
        return new HorizontalVerticalAdjacentListGen(board);
    }
}
