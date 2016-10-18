package ar.fiuba.tdd.tp.nikoligames.view.board;

import ar.fiuba.tdd.tp.nikoligames.model.board.position.EdgePosition;
import ar.fiuba.tdd.tp.nikoligames.model.game.Game;
import ar.fiuba.tdd.tp.nikoligames.view.clickables.edge.DrawableEdge;
import ar.fiuba.tdd.tp.nikoligames.view.clickables.edge.ViewDiagonalEdge;
import ar.fiuba.tdd.tp.nikoligames.view.clickables.edge.ViewEdge;
import ar.fiuba.tdd.tp.nikoligames.view.viewcontroller.SelectDiagonalEdge;
import ar.fiuba.tdd.tp.nikoligames.view.viewcontroller.SelectEdgeController;
import ar.fiuba.tdd.tp.nikoligames.view.viewcontroller.SelectNotDiagonalEdgeController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tobias on 18/10/16.
 */
public class ViewEdgeFactory {
    private SelectEdgeController diagonal;
    private SelectEdgeController common;
    private List<ViewDiagonalEdge> diagonalEdges;

    public ViewEdgeFactory(Game game) {
        this.diagonal = new SelectDiagonalEdge(game);
        this.common = new SelectNotDiagonalEdgeController(game);
        diagonalEdges = new ArrayList<>();
    }

    public ViewEdge createViewEdge(EdgePosition edge) {
        ViewEdge viewEdge;
        if (EdgePositionHelper.isDiagonal(edge)) {
            viewEdge = getNewOrExistantDiagonalEdge(edge);
        } else {
            viewEdge = new DrawableEdge(edge, common);
        }
        return viewEdge;
    }

    private ViewEdge getNewOrExistantDiagonalEdge(EdgePosition edge) {
        for (int i = 0; i < diagonalEdges.size(); i++) {
            ViewDiagonalEdge diagonalEdge = diagonalEdges.get(i);
            EdgePosition existentDiagonal = diagonalEdges.get(i).getEdgePositions();
            if (EdgePositionHelper.areDiagonalsOfSameCell(edge, existentDiagonal)) {
                diagonalEdge.addOtherEdge(edge);
                return diagonalEdge;
            }
        }
        ViewDiagonalEdge newEdge = new ViewDiagonalEdge(edge, diagonal);
        diagonalEdges.add(newEdge);
        return newEdge;
    }
}
