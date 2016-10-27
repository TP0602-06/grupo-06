package ar.fiuba.tdd.tp.nikoligames.view.viewcontroller.edgecontroller;

import ar.fiuba.tdd.tp.nikoligames.model.board.EdgeAlreadyExistsExpection;
import ar.fiuba.tdd.tp.nikoligames.model.board.EdgeNotExistsExpection;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.EdgePosition;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.Position;
import ar.fiuba.tdd.tp.nikoligames.model.game.Game;
import ar.fiuba.tdd.tp.nikoligames.model.play.implemented.DrawableEdgeOperationPlay;
import ar.fiuba.tdd.tp.nikoligames.model.play.implemented.DrawablePlay;
import ar.fiuba.tdd.tp.nikoligames.view.board.BoardView;
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
            try {
                game.createUndirectedEdge(firstPositon, secondPositon);
            } catch (EdgeAlreadyExistsExpection edgeAlreadyExistsExpection) {
                edgeAlreadyExistsExpection.printStackTrace();
            }
        } else {
            try {
                game.removeUndirectedEdge(firstPositon, secondPositon);
            } catch (EdgeNotExistsExpection edgeNotExistsExpection) {
                edgeNotExistsExpection.printStackTrace();
            }
        }

    }

}
