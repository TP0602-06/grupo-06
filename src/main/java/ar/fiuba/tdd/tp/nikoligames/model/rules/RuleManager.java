package ar.fiuba.tdd.tp.nikoligames.model.rules;

import java.util.Iterator;
import java.util.List;

/**
 * Se encarga de manejar todas las reglas y validarlas.
 */
public class RuleManager {
    private final List<Rule> rules;

    public RuleManager(List<Rule> rules) {
        this.rules = rules;
    }

    //Return true if it is all right
    public boolean checkRules() {
        RuleCommand ruleCommand = new IsBrokenCommand();
        return this.check(ruleCommand);
    }

    public boolean checkActualRules() {
        RuleCommand ruleCommand = new IsActualBrokenCommand();
        return this.check(ruleCommand);
    }

    public boolean check(RuleCommand ruleCommand) {
        Iterator<Rule> iterator = rules.iterator();
        while (iterator.hasNext()) {
            Rule rule = iterator.next();
            if (ruleCommand.execute(rule)) {
                return false;
            }
        }
        return true;
    }

    private interface RuleCommand {
        boolean execute(Rule rule);
    }

    private static class IsBrokenCommand implements RuleCommand {
        public boolean execute(Rule rule) {
            return rule.isBroken();
        }
    }

    private static class IsActualBrokenCommand implements RuleCommand {
        public  boolean execute(Rule rule) {
            return rule.isActualBroken();
        }
    }
}
