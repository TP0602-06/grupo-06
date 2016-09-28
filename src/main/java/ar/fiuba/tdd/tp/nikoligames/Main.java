package ar.fiuba.tdd.tp.nikoligames;

import ar.fiuba.tdd.tp.nikoligames.engine.model.game.Game;
import ar.fiuba.tdd.tp.nikoligames.games.sudoku.SudokuFactory;
import ar.fiuba.tdd.tp.nikoligames.view.parentview.factory.FactoryGameView;
import ar.fiuba.tdd.tp.nikoligames.view.parentview.GameView;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {
    private static final String SUDOKU_CONFIG_PATH = "./src/test/config/sudoku/easy.json";
    private static final String KAKURO_CONFIG_PATH = "./src/test/config/kakuro/easy.json";

    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader(SUDOKU_CONFIG_PATH);
            SudokuFactory factory = new SudokuFactory();


            Game game = factory.crateGame(fileReader);
            FactoryGameView factoryView = new FactoryGameView();
            GameView view = factoryView.createDefaultGameView(game.getDrawableBoard());

            view.setVisible(true);

            System.out.println("nikoli games :D");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
