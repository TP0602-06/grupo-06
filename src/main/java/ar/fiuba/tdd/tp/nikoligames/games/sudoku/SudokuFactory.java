package ar.fiuba.tdd.tp.nikoligames.games.sudoku;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.engine.model.factory.AbstractGameFactory;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.Rule;

import java.util.ArrayList;

/**
 * Created by Andres on 28/09/2016.
 */
public class SudokuFactory extends AbstractGameFactory {
    protected ArrayList<Rule> getRules(Board board) {
        SudokuRulesFactory sudokuRulesFactory = new SudokuRulesFactory(board);
        return sudokuRulesFactory.getRules();
    }

}
