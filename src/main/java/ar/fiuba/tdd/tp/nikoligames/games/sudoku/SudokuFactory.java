package ar.fiuba.tdd.tp.nikoligames.games.sudoku;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.ConcreteBoard;

import java.util.ArrayList;

/**
 * Created by Andres on 28/09/2016.
 */
public class SudokuFactory extends AbstractGameFactory {
    protected ArrayList<Rule> getRules(ConcreteBoard board) {
        SudokuRulesFactory sudokuRulesFactory = new SudokuRulesFactory(board);
        return sudokuRulesFactory.getRules();
    }

}
