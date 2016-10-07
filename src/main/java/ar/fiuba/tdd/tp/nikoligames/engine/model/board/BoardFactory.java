package ar.fiuba.tdd.tp.nikoligames.engine.model.board;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.ConcreteNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.position.ClassicPosition;
import ar.fiuba.tdd.tp.nikoligames.engine.model.position.Position;
import ar.fiuba.tdd.tp.nikoligames.engine.parser.utils.NodeConfig;

import java.util.Iterator;
import java.util.List;

/**
 * Created by german on 10/1/2016.
 */
public class BoardFactory {
    public Board createBoard(int rows, int cols, List<NodeConfig> initialNodes) {
        Board board = new UndirectedBoard(rows, cols);
        setInitialValues(initialNodes, board);

        return board;
    }

    private void setInitialValues(List<NodeConfig> initialCells, Board board) {
        Iterator<NodeConfig> iterator = initialCells.iterator();
        while (iterator.hasNext()) {
            NodeConfig nodeConfig = iterator.next();
            Position coordinates = new ClassicPosition(nodeConfig.getRow(), nodeConfig.getCol());

            AbstractNode node = new ConcreteNode(nodeConfig.getValue(), nodeConfig.isEditable());

            board.setNode(coordinates, node);
        }
    }
}
