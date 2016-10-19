package ar.fiuba.tdd.tp.nikoligames.view.regionpainter;

import ar.fiuba.tdd.tp.nikoligames.model.board.position.ClassicPosition;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.Position;
import ar.fiuba.tdd.tp.nikoligames.view.board.EdgePositionHelper;
import ar.fiuba.tdd.tp.nikoligames.view.clickables.cells.CellView;
import ar.fiuba.tdd.tp.nikoligames.view.regionpainter.bordersavers.*;

import java.util.*;
import java.util.List;

/**
 * Created by tobias on 19/10/16.
 */
public class Region {
    private List<Position> region;
    private List<Position> topPosition;
    private List<Position> bottomPositions;
    private List<Position> leftPositions;
    private List<Position> rightPositions;

    public Region(List<Position> regionPositions) {
        region = regionPositions;
        processPositions();
    }

    private void processPositions() {
        BorderSaver rowAndMaxColum = new RowAndColumMax();
        BorderSaver rowAndMinColum = new RowAndColumMin();
        BorderSaver columnAndMaxRow = new ColumnAndRowMax();
        BorderSaver columnAndMinRow = new ColumnAndRowMin();
        Iterator<Position> positions = region.iterator();
        while (positions.hasNext()) {
            Position pos = positions.next();
            Integer row = pos.getRow();
            Integer colum = pos.getColumn();
            rowAndMaxColum.update(row,colum);
            rowAndMinColum.update(row,colum);
            columnAndMaxRow.update(row,colum);
            columnAndMinRow.update(row,colum);
        }
        rightPositions = rowAndMaxColum.getPositions();
        leftPositions = rowAndMinColum.getPositions();
        bottomPositions = columnAndMaxRow.getPositions();
        topPosition = columnAndMinRow.getPositions();
    }

    public void add(Position position) {
        region.add(position);
    }

    public List<CellView> getTopCells(List<CellView> cellViews) throws Exception {
        return getCellViewsFrom(topPosition,cellViews);
    }

    public List<CellView> getBottomCells(List<CellView> cellViews) throws Exception {
        return getCellViewsFrom(bottomPositions,cellViews);
    }

    public List<CellView> getLeftCells(List<CellView> cellViews) throws Exception {
        return getCellViewsFrom(leftPositions,cellViews);
    }

    public List<CellView> getRightCells(List<CellView> cellViews) throws Exception {
        return getCellViewsFrom(rightPositions,cellViews);
    }

    private List<CellView> getCellViewsFrom(List<Position> positions, List<CellView> cellViews) throws Exception {
        List<CellView> cellViewsToReturn = new ArrayList<>();
        Iterator<Position> iterator = positions.iterator();
        while (iterator.hasNext()) {
            Position pos = iterator.next();
            cellViewsToReturn.add(getCellView(pos,cellViews));
        }
        return cellViewsToReturn;
    }

    private CellView getCellView(Position position, List<CellView> cellViews ) throws Exception {
        Iterator<CellView> cellViewIterator = cellViews.iterator();
        while (cellViewIterator.hasNext()) {
            CellView cell = cellViewIterator.next();
            Position cellPosition = new ClassicPosition(cell.getXIndex(),cell.getYIndex());
            if (EdgePositionHelper.samePosition(cellPosition,position)) {
                return cell;
            }
        }
        throw new Exception("Looking for not existant position in region");
    }
}
