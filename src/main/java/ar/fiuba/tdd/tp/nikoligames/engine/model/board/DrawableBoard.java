package ar.fiuba.tdd.tp.nikoligames.engine.model.board;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.DrawableNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.position.Position;

import java.util.List;

/**
 * Da una interfaz para el exterior del modelo evitando que sea modificado por ese medio.
 */
public interface DrawableBoard {
    DrawableNode getDrawableNode(Position position);

    int getCols();

    int getRows();
}
