package ar.fiuba.tdd.tp.nikoligames.view.viewcontroller.edgecontroller;

import ar.fiuba.tdd.tp.nikoligames.model.board.EdgeAlreadyExistsExpection;
import ar.fiuba.tdd.tp.nikoligames.model.board.EdgeNotExistsExpection;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.EdgePosition;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.Position;
import ar.fiuba.tdd.tp.nikoligames.model.game.Game;
import ar.fiuba.tdd.tp.nikoligames.view.clickables.edge.ViewDiagonalEdge;
import ar.fiuba.tdd.tp.nikoligames.view.clickables.edge.ViewEdge;

/**
 * Created by tobias on 17/10/16.
 */
public class SelectDiagonalEdge implements SelectEdgeController {

    private Game game;

    public SelectDiagonalEdge(Game game) {
        this.game = game;
    }

    @Override
    public void notifySelectedEdge(ViewEdge edge) {
        ViewDiagonalEdge diagonalEdge = (ViewDiagonalEdge) edge;
        EdgePosition previousPosition = diagonalEdge.getDisplayedPosition();

        diagonalEdge.clicked();
        EdgePosition actualPosition = diagonalEdge.getDisplayedPosition();

        removeEdge(previousPosition);
        createEdge(actualPosition);
    }

    private void createEdge(EdgePosition actualPosition) {
        if (actualPosition != null) {
            Position firstPositon = actualPosition.getPosition1();
            Position secondPositon = actualPosition.getPosition2();
            try {
                game.createUndirectedEdge(firstPositon, secondPositon);
            } catch (EdgeAlreadyExistsExpection edgeAlreadyExistsExpection) {
                edgeAlreadyExistsExpection.printStackTrace();
            }
        }
    }

    private void removeEdge(EdgePosition previousPosition) {
        if (previousPosition != null) {
            Position firstPositon = previousPosition.getPosition1();
            Position secondPositon = previousPosition.getPosition2();
            try {
                game.removeUndirectedEdge(firstPositon, secondPositon);
            } catch (EdgeNotExistsExpection edgeNotExistsExpection) {
                edgeNotExistsExpection.printStackTrace();
            }
        }
    }
}
