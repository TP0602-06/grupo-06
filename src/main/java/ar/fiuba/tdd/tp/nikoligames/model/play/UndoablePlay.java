package ar.fiuba.tdd.tp.nikoligames.model.play;

import ar.fiuba.tdd.tp.nikoligames.model.play.implemented.DrawablePlay;

/**
 * Created by german on 10/27/2016.
 */
public interface UndoablePlay {
    void undo();

    DrawablePlay getDrawableUndoPlay();
}
