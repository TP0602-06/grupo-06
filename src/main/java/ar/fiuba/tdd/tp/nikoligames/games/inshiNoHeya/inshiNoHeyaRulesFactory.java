package ar.fiuba.tdd.tp.nikoligames.games.inshiNoHeya;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.AbstractCell;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Position;
import ar.fiuba.tdd.tp.nikoligames.engine.model.factory.GroupRulesFactory;
import ar.fiuba.tdd.tp.nikoligames.engine.model.factory.RulesFactory;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.Rule;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.impl.AdditionRule;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.impl.NoDuplicatesRule;
import javafx.geometry.Pos;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by fedebrasburg on 9/29/16.
 */
public class inshiNoHeyaRulesFactory {

    private Board board;
    private ArrayList<RegionOfNumber> listOfRegions;

    inshiNoHeyaRulesFactory(Board board, ArrayList<RegionOfNumber> listOfRegions) {
        this.board = board;
        this.listOfRegions = listOfRegions;
    }

    public ArrayList<Rule> getRules() {
        ArrayList<Rule> rules = new ArrayList<>();


        RulesFactory ruleFactory = new RulesFactory();
        for(RegionOfNumber region : listOfRegions){
            rules.add(ruleFactory.createMultiplyRule(region.number(),board.getArrayOfCells(region.listOfPositions())));
        }


        GroupRulesFactory factory = new GroupRulesFactory();
        factory.addColumnsRules(rules,this.board);
        factory.addRowsRules(rules,this.board);
        return rules;
    }




}
