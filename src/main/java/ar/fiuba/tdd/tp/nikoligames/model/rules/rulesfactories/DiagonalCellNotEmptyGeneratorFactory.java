package ar.fiuba.tdd.tp.nikoligames.model.rules.rulesfactories;

import ar.fiuba.tdd.tp.nikoligames.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.model.rules.Rule;
import ar.fiuba.tdd.tp.nikoligames.model.rules.generators.adjacentrules.DiagonalCellNotEmptyAndExluyentGenerator;
import ar.fiuba.tdd.tp.nikoligames.parser.utils.RuleConfig;

import java.util.List;

/**
 * Created by german on 10/18/2016.
 */
public class DiagonalCellNotEmptyGeneratorFactory extends AbstractMultipleRuleFactory {
    @Override
    protected final List<Rule> createRules(RuleConfig ruleConfig, Board board) {
        DiagonalCellNotEmptyAndExluyentGenerator gen = new DiagonalCellNotEmptyAndExluyentGenerator(board);
        return gen.createRules();
    }
}
