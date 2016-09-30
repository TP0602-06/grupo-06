package ar.fiuba.tdd.tp.nikoligames.engine.model.rules;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.ConcreteBoard;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Se encarga de manejar todas las reglas y validarlas.
 */
public class RuleManager {
    private final ConcreteBoard board;
    private final List<Rule> rules ;

    public RuleManager(ConcreteBoard board, List<Rule> rules) {
        this.board = board;
        this.rules = rules;
    }

    //Return true if it is all right
    public boolean checkRules() {
        Iterator<Rule> iterator = rules.iterator();
        if (iterator.hasNext()) {
            Rule rule = iterator.next();
            if (rule.isBroken(board)) return false;
        }
        return true;
    }

}
