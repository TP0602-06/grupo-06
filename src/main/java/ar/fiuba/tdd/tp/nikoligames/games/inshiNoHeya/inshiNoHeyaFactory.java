package ar.fiuba.tdd.tp.nikoligames.games.inshiNoHeya;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.ConcreteBoard;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.RuleImplementation;

import java.util.ArrayList;

/**
 * Created by fedebrasburg on 9/29/16.
 */
public class inshiNoHeyaFactory extends AbstractGameFactory {

    private ArrayList<RuleImplementation> listOfRegions;

    public  inshiNoHeyaFactory( ArrayList<RuleImplementation> listOfRegions){
        this.listOfRegions = listOfRegions;
    }

    protected ArrayList<ar.fiuba.tdd.tp.nikoligames.engine.model.rules.Rule> getRules(ConcreteBoard board) {
        inshiNoHeyaRulesFactory inshiRulesFactory = new inshiNoHeyaRulesFactory(board,listOfRegions);
        return inshiRulesFactory.getRules();
    }
}
