package ar.fiuba.tdd.tp.nikoligames.engine.model.rules;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.cell.AbstractCell;
import ar.fiuba.tdd.tp.nikoligames.engine.model.position.Position;
import ar.fiuba.tdd.tp.nikoligames.engine.parser.RuleConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andres on 06/10/2016.
 */
public class RulesFactory {
    public ArrayList<Rule> createRules(Board board, List<RuleConfig> rulesConfig) throws Exception {
        ArrayList<Rule> rules = new ArrayList<Rule>();
        for (RuleConfig ruleConfig : rulesConfig) {
            RuleBuilder ruleBuilder = new RuleBuilder(ruleConfig.getRuleType());
            ruleBuilder.setValue(ruleConfig.getValue());
            for (Position position : ruleConfig.getPositions()) {
                AbstractCell cell = board.getCell(position);
                ruleBuilder.addCellToRegion(cell);
            }
            Rule rule = ruleBuilder.createRule();
            rules.add(rule);
        }
        return rules;
    }
}
