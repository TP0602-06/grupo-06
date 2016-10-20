package ar.fiuba.tdd.tp.nikoligames.parser.utils.viewconfig;

import ar.fiuba.tdd.tp.nikoligames.model.board.position.ClassicPosition;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.Position;
import ar.fiuba.tdd.tp.nikoligames.view.hints.HintPainter;
import ar.fiuba.tdd.tp.nikoligames.view.hints.HintPainterEnum;
import ar.fiuba.tdd.tp.nikoligames.view.hints.NotValidCellHintException;

/**
 * Created by tobias on 18/10/16.
 */
public class PaintableHintConfig {
    private HintPainter cellhint;
    private Position position;

    public PaintableHintConfig(String cellHintName, String value, Integer row, Integer column) throws NotValidCellHintException {
        cellhint = HintPainterEnum.getCellHint(cellHintName).createCell(value);
        position = new ClassicPosition(row, column);
    }

    public Position getPosition() {
        return position;
    }

    public HintPainter getCellHint() {
        return cellhint;
    }
}
