package tdd.engine.model;


public interface RuleAbstractFactory {

    Rule createSumRule(int sum);

    Rule createNonRepeteableRule();

}
