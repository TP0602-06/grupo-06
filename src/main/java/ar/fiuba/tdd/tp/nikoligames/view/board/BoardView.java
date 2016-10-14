package ar.fiuba.tdd.tp.nikoligames.view.board;

import ar.fiuba.tdd.tp.nikoligames.view.grids.GridView;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;

/**
 * Created by tobias on 14/10/16.
 */
public class BoardView extends JLayeredPane{

    private int backLayer = 1;
    private int frontLayer = 2;
    private GridView cellgrid;

    public void addGrid(GridView gridLayer){
        add(gridLayer);
        setLayer(gridLayer, backLayer);
        cellgrid = gridLayer;
    }

    /*public void addDrawbleEdges(List<DrawableEdge> edges){

    }*/


}
