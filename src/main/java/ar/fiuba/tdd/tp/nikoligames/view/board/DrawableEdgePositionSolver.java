package ar.fiuba.tdd.tp.nikoligames.view.board;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.edge.EdgePosition;
import ar.fiuba.tdd.tp.nikoligames.engine.model.position.MatrixPosition;
import ar.fiuba.tdd.tp.nikoligames.engine.model.position.Position;
import ar.fiuba.tdd.tp.nikoligames.view.grids.GridView;

import java.awt.*;
import java.awt.peer.SystemTrayPeer;

/**
 * Created by tobias on 15/10/16.
 */
public class DrawableEdgePositionSolver {
    private GridView grid;
    private double edgeProportion = 0.1;

    public DrawableEdgePositionSolver(GridView grid) {
        this.grid = grid;
    }

    public Rectangle getRectangleFor(EdgePosition edgePosition) {
        Position mostTopLeftPosition = EdgePositionHelper.mostTopLeftPosition(edgePosition);
        Position mostBottomRightPosition = EdgePositionHelper.mostBottomRightPosition(edgePosition);

        Position start = getViewCoordinates(mostTopLeftPosition);
        Position end = getViewCoordinates(mostBottomRightPosition);

        return makeEdgeRectangle(start,end);
    }

    private Rectangle makeEdgeRectangle(Position start, Position end) {
        //supose all vertical or horizontal
        boolean horizontal = start.getColumn() == end.getColumn();
        System.out.println("start " + start.getColumn() + "," +start.getRow());
        System.out.println("end " + end.getColumn() + "," +end.getRow());
        int width = getNodeWidth(horizontal);
        int height = getNodeHeight(horizontal);

        int modifierX =0;
        int modifierY = 0;

        if (horizontal) {
            modifierY = (int)Math.floor(-(double)height/2);
        } else {
            modifierX = (int)Math.floor(-(double)width/2);
        }

        int positionX = start.getRow() + modifierX;
        int positionY = start.getColumn() + modifierY;

        return new Rectangle(positionX,positionY,width,height);
    }

    private int getNodeHeight(boolean horizontal) {
        if (horizontal) {
            return (int) Math.floor(getGridCellHeight()*edgeProportion);
        }
        return getGridCellHeight();

    }

    private int getNodeWidth(boolean horizontal) {
        if (horizontal) {
            return getGridCellWidth();
        }
        return (int) Math.floor(getGridCellWidth()*edgeProportion);
    }

    private Position getViewCoordinates(Position position) {
        Integer cellWidth = getGridCellWidth();
        Integer celHeight = getGridCellHeight();

        int coordinateX = getCoordinateOf(cellWidth, position.getColumn());
        int coordinateY = getCoordinateOf(celHeight, position.getRow());

        return new MatrixPosition(coordinateX,coordinateY);
    }

    private int getGridCellWidth() {
        Rectangle gridSize = grid.getBounds();
        return (int) Math.floor(gridSize.width / grid.getCols());
    }

    private int getGridCellHeight() {
        Rectangle gridSize = grid.getBounds();
        return (int) Math.floor(gridSize.height / grid.getRows());
    }

    private int getCoordinateOf(Integer celSize, Integer position) {
        //with all existant
        return (int) (celSize * position + Math.floor(celSize / 2));
    }
}
