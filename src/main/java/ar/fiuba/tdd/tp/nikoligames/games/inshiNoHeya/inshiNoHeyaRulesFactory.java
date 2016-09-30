package ar.fiuba.tdd.tp.nikoligames.games.inshiNoHeya;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.ConcreteBoard;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.RuleImplementation;

import java.util.ArrayList;

/**
 * Created by fedebrasburg on 9/29/16.
 */
public class inshiNoHeyaRulesFactory {

    private ConcreteBoard board;
    private ArrayList<RuleImplementation> listOfRegions;

    inshiNoHeyaRulesFactory(ConcreteBoard board, ArrayList<RuleImplementation> listOfRegions) {
        this.board = board;
        this.listOfRegions = listOfRegions;
    }

    public ArrayList<ar.fiuba.tdd.tp.nikoligames.engine.model.rules.Rule> getRules() {
        ArrayList<ar.fiuba.tdd.tp.nikoligames.engine.model.rules.Rule> rules = new ArrayList<>();


        RulesFactory ruleFactory = new RulesFactory();
        for(RuleImplementation region : listOfRegions){
            rules.add(ruleFactory.createMultiplyRule(region.number(),board.getArrayOfCells(region.listOfPositions())));
        }


        GroupRulesFactory factory = new GroupRulesFactory();
        factory.addColumnsRules(rules,this.board);
        factory.addRowsRules(rules,this.board);
        return rules;
    }




}
