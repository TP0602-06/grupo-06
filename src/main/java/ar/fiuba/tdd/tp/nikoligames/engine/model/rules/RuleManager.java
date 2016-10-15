package ar.fiuba.tdd.tp.nikoligames.engine.model.rules;

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
        return check(ruleCommand);
    }

    public boolean checkActualRules() {
        RuleCommand ruleCommand = new IsActualBrokenCommand();
        return check(ruleCommand);
    }

    public boolean check(RuleCommand ruleCommand) {
        return !rules.stream().anyMatch(rule -> ruleCommand.execute(rule));
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
        public boolean execute(Rule rule) {
            return rule.isActualBroken();
        }
    }
}
