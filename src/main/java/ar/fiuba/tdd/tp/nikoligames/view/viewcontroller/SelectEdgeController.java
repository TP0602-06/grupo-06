package ar.fiuba.tdd.tp.nikoligames.view.viewcontroller;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.edge.AbstractEdge;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.position.EdgePosition;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.position.Position;
import ar.fiuba.tdd.tp.nikoligames.engine.model.game.Game;
import ar.fiuba.tdd.tp.nikoligames.view.edge.DrawableEdge;

/**
 * Es el controlador que se ocupa de crear aristas.
 */
public class SelectEdgeController {
    private Game game;

    public SelectEdgeController(Game game) {
        this.game = game;
    }

    public void notifySelectedEdge(DrawableEdge edge) {
        EdgePosition edgePositions = edge.getEdgePositions();
        Position firstPositon = edgePositions.getPosition1();
        Position secondPositon = edgePositions.getPosition2();

        if (edge.isSelected()) {
            game.removeUndirectedEdge(firstPositon, secondPositon);
            edge.deselect();
        } else {
            game.removeUndirectedEdge(firstPositon, secondPositon);
            edge.select();
        }
    }
}
