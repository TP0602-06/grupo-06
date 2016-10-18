package ar.fiuba.tdd.tp.nikoligames.view.viewcontroller;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.position.EdgePosition;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.position.Position;
import ar.fiuba.tdd.tp.nikoligames.engine.model.game.Game;
import ar.fiuba.tdd.tp.nikoligames.view.clickables.edge.ViewEdge;

/**
 * Es el controlador que se ocupa de crear aristas.
 */
public class SelectNotDiagonalEdgeController implements SelectEdgeController {
    private Game game;

    public SelectNotDiagonalEdgeController(Game game) {
        this.game = game;
    }

    public void notifySelectedEdge(ViewEdge edge) {
        EdgePosition edgePositions = edge.getEdgePositions();
        Position firstPositon = edgePositions.getPosition1();
        Position secondPositon = edgePositions.getPosition2();

        edge.clicked();

        if (edge.isSelected()) {
            game.createUndirectedEdge(firstPositon, secondPositon);
        } else {
            game.removeUndirectedEdge(firstPositon, secondPositon);
        }

    }
}
