package ar.fiuba.tdd.tp.nikoligames.view.gamebuttons.factory;

import ar.fiuba.tdd.tp.nikoligames.engine.model.game.Game;

import java.awt.*;
/**
 * Responsabilidades:
 * 1. Crea una abstracción para encapsular la creación de un conjunto de botones para controlar el juego
 * Patrón:
 *  1. Abstract Factory
 */
public interface GroupButtonFactory {

    Component makeGroupButton(Game game);
}
