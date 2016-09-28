package ar.fiuba.tdd.tp.nikoligames;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.DrawableBoard;
import ar.fiuba.tdd.tp.nikoligames.engine.model.factory.GameFactory;
import ar.fiuba.tdd.tp.nikoligames.engine.model.game.Game;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.Rule;
import ar.fiuba.tdd.tp.nikoligames.games.sudoku.SudokuRulesFactory;
import ar.fiuba.tdd.tp.nikoligames.view.parentview.factory.FactoryGameView;
import ar.fiuba.tdd.tp.nikoligames.view.parentview.GameView;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        //FileReader fileReader = new FileReader():

        //SudokuRulesFactory sudokuRulesFactory = new SudokuRulesFactory();


        GameFactory gameFactory = new GameFactory() {
            @Override
            protected ArrayList<Rule> getRules(Board board) {
                return null;
            }
        };
        //try {
            //Game game = gameFactory.crateGame(fileReader);
            //DrawableBoard drawableBoard = game.getDrawableBoard();

            FactoryGameView factoryView = new FactoryGameView();
            //GameView view = factoryView.createDefaultGameView(drawableBoard);

            //view.setVisible(true);

            System.out.println("nikoli games :D");

        //} catch (FileNotFoundException e) {
         //   e.printStackTrace();
        //}

    }
}
