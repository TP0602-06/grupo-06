package ar.fiuba.tdd.tp.nikoligames.view.parentview.factory.possibleedges;

import ar.fiuba.tdd.tp.nikoligames.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.model.rules.RuleType;
import ar.fiuba.tdd.tp.nikoligames.parser.utils.RuleConfig;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by tobias on 18/10/16.
 */
public class EdgePositionGeneratorFactory {
    private List<RuleType> validTypes;
    private RuleType chosen;

    public EdgePositionGeneratorFactory() {
        this.validTypes = new ArrayList<>();
        this.validTypes.add(RuleType.DIAGONAL_VALID_EDGES_GENERATOR);
        this.validTypes.add(RuleType.HOR_VER_VALID_EDGES_GENERATOR);
    }

    public EdgePositionGenerator getPositionGenerator(Board board, List<RuleConfig> rules) {
        if ( hasEdges(rules) ) {
            return chooseGenerator(board);
        }
        return new NullEdgePositionGenerator();
    }

    private boolean hasEdges(List<RuleConfig> rules) {
        Iterator rulesIt = rules.iterator();
        while (rulesIt.hasNext()) {
            RuleConfig rule = (RuleConfig) rulesIt.next();
            if (isEdgeRule(rule)) {
                return true;
            }
        }
        return false;
    }

    private boolean isEdgeRule(RuleConfig rule) {
        Iterator validTypesIt = validTypes.iterator();
        while (validTypesIt.hasNext()) {
            RuleType type = (RuleType) validTypesIt.next();
            String ruleDefinnition = rule.getRuleDefinition().toString();
            if (type.isRule(ruleDefinnition)) {
                chosen = type;
                return true;
            }
        }
        return false;
    }

    private EdgePositionGenerator chooseGenerator(Board board) {
        if (chosen.isRule(RuleType.HOR_VER_VALID_EDGES_GENERATOR.toString())) {
            return new EdgeDiagonalPossibleGenerator(board);
        }
        return new EdgeHorizontalVerticalPositionGeneratorImpl(board);
    }
}

