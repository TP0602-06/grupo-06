package ar.fiuba.tdd.tp.nikoligames.view.grids.boardgridview.helpers.rulehelper;

import ar.fiuba.tdd.tp.nikoligames.model.board.node.DrawableNode;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.ClassicPosition;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.Position;
import ar.fiuba.tdd.tp.nikoligames.parser.utils.viewconfig.CellHintConfig;
import ar.fiuba.tdd.tp.nikoligames.view.board.EdgePositionHelper;
import ar.fiuba.tdd.tp.nikoligames.view.cells.CellHint;
import ar.fiuba.tdd.tp.nikoligames.view.cells.CellHintBasic;
import ar.fiuba.tdd.tp.nikoligames.view.clickables.cells.CellView;

import java.util.Iterator;
import java.util.List;

/**
 * Esta clase se encarga de pintar la celda de acuerdo a las reglas existentes.
 */
public class CellViewMakeUpHelper {
    private List<CellHintConfig> cellHintConfigs;

    public CellViewMakeUpHelper(List<CellHintConfig> cellHintConfigs) {
        this.cellHintConfigs = cellHintConfigs;
    }

    public void beautyfy(CellView cellView, DrawableNode baseCell) {
        CellHint hint = getCellHint(cellView, baseCell);
        hint.draw(cellView);
    }

    private CellHint getCellHint(CellView cellView, DrawableNode baseCell) {
        Iterator listIterator = cellHintConfigs.iterator();
        Position cellPosition = new ClassicPosition(cellView.getXIndex(), cellView.getYIndex());
        while (listIterator.hasNext()) {
            CellHintConfig hintConfig = (CellHintConfig) listIterator.next();
            Position configPosition = hintConfig.getPosition();
            if (EdgePositionHelper.compare(configPosition, cellPosition) == 0) {
                return hintConfig.getCellHint();
            }
        }
        return new CellHintBasic(baseCell);
    }
}
