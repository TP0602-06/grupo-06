package ar.fiuba.tdd.tp.nikoligames.engine.model.rules;

import java.util.ArrayList;

/**
 * Created by Andres on 27/09/2016.
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
