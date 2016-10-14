package ar.fiuba.tdd.tp.nikoligames.view.board;

import ar.fiuba.tdd.tp.nikoligames.view.ColorSet;
import ar.fiuba.tdd.tp.nikoligames.view.edge.DrawableEdge;
import ar.fiuba.tdd.tp.nikoligames.view.grids.GridView;

import java.awt.*;
import javax.swing.*;

import java.util.Iterator;
import java.util.List;

/**
 * Created by tobias on 14/10/16.
 */
public class BoardView extends JPanel {

    private int backLayer = 1;
    private int frontLayer = 2;
    private GridView cellgrid;
    private JLayeredPane pane;

    public BoardView(Dimension size) {
        super();
        pane = new JLayeredPane();
        pane.setPreferredSize(size);
        add(pane);
    }

    public void addGrid(GridView gridLayer) {
        cellgrid = gridLayer;
        addInLayer(gridLayer, backLayer);
        gridLayer.setBounds(0, 0, 300, 300);

    }

    public void addDrawbleEdges(List<DrawableEdge> edges) {
        Iterator listIterator = edges.iterator();
        while (listIterator.hasNext()) {
            DrawableEdge edge = (DrawableEdge) listIterator.next();
            addInLayer(edge, frontLayer);
            setBoundsOfEdge(edge);
        }
    }

    private void addInLayer(Component component, int layerIndex) {
        pane.add(component);
        pane.setLayer(component, layerIndex);
    }

    private void setBoundsOfEdge(DrawableEdge edge) {
        //TODO compare with grid and view where to set
        //Know width or height
    }

}
