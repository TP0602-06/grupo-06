package ar.fiuba.tdd.tp.nikoligames.view.board;


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

    private static Integer compare(Position position1, Position position2) {
        if (position1.getRow() < position2.getRow()
                || (position1.getRow() == position2.getRow()
                && position1.getColumn() < position2.getColumn())) {
            return 1;
        }
        if (position1.getRow() == position2.getRow()
                && position1.getColumn() == position2.getColumn()) {
            return 0;
        }
        return -1;
    }
}
