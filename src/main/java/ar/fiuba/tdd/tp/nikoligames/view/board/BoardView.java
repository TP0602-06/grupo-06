package ar.fiuba.tdd.tp.nikoligames.view.board;


import ar.fiuba.tdd.tp.nikoligames.model.board.position.EdgePosition;
import ar.fiuba.tdd.tp.nikoligames.view.clickables.edge.ViewEdge;
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
    private JLayeredPane pane;
    private ViewEdgeFactory factoryEdges;
    private ViewEdgeCellViewPositionSolver solver;
    private int originX = 0;
    private int originY = 0;

    public BoardView(Dimension size, GridView gridLayer, ViewEdgeFactory factoryEdge, boolean nodeMatchesCell) {
        super();
        factoryEdges = factoryEdge;
        pane = new JLayeredPane();
        pane.setPreferredSize(size);
        add(pane);
        addGrid(gridLayer, size);
        solver = new ViewEdgeCellViewPositionSolver(gridLayer,nodeMatchesCell);
    }

    private void addGrid(GridView gridLayer, Dimension size) {
        addInLayer(gridLayer, backLayer);
        gridLayer.setBounds(originX, originY, size.width, size.height);
    }

    public void addEdges(List<EdgePosition> edges) {
        Iterator listIterator = edges.iterator();
        while (listIterator.hasNext()) {
            EdgePosition edge = (EdgePosition) listIterator.next();
            createEdge(edge);
        }
    }

    private void createEdge(EdgePosition edge) {
        ViewEdge viewEdge = factoryEdges.createViewEdge(edge);
        addInLayer(viewEdge, frontLayer);
        setBoundsOfEdge(viewEdge);
    }

    private void addInLayer(Component component, int layerIndex) {
        pane.add(component);
        pane.setLayer(component, layerIndex);
    }

    private void setBoundsOfEdge(ViewEdge edge) {
        Rectangle edgeBounds = solver.getRectangleFor(edge.getEdgePositions());
        edge.setBounds(edgeBounds);
    }

}
