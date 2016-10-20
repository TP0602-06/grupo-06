package ar.fiuba.tdd.tp.nikoligames.view.board;


import ar.fiuba.tdd.tp.nikoligames.model.board.position.EdgePosition;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.Position;
import ar.fiuba.tdd.tp.nikoligames.parser.utils.viewconfig.PaintableHintConfig;
import ar.fiuba.tdd.tp.nikoligames.view.board.positionsolver.CellSizeCalculator;
import ar.fiuba.tdd.tp.nikoligames.view.clickables.NotClickableHint;
import ar.fiuba.tdd.tp.nikoligames.view.clickables.Paintable;
import ar.fiuba.tdd.tp.nikoligames.view.clickables.edge.ViewEdge;
import ar.fiuba.tdd.tp.nikoligames.view.config.ViewConfig;
import ar.fiuba.tdd.tp.nikoligames.view.grids.GridView;
import ar.fiuba.tdd.tp.nikoligames.view.hints.HintPainter;


import java.awt.*;
import java.util.Iterator;
import java.util.List;
import javax.swing.*;


/**
 * Created by tobias on 14/10/16.
 */
public class BoardView extends JPanel {

    private Integer padding = 15;
    private JLayeredPane pane;
    private ViewEdgeFactory factoryEdges;
    private ViewEdgeCellViewPositionSolver solver;
    private List<PaintableHintConfig> nodeHints;
    private CellSizeCalculator cellSizeCalculator;

    public BoardView(GridView gridLayer, ViewEdgeFactory factoryEdge, ViewConfig viewConfig) {
        super();
        Dimension size = viewConfig.getBoardDimension();
        Dimension withPadding = new Dimension(size.width + padding * 2, size.height + padding * 2);
        pane = new JLayeredPane();
        pane.setPreferredSize(withPadding);
        cellSizeCalculator = new CellSizeCalculator(gridLayer);
        factoryEdges = factoryEdge;
        solver = new ViewEdgeCellViewPositionSolver(cellSizeCalculator, viewConfig.isCellBoard());
        nodeHints = viewConfig.getNodeHintConfigs();
        add(pane);
        addGrid(gridLayer, size);
    }

    private void addGrid(GridView gridLayer, Dimension size) {
        addInLayer(gridLayer, JLayeredPane.DEFAULT_LAYER);
        gridLayer.setBounds(padding, padding, size.width, size.height);
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
        addInLayer(viewEdge, JLayeredPane.PALETTE_LAYER);
        setBoundsOfEdge(viewEdge);
    }

    private void addInLayer(Component component, Integer layerIndex) {
        pane.add(component, layerIndex);
        pane.setLayer(component, layerIndex);
    }

    private void setBoundsOfEdge(ViewEdge edge) {
        Rectangle edgeBounds = solver.getRectangleFor(edge.getEdgePositions());
        Integer width = (int) edgeBounds.getWidth();
        Integer height = (int) edgeBounds.getHeight();
        Integer coordinateX = (int) edgeBounds.getX() + padding;
        Integer coordinateY = (int) edgeBounds.getY() + padding;
        Rectangle withPadding = new Rectangle(coordinateX, coordinateY, width, height);
        edge.setBounds(withPadding);
    }

    public void addNodeHints() {
        Iterator<PaintableHintConfig> hints = nodeHints.iterator();
        while (hints.hasNext()) {
            PaintableHintConfig config = hints.next();
            Position nodePosition = config.getPosition();
            HintPainter painter = config.getCellHint();
            createHint(nodePosition, painter);
        }
    }

    private void createHint(Position nodePosition, HintPainter painter) {
        Paintable hint = new NotClickableHint();
        Position centerOfHint = solver.transformToViewPosition(nodePosition);
        Integer width = (int) (cellSizeCalculator.getWidth() * 0.5);
        Integer height = (int) (cellSizeCalculator.getHeight() * 0.5);
        Integer coordinateX = centerOfHint.getRow() + padding - width / 2;
        Integer coordinateY = centerOfHint.getColumn() + padding - height / 2;
        Rectangle hintRectangle = new Rectangle(coordinateX, coordinateY, width, height);
        hint.setBounds(hintRectangle);
        hint.setSize(width, height);
        addInLayer(hint, JLayeredPane.MODAL_LAYER);
        painter.draw(hint);
        hint.setForeground(Color.GREEN);
    }

}
