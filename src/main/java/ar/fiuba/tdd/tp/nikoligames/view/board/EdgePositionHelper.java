package ar.fiuba.tdd.tp.nikoligames.view.board;


import ar.fiuba.tdd.tp.nikoligames.engine.model.board.position.ClassicPosition;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.position.EdgePosition;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.position.Position;

/**
 * Created by tobias on 16/10/16.
 */
public class EdgePositionHelper {

    public static Position mostBottomRightPosition(EdgePosition edgePosition) {
        return getComparedPosition(edgePosition, true);
    }

    public static Position mostTopLeftPosition(EdgePosition edgePosition) {
        return getComparedPosition(edgePosition, false);
    }

    public static boolean isDiagonal(EdgePosition edgePosition){
        Position pos1 = edgePosition.getPosition1();
        Position pos2 = edgePosition.getPosition2();
        return differentRowAndColum(pos1, pos2);
    }

    public static boolean areDiagonalsOfSameCell(EdgePosition edgePosition1,EdgePosition edgePosition2) {
        Position topLeft = mostTopLeftPosition(edgePosition1);
        Position bottomRight = mostBottomRightPosition(edgePosition1);
        Position invertedTop = new ClassicPosition(topLeft.getRow(), bottomRight.getColumn());
        Position invertedBottom = new ClassicPosition(bottomRight.getRow(),topLeft.getColumn());
        Integer equalsTop =  compare(invertedTop,mostTopLeftPosition(edgePosition2));
        Integer equalsBottom =  compare(invertedBottom,mostBottomRightPosition(edgePosition2));
        return equalsTop == 0 && equalsBottom == 0;
    }
    private static boolean differentRowAndColum(Position pos1, Position pos2) {
        return pos1.getColumn() != pos2.getColumn()
                && pos1.getRow() != pos2.getRow();
    }

    private static Position getComparedPosition(EdgePosition edgePosition, boolean bottomRightCel) {
        Position pos1 = edgePosition.getPosition1();
        Position pos2 = edgePosition.getPosition2();
        Position toReturnIfPos1Greater = pos1;
        Position toReturnIfPos2Greater = pos2;
        if (bottomRightCel) {
            toReturnIfPos1Greater = pos2;
            toReturnIfPos2Greater = pos1;
        }
        return compare(pos1, pos2) >= 0 ? toReturnIfPos1Greater : toReturnIfPos2Greater;
    }

    public static Integer compare(Position position1, Position position2) {
        if (rowIsLower(position1, position2)
                || sameRowButColumLower(position1, position2)) {
            return 1;
        }
        if (samePosition(position1, position2)) {
            return 0;
        }
        return -1;
    }

    private static boolean samePosition(Position position1, Position position2) {
        return position1.getRow() == position2.getRow()
                && position1.getColumn() == position2.getColumn();
    }

    private static boolean sameRowButColumLower(Position position1, Position position2) {
        return position1.getRow() == position2.getRow()
        && position1.getColumn() < position2.getColumn();
    }

    private static boolean rowIsLower(Position position1, Position position2) {
        return position1.getRow() < position2.getRow();
    }
}
