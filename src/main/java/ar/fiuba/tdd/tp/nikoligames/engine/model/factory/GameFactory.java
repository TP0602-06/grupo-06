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

    private Map<String, AbstractGameFactory> gamesFactories;

    private AbstractGameFactory actualGameFactory;

    public GameFactory() {
        this.gamesFactories = new HashMap<>();
        this.gamesFactories.put("sudoku", new SudokuFactory());
        this.gamesFactories.put("kakuro", new KakuroFactory());
    }

    public Game createGame(String gameType, String gameConfigFileName) throws Exception {
        this.selectGameFactory(gameType);
        Reader fileReader = new InputStreamReader(new FileInputStream(gameConfigFileName), "UTF-8");
        return this.actualGameFactory.crateGame(fileReader);
    }

    private void selectGameFactory(String gameType) throws Exception {
        if (this.gamesFactories.containsKey(gameType)) {
            this.actualGameFactory = this.gamesFactories.get(gameType);
        } else {
            throw new Exception("Not a valid type of game");
        }
    }
}
