package ar.fiuba.tdd.tp.nikoligames.engine.model.board;

import ar.fiuba.tdd.tp.nikoligames.engine.model.position.Position;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.cell.DrawableCell;

/**
 * Da una interfaz para el exterior del modelo evitando que sea modificado por ese medio.
 */
public interface DrawableBoard {
    DrawableCell getDrawableCell(Position position);

    int getCols();

    int getRows();
}
