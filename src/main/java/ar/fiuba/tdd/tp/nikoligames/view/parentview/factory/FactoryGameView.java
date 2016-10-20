package ar.fiuba.tdd.tp.nikoligames.view.parentview.factory;

import ar.fiuba.tdd.tp.nikoligames.model.game.Game;
import ar.fiuba.tdd.tp.nikoligames.parser.utils.GameConfig;
import ar.fiuba.tdd.tp.nikoligames.view.parentview.GameView;

import java.util.Set;

/**
 * Responsabilidades:
 * 1. Encapsular la creación del componente GameView
 * Patrón:
 * 1. Abstract Factory
 */
public interface FactoryGameView {
    GameView createDefaultGameView(Game game, GameConfig gameConfig) throws Exception;
}
