package ar.fiuba.tdd.tp.nikoligames.view.parentview.factory;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.DrawableBoard;
import ar.fiuba.tdd.tp.nikoligames.engine.model.game.Game;
import ar.fiuba.tdd.tp.nikoligames.view.parentview.GameView;

/**
 * Created by german on 9/25/2016.
 */
public interface AbstractFactoryGameView {
    GameView createDefaultGameView(Game game);
}
