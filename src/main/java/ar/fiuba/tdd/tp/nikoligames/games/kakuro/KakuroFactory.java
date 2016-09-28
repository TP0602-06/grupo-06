package ar.fiuba.tdd.tp.nikoligames.games.kakuro;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.engine.model.factory.GameFactory;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.Rule;

import java.util.ArrayList;

/**
 * Created by Andres on 28/09/2016.
 */
public class KakuroFactory extends GameFactory {
    protected ArrayList<Rule> getRules(Board board) {
        KakuroRulesFactory sudokuRulesFactory = new KakuroRulesFactory(board);
        return sudokuRulesFactory.getRules();
    }
}
