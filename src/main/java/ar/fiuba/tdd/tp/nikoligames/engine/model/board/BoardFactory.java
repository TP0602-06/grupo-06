package ar.fiuba.tdd.tp.nikoligames.engine.model.board;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.position.ClassicPosition;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.position.Position;
import ar.fiuba.tdd.tp.nikoligames.parser.utils.NodeConfig;
import ar.fiuba.tdd.tp.nikoligames.parser.utils.SizeConfig;

import java.util.Iterator;
import java.util.List;

/**
 * Created by german on 10/1/2016.
 */
public class BoardFactory {

    public Board createBoard(SizeConfig sizeConfig, List<NodeConfig> initialNodes) {
        return this.createBoard(sizeConfig.getRows(), sizeConfig.getCols(), initialNodes);
    }

    public Board createBoard(int rows, int cols, List<NodeConfig> initialNodes) {
        Board board = new BoardImplementation(rows, cols);
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
