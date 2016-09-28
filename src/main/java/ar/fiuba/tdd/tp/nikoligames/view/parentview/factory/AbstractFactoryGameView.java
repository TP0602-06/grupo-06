package ar.fiuba.tdd.tp.nikoligames.view.parentview.factory;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.DrawableBoard;
import ar.fiuba.tdd.tp.nikoligames.view.parentview.GameView;

/**
 * Created by german on 9/25/2016.
 */
public interface AbstractFactoryGameView {
    GameView createDefaultGameView(DrawableBoard modelBoard);
}
