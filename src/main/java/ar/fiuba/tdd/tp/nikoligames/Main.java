package ar.fiuba.tdd.tp.nikoligames;

import ar.fiuba.tdd.tp.nikoligames.engine.model.factory.GameFactory;
import ar.fiuba.tdd.tp.nikoligames.engine.model.game.Game;
import ar.fiuba.tdd.tp.nikoligames.games.kakuro.KakuroFactory;
import ar.fiuba.tdd.tp.nikoligames.games.sudoku.SudokuFactory;
import ar.fiuba.tdd.tp.nikoligames.view.parentview.factory.FactoryGameView;
import ar.fiuba.tdd.tp.nikoligames.view.parentview.GameView;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {
    private static final String SUDOKU_CONFIG_PATH = "./src/test/config/sudoku/easy2.json";
    private static final String KAKURO_CONFIG_PATH = "./src/test/config/kakuro/easy2.json";

    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader(KAKURO_CONFIG_PATH);
            //GameFactory factory = new SudokuFactory();
            GameFactory factory = new KakuroFactory();

            Game game = factory.crateGame(fileReader);
            FactoryGameView factoryView = new FactoryGameView();
            GameView view = factoryView.createDefaultGameView(game);

            view.setVisible(true);

            System.out.println("nikoli games :D");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
