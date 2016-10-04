package ar.fiuba.tdd.tp.nikoligames.engine.model.rules;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Board;

import java.util.Iterator;
import java.util.List;

/**
 * Se encarga de manejar todas las reglas y validarlas.
 */
public class RuleManager {
    private final Board board;
    private final List<Rule> rules;

    public RuleManager(Board board, List<Rule> rules) {
        this.board = board;
        this.rules = rules;
    }

    // En el futuro no va a haber otras reglas a chequear
    private boolean check(boolean actual) {
        for (Rule rule : this.rules) {
            if (rule.isActualBroken(this.board) && actual) {
                return false;
            }
            if (rule.isBroken(this.board) && !actual) {
                return false;
            }
        }
        return true;
    }

    //Return true if it is all right
    public boolean checkRules() {
        return check(false);
    }

    public boolean checkActualRules() {
        return check(true);
    }

}
