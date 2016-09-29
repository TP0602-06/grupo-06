package ar.fiuba.tdd.tp.nikoligames.engine.model.rules;

import java.util.ArrayList;

/**
 * Se encarga de manejar todas las reglas y validarlas.
 */
public class RuleManager {
    ArrayList<Rule> rules;

    public RuleManager(ArrayList<Rule> rules) {
        this.rules = rules;
    }

    //Return true if it is all right
    public boolean checkRules() {
        for (Rule rule : this.rules) {
            if (rule.isBroken()) {
                return false;
            }
        }
        return true;
    }
}
