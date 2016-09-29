package ar.fiuba.tdd.tp.nikoligames.view.parentview.factory;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.DrawableBoard;
import ar.fiuba.tdd.tp.nikoligames.engine.model.game.Game;
import ar.fiuba.tdd.tp.nikoligames.view.parentview.GameView;

/**
 * Es la factory para generar la vista del juego.
 */
public interface AbstractFactoryGameView {
    GameView createDefaultGameView(Game game);
}
