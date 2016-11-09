package ar.fiuba.tdd.tp.nikoligames.model.play.implemented;

import ar.fiuba.tdd.tp.nikoligames.model.board.position.EdgePosition;

/**
 * Created by german on 10/27/2016.
 */
public class DrawableEdgeOperationPlay extends DrawablePlay {
    public enum EdgeOperation {
        CREATE_UNDIRECTED, CREATE_DIRECTED, REMOVE_UNDIRECTED, REMOVE_DIRECTED;
    }

    private final EdgePosition edgePosition;
    private final EdgeOperation edgeOperation;

    public DrawableEdgeOperationPlay(EdgePosition edgePosition, EdgeOperation edgeOperation) {
        this.edgePosition = edgePosition;
        this.edgeOperation = edgeOperation;
    }

    public EdgePosition getEdgePosition() {
        return edgePosition;
    }

    public EdgeOperation getEdgeOperation() {
        return edgeOperation;
    }


}
