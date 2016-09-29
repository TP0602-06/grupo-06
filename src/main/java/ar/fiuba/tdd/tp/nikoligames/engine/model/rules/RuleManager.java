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

    // En el futuro no va a haber otras reglas a chequear
    private boolean check(boolean actual){
        for (Rule rule : this.rules) {
            if (rule.isActualBroken() && actual) {
                return false;
            }
            if (rule.isBroken() && !actual) {
                return false;
            }
        }
        return true;
    }

    //Return true if it is all right
    public boolean checkRules() {
        return check(false);
    }

    public  boolean checkActualRules(){
        return check(true);
    }
}
