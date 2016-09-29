package ar.fiuba.tdd.tp.nikoligames;

import ar.fiuba.tdd.tp.nikoligames.engine.model.factory.GameFactory;
import ar.fiuba.tdd.tp.nikoligames.engine.model.game.Game;
import ar.fiuba.tdd.tp.nikoligames.games.kakuro.KakuroFactory;
import ar.fiuba.tdd.tp.nikoligames.games.sudoku.SudokuFactory;
import ar.fiuba.tdd.tp.nikoligames.view.parentview.GameView;
import ar.fiuba.tdd.tp.nikoligames.view.parentview.factory.FactoryGameView;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private Map<String, GameFactory> gamesFactories;

    public static void main(String[] args) {
        Main main = new Main();

        try {
            Game game = main.getGame(args);
            FactoryGameView factoryView = new FactoryGameView();
            GameView view = factoryView.createDefaultGameView(game);

            view.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Main() {
        this.gamesFactories = new HashMap<>();
        this.gamesFactories.put("sudoku", new SudokuFactory());
        this.gamesFactories.put("kakuro", new KakuroFactory());
    }

    private Game getGame(String[] args) throws Exception {
        for (int index = 0; index < args.length; index++) {
            GameFactory gameFactory = this.gamesFactories.get(args[index]);
            if (gameFactory != null) {
                return this.createGame(gameFactory, args[index + 1]);
            }
        }
        throw new Exception("The game does not exist");
    }

    private Game createGame(GameFactory gameFactory, String configFile) throws FileNotFoundException, UnsupportedEncodingException {
        Reader fileReader = new InputStreamReader(new FileInputStream(configFile), "UTF-8");
        return gameFactory.crateGame(fileReader);
    }
}