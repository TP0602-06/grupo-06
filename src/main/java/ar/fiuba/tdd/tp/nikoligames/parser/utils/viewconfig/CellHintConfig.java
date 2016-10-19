package ar.fiuba.tdd.tp.nikoligames.parser.utils.viewconfig;

import ar.fiuba.tdd.tp.nikoligames.model.board.position.ClassicPosition;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.Position;
import ar.fiuba.tdd.tp.nikoligames.view.cells.CellHint;
import ar.fiuba.tdd.tp.nikoligames.view.cells.CellHintEnum;
import ar.fiuba.tdd.tp.nikoligames.view.cells.NotValidCellHintException;

/**
 * Created by tobias on 18/10/16.
 */
public class CellHintConfig {
    private CellHint cellhint;
    private Position position;

    public CellHintConfig(String cellHintName, String value, Integer row, Integer column) throws NotValidCellHintException {
        cellhint = CellHintEnum.getCellHint(cellHintName).createCell(value);
        position = new ClassicPosition(row, column);
    }

    public Position getPosition() {
        return position;
    }

    public CellHint getCellHint() {
        return cellhint;
    }
}
