package ar.fiuba.tdd.tp.nikoligames.view.board;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.position.EdgePosition;
import ar.fiuba.tdd.tp.nikoligames.view.clickables.edge.DrawableEdge;
import ar.fiuba.tdd.tp.nikoligames.view.clickables.edge.ViewDiagonalEdge;
import ar.fiuba.tdd.tp.nikoligames.view.clickables.edge.ViewEdge;
import ar.fiuba.tdd.tp.nikoligames.view.grids.GridView;
import ar.fiuba.tdd.tp.nikoligames.view.viewcontroller.SelectEdgeController;

import java.awt.*;
import java.util.ArrayList;
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
    private SelectEdgeController diagonal;
    private SelectEdgeController common;
    private List<ViewDiagonalEdge> diagonalEdges;

    public BoardView(Dimension size, GridView gridLayer, SelectEdgeController common, SelectEdgeController diagonal) {
        super();
        this.diagonal = diagonal;
        this.common = common;
        diagonalEdges = new ArrayList<>();
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

    public void addEdges(List<EdgePosition> edges) {
        Iterator listIterator = edges.iterator();
        while (listIterator.hasNext()) {
            EdgePosition edge = (EdgePosition) listIterator.next();
            createEdge(edge);
        }
    }

    private void createEdge(EdgePosition edge) {
        ViewEdge viewEdge;
        if (EdgePositionHelper.isDiagonal(edge)){
            viewEdge =  getNewOrExistantDiagonalEdge(edge);
        }else {
            viewEdge = new DrawableEdge(edge,common);
        }
        addInLayer(viewEdge, frontLayer);
        setBoundsOfEdge(viewEdge);
    }

    private ViewEdge getNewOrExistantDiagonalEdge(EdgePosition edge) {
        for (int i = 0; i < diagonalEdges.size(); i++){
            ViewDiagonalEdge diagonalEdge = diagonalEdges.get(i);
            EdgePosition existentDiagonal = diagonalEdges.get(i).getEdgePositions();
            if (EdgePositionHelper.areDiagonalsOfSameCell(edge,existentDiagonal)) {
                diagonalEdge.addOtherEdge(edge);
                return diagonalEdge;
            }
        }
        ViewDiagonalEdge newEdge = new ViewDiagonalEdge(edge,diagonal);
        diagonalEdges.add(newEdge);
        return newEdge;
    }

    private void addInLayer(Component component, int layerIndex) {
        pane.add(component);
        pane.setLayer(component, layerIndex);
    }

    private void setBoundsOfEdge(ViewEdge edge) {
        ViewEdgeCellViewPositionSolver edgeSolver = new ViewEdgeCellViewPositionSolver(cellgrid,true);
        Rectangle edgeBounds = edgeSolver.getRectangleFor(edge.getEdgePositions());
        edge.setBounds(edgeBounds);
    }

}
