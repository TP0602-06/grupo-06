package ar.fiuba.tdd.tp.nikoligames;

import ar.fiuba.tdd.tp.nikoligames.engine.model.factory.GameFactory;
import ar.fiuba.tdd.tp.nikoligames.engine.model.game.Game;
import ar.fiuba.tdd.tp.nikoligames.games.kakuro.KakuroFactory;
import ar.fiuba.tdd.tp.nikoligames.view.parentview.GameView;
import ar.fiuba.tdd.tp.nikoligames.view.parentview.factory.FactoryGameView;

import java.io.*;

public class Main {
    private static final String SUDOKU_CONFIG_PATH = "./src/test/config/sudoku/easy2.json";
    private static final String KAKURO_CONFIG_PATH = "./src/test/config/kakuro/easy2.json";

    public static void main(String[] args) {
        InputStreamReader fileReader = null;
        try {
            fileReader = new InputStreamReader(new FileInputStream(KAKURO_CONFIG_PATH), "UTF-8");
            //GameFactory factory = new SudokuFactory();
            GameFactory factory = new KakuroFactory();

            Game game = factory.crateGame(fileReader);

            FactoryGameView factoryView = new FactoryGameView();
            GameView view = factoryView.createDefaultGameView(game);

            view.setVisible(true);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        System.out.println("nikoli games :D");
    }
}
