package ar.fiuba.tdd.tp.nikoligames.view.board;

import ar.fiuba.tdd.tp.nikoligames.view.edge.DrawableEdge;
import ar.fiuba.tdd.tp.nikoligames.view.grids.GridView;

import java.awt.*;
import java.util.Iterator;
import java.util.List;
import javax.swing.*;


/**
 * Created by tobias on 14/10/16.
 */
public class BoardView extends JPanel {

    private int backLayer = 1;
    private int frontLayer = 2;
    private GridView cellgrid;
    private JLayeredPane pane;

    public BoardView(Dimension size, GridView gridLayer) {
        super();
        pane = new JLayeredPane();
        pane.setPreferredSize(size);
        add(pane);
        addGrid(gridLayer, size);
    }

    private void addGrid(GridView gridLayer, Dimension size) {
        cellgrid = gridLayer;
        addInLayer(gridLayer, backLayer);
        gridLayer.setBounds(0, 0, size.width, size.height);
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
        DrawableEdgePositionSolver edgeSolver = new DrawableEdgePositionSolver(cellgrid);
        Rectangle edgeBounds = edgeSolver.getRectangleFor(edge.getEdgePositions());
        edge.setBounds(edgeBounds);
    }

}
