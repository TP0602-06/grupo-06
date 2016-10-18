package ar.fiuba.tdd.tp.nikoligames.model.board.factory;

import ar.fiuba.tdd.tp.nikoligames.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.model.board.ConcreteBoard;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.ClassicPosition;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.Position;
import ar.fiuba.tdd.tp.nikoligames.parser.utils.NodeConfig;
import ar.fiuba.tdd.tp.nikoligames.parser.utils.SizeConfig;

import java.util.Iterator;
import java.util.List;

/**
 * Responsibilities:
 * 1. Creates a board from a board configuration.
 */
public class BoardFactory {

    public Board createBoard(SizeConfig sizeConfig, List<NodeConfig> initialNodes) throws Exception {
        return this.createBoard(sizeConfig.getRows(), sizeConfig.getCols(), initialNodes);
    }

    public Board createBoard(int rows, int cols, List<NodeConfig> initialNodes) throws Exception {
        Board board = new ConcreteBoard(rows, cols);
        setInitialValues(initialNodes, board);
        return board;
    }

    private void setInitialValues(List<NodeConfig> initialCells, Board board) {
        Iterator<NodeConfig> iterator = initialCells.iterator();
        while (iterator.hasNext()) {
            NodeConfig nodeConfig = iterator.next();
            Position position = new ClassicPosition(nodeConfig.getRow(), nodeConfig.getCol());
            board.setEditable(position, nodeConfig.isEditable());
            board.changeNodeValue(position, nodeConfig.getValue());
        }
    }
}
