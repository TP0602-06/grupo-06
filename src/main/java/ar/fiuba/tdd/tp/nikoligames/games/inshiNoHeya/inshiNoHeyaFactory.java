package ar.fiuba.tdd.tp.nikoligames.games.inshiNoHeya;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.engine.model.factory.AbstractGameFactory;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.Rule;
import ar.fiuba.tdd.tp.nikoligames.engine.parser.regionrule.RegionRuleNumber;

import java.util.ArrayList;

/**
 * Created by fedebrasburg on 9/29/16.
 */
public class inshiNoHeyaFactory extends AbstractGameFactory {

    private ArrayList<RegionRuleNumber> listOfRegions;

    public  inshiNoHeyaFactory( ArrayList<RegionRuleNumber> listOfRegions){
        this.listOfRegions = listOfRegions;
    }

    protected ArrayList<Rule> getRules(Board board) {
        inshiNoHeyaRulesFactory inshiRulesFactory = new inshiNoHeyaRulesFactory(board,listOfRegions);
        return inshiRulesFactory.getRules();
    }
}
