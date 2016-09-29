package ar.fiuba.tdd.tp.nikoligames.games.inshiNoHeya;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.engine.model.factory.AbstractGameFactory;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.Rule;
import ar.fiuba.tdd.tp.nikoligames.games.kakuro.KakuroRulesFactory;

import java.util.ArrayList;

/**
 * Created by fedebrasburg on 9/29/16.
 */
public class inshiNoHeyaFactory extends AbstractGameFactory {
    protected ArrayList<Rule> getRules(Board board) {
        inshiNoHeyaRulesFactory inshiRulesFactory = new inshiNoHeyaRulesFactory(board);
        return inshiRulesFactory.getRules();
    }
}
