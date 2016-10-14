package ar.fiuba.tdd.tp.nikoligames.view.viewcontroller;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.edge.EdgePosition;
import ar.fiuba.tdd.tp.nikoligames.engine.model.game.Game;
import ar.fiuba.tdd.tp.nikoligames.engine.model.position.Position;
import ar.fiuba.tdd.tp.nikoligames.view.cells.numbercell.AbstractEditableNumberCell;
import ar.fiuba.tdd.tp.nikoligames.view.edge.DrawableEdge;
import ar.fiuba.tdd.tp.nikoligames.view.grids.GridView;

import java.awt.*;

/**
 * Es el controlador que se ocupa de crear aristas.
 */
public class SelectEdgeController{
    private Game game;

    public SelectEdgeController(Game game){
        game = game;
    }

    public void notifySelectedComponent(Component component) {
        DrawableEdge edge = (DrawableEdge) component;
        EdgePosition edgePositions = edge.getEdgePositions();
        Position firstPositon = edgePositions.getPosition1();
        Position secondPositon = edgePositions.getPosition2();
        if (edge.isSelected()){
            //ERASE EDGE IN GAME
            edge.deselect();
        }else{
            game.createEdge(firstPositon,secondPositon);
            edge.select();
        }
    }
}
