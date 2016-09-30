package ar.fiuba.tdd.tp.nikoligames.games.inshiNoHeya;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.engine.model.factory.GroupRulesFactory;
import ar.fiuba.tdd.tp.nikoligames.engine.model.factory.RulesFactory;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.Rule;
import ar.fiuba.tdd.tp.nikoligames.engine.parser.regionrule.RegionRuleNumber;
import javafx.geometry.Pos;

import java.util.ArrayList;

/**
 * Created by fedebrasburg on 9/29/16.
 */
public class inshiNoHeyaRulesFactory {

    private Board board;
    private ArrayList<RegionRuleNumber> listOfRegions;

    inshiNoHeyaRulesFactory(Board board, ArrayList<RegionRuleNumber> listOfRegions) {
        this.board = board;
        this.listOfRegions = listOfRegions;
    }

    public ArrayList<Rule> getRules() {
        ArrayList<Rule> rules = new ArrayList<>();


        RulesFactory ruleFactory = new RulesFactory();
        for(RegionRuleNumber region : listOfRegions){
            rules.add(ruleFactory.createMultiplyRule(region.number(),board.getArrayOfCells(region.listOfPositions())));
        }


        GroupRulesFactory factory = new GroupRulesFactory();
        factory.addColumnsRules(rules,this.board);
        factory.addRowsRules(rules,this.board);
        return rules;
    }




}
