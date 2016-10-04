package ar.fiuba.tdd.tp.nikoligames.games.inshiNoHeya;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.engine.model.factory.AbstractGameFactory;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.Rule;

import java.util.ArrayList;

/**
 * Created by fedebrasburg on 9/29/16.
 */
public class InshiNoHeyaFactory extends AbstractGameFactory {


    protected ArrayList<Rule> getRules(Board board, ArrayList<RegionOfNumber> listOfRegions) {
        InshiNoHeyaRulesFactory inshiRulesFactory = new InshiNoHeyaRulesFactory(board,listOfRegions);
        return inshiRulesFactory.getRules();
    }
}
