package ar.fiuba.tdd.tp.nikoligames.engine.model.board;

import ar.fiuba.tdd.tp.nikoligames.engine.model.position.ClassicPosition;
import ar.fiuba.tdd.tp.nikoligames.engine.model.position.Position;
import ar.fiuba.tdd.tp.nikoligames.engine.parser.CellConfig;

import java.util.Iterator;
import java.util.List;

/**
 * Created by german on 10/1/2016.
 */
public class BoardFactory {
    public Board createBoard(int rows, int cols, List<CellConfig> initialCells) {
        Board board = new BoardImplementation(rows, cols);
        fillBoardWithInitialValues(initialCells, board);

        return board;
    }

    private void fillBoardWithInitialValues(List<CellConfig> initialCells, Board board) {
        Iterator<CellConfig> iterator = initialCells.iterator();
        if (iterator.hasNext()) {
            CellConfig cellConfig = iterator.next();
            Position coordinates = new ClassicPosition(cellConfig.getRow(), cellConfig.getCol());
            board.setCell(coordinates, cellConfig.getCell());
        }
    }
}
