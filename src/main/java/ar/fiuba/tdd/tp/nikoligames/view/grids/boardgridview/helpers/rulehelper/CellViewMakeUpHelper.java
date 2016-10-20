package ar.fiuba.tdd.tp.nikoligames.view.grids.boardgridview.helpers.rulehelper;

import ar.fiuba.tdd.tp.nikoligames.model.board.node.DrawableNode;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.ClassicPosition;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.Position;
import ar.fiuba.tdd.tp.nikoligames.parser.utils.viewconfig.PaintableHintConfig;
import ar.fiuba.tdd.tp.nikoligames.view.board.EdgePositionHelper;
import ar.fiuba.tdd.tp.nikoligames.view.clickables.cells.CellView;
import ar.fiuba.tdd.tp.nikoligames.view.hints.HintPainter;
import ar.fiuba.tdd.tp.nikoligames.view.hints.HintPainterBasic;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Esta clase se encarga de pintar la celda de acuerdo a las reglas existentes.
 */
public class CellViewMakeUpHelper {
    private List<PaintableHintConfig> cellHintConfigs;

    public CellViewMakeUpHelper(List<PaintableHintConfig> paintableHintConfigs) {
        this.cellHintConfigs = paintableHintConfigs;
    }

    public void beautyfy(CellView cellView, DrawableNode baseCell) {
        List<HintPainter> hints = getCellHint(cellView, baseCell);
        Iterator<HintPainter> hintsIterator = hints.iterator();
        while (hintsIterator.hasNext()) {
            hintsIterator.next().draw(cellView);
        }
    }

    private List<HintPainter> getCellHint(CellView cellView, DrawableNode baseCell) {
        List<HintPainter> hintPainters = new ArrayList<>();
        Iterator listIterator = cellHintConfigs.iterator();
        Position cellPosition = new ClassicPosition(cellView.getXIndex(), cellView.getYIndex());
        while (listIterator.hasNext()) {
            PaintableHintConfig hintConfig = (PaintableHintConfig) listIterator.next();
            Position configPosition = hintConfig.getPosition();
            if (EdgePositionHelper.compare(configPosition, cellPosition) == 0) {
                hintPainters.add(hintConfig.getCellHint());
            }
        }
        if (hintPainters.isEmpty()) {
            hintPainters.add(new HintPainterBasic(baseCell));
        }
        return hintPainters;
    }
}
