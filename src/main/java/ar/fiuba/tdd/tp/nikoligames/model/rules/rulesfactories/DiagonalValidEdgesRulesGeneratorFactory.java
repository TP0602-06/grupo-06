package ar.fiuba.tdd.tp.nikoligames.model.rules.rulesfactories;

import ar.fiuba.tdd.tp.nikoligames.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.model.rules.generators.adjacentlist.AdjacentListGenerator;
import ar.fiuba.tdd.tp.nikoligames.model.rules.generators.adjacentlist.DiagonalAdjacentListGen;
import ar.fiuba.tdd.tp.nikoligames.model.rules.generators.adjacentrules.AbstractAdjacentRulesGenerator;
import ar.fiuba.tdd.tp.nikoligames.model.rules.generators.adjacentrules.ValidEdgesRules;
import ar.fiuba.tdd.tp.nikoligames.parser.utils.RuleConfig;

/**
 * Created by Andres on 16/10/2016.
 */
public class DiagonalValidEdgesRulesGeneratorFactory extends AbstractAdjacentRulesGeneratorFactory {
    @Override
    protected AbstractAdjacentRulesGenerator getAbstractAdjacentRulesGenerator(RuleConfig ruleConfig, Board board) {
        return new ValidEdgesRules(this.adjacentList(board));
    }

    @Override
    protected AdjacentListGenerator getAdjacentListGenerator(Board board) {
        return new DiagonalAdjacentListGen(board);
    }
}
