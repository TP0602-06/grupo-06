package ar.fiuba.tdd.tp.nikoligames.engine.model.rules;

import java.util.ArrayList;

/**
 * Created by Andres on 27/09/2016.
 */
public class RuleManager {
    ArrayList<Rule> rules;

    RuleManager(ArrayList<Rule> rules) {
        this.rules = rules;
    }

    public boolean checkRules() {
        for (Rule rule : this.rules) {
            if (rule.isBroken()) {
                return false;
            }
        }
        return true;
    }
}
