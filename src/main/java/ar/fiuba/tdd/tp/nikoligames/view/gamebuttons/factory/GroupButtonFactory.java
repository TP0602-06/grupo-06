package ar.fiuba.tdd.tp.nikoligames.view.gamebuttons.factory;

import ar.fiuba.tdd.tp.nikoligames.engine.model.game.Game;

import java.awt.*;

/**
 * Esta clase se encarga de armar el set de botones para el juego.
 */
public interface GroupButtonFactory {

    Component makeGroupButton(Game game);
}
