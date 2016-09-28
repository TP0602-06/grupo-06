package tdd.engine.model;


public class RulesFactory implements RuleAbstractFactory {

    private static RulesFactory instance = null;

    private  RulesFactory(){}

    public Rule createSumRule(int sum) {
        return new SumRule(sum);
    }

    public Rule createNonRepeteableRule() {
        return  new NonRepeteableRule();
    }

    //Singleton
    public static  RuleAbstractFactory getInstance() {
        if (instance == null) {
            instance = new RulesFactory();
        }
        return instance;
    }

}
