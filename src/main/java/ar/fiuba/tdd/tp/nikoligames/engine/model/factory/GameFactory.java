package ar.fiuba.tdd.tp.nikoligames.engine.model.factory;

import ar.fiuba.tdd.tp.nikoligames.engine.model.game.Game;
import ar.fiuba.tdd.tp.nikoligames.games.kakuro.KakuroFactory;
import ar.fiuba.tdd.tp.nikoligames.games.sudoku.SudokuFactory;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Responsabilidades:
 * 1. Seleccionar la referencia a la factory necesaria para crear el juego
 * 1. Crear el juego a partir de la la factory
 * Patrón de diseno: Strategy - Abstract Factory
 */
public class GameFactory {

    private Map<String, GameSetting> gamesSettings;

    public GameFactory() {
        this.gamesSettings = new HashMap<>();
        this.gamesSettings.put("sudoku", new GameSetting(new SudokuFactory(), "./config/games/sudoku"));
        this.gamesSettings.put("kakuro", new GameSetting(new KakuroFactory(), "./config/games/kakuro"));
    }

    public Game createGame(String gameType, String difficulty) throws Exception {
        GameSetting gameSetting = this.selectGameSetting(gameType);
        return gameSetting.getGame(difficulty);
    }

    private GameSetting selectGameSetting(String gameType) throws Exception {
        if (this.gamesSettings.containsKey(gameType)) {
            return this.gamesSettings.get(gameType);
        } else {
            throw new Exception("Not a valid type of game");
        }
    }

    static class GameSetting {
        private AbstractGameFactory gameFactory;
        private String configPath;

        public GameSetting(AbstractGameFactory gameFactory, String configPath) {
            this.gameFactory = gameFactory;
            this.configPath = configPath;
        }

        public Game getGame(String difficulty) throws Exception {
            Reader fileReader = new InputStreamReader(new FileInputStream(this.configPath + "/" + difficulty + ".json"), "UTF-8");
            return this.gameFactory.crateGame(fileReader);
        }
    }
}
