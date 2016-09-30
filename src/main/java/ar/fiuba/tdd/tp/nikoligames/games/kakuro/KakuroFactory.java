package ar.fiuba.tdd.tp.nikoligames.games.kakuro;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.ConcreteBoard;

import java.util.ArrayList;

/**
 * Created by Andres on 28/09/2016.
 */
public class KakuroFactory extends AbstractGameFactory {
    protected ArrayList<Rule> getRules(ConcreteBoard board) {
        KakuroRulesFactory sudokuRulesFactory = new KakuroRulesFactory(board);
        return sudokuRulesFactory.getRules();
    }
}
