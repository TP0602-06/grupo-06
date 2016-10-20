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
    private List<Position> topPositions;
    private List<Position> bottomPositions;
    private List<Position> leftPositions;
    private List<Position> rightPositions;

    public Region(List<Position> regionPositions) {
        region = regionPositions;
        topPositions = new ArrayList<>();
        bottomPositions = new ArrayList<>();
        leftPositions = new ArrayList<>();
        rightPositions = new ArrayList<>();
        processPositions();
    }

    public void add(Position position) {
        region.add(position);
    }

    public List<CellView> getTopCells(List<CellView> cellViews) throws Exception {
        return getCellViewsFrom(topPositions, cellViews);
    }

    public List<CellView> getBottomCells(List<CellView> cellViews) throws Exception {
        return getCellViewsFrom(bottomPositions, cellViews);
    }

    public List<CellView> getLeftCells(List<CellView> cellViews) throws Exception {
        return getCellViewsFrom(leftPositions, cellViews);
    }

    public List<CellView> getRightCells(List<CellView> cellViews) throws Exception {
        return getCellViewsFrom(rightPositions, cellViews);
    }

    private void processPositions() {
        Iterator<Position> positions = region.iterator();
        while (positions.hasNext()) {
            Position pos = positions.next();
            addToTop(pos);
            addToBottom(pos);
            addToLeft(pos);
            addToRight(pos);
        }
    }

    private void addToRight(Position pos) {
        addPositionTo(pos, rightPositions, 0, 1);
    }

    private void addToLeft(Position pos) {
        addPositionTo(pos, leftPositions, 0, -1);
    }

    private void addToBottom(Position pos) {
        addPositionTo(pos, bottomPositions, 1, 0);
    }

    private void addToTop(Position pos) {
        addPositionTo(pos, topPositions, -1, 0);
    }

    private void addPositionTo(Position pos, List<Position> positions, Integer distanceX, Integer distanceY) {
        Position topPosition = getCellAtDistance(distanceX, distanceY, pos);
        if (notInRegion(topPosition)) {
            positions.add(pos);
        }
    }

    private boolean notInRegion(Position topPosition) {
        Iterator<Position> iterator = region.iterator();
        while (iterator.hasNext()) {
            Position actualPosition = iterator.next();
            if ( EdgePositionHelper.samePosition(topPosition,actualPosition) ) {
                return false;
            }
        }
        return true;
    }

    private Position getCellAtDistance(Integer distanceX, Integer distanceY, Position original) {
        Integer newX = original.getRow() + distanceX;
        Integer newY = original.getColumn() + distanceY;
        return new ClassicPosition(newX, newY);
    }

    private List<CellView> getCellViewsFrom(List<Position> positions, List<CellView> cellViews) throws Exception {
        List<CellView> cellViewsToReturn = new ArrayList<>();
        Iterator<Position> iterator = positions.iterator();
        while (iterator.hasNext()) {
            Position pos = iterator.next();
            cellViewsToReturn.add(getCellView(pos, cellViews));
        }
        return cellViewsToReturn;
    }

    private CellView getCellView(Position position, List<CellView> cellViews) throws Exception {
        Iterator<CellView> cellViewIterator = cellViews.iterator();
        while (cellViewIterator.hasNext()) {
            CellView cell = cellViewIterator.next();
            Position cellPosition = new ClassicPosition(cell.getXIndex(), cell.getYIndex());
            if (EdgePositionHelper.samePosition(cellPosition, position)) {
                return cell;
            }
        }
        throw new Exception("Looking for not existant position in region");
    }
}
