package ar.fiuba.tdd.tp.nikoligames.model.rules.generators.adjacentrules;

import ar.fiuba.tdd.tp.nikoligames.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.ClassicPosition;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.Position;
import ar.fiuba.tdd.tp.nikoligames.model.rules.Rule;
import ar.fiuba.tdd.tp.nikoligames.model.rules.implementations.circuit.EdgesInternalToRegionCountRule;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by german on 10/18/2016.
 * Responsibilities:
 * 1. Creates a list of EdgesInternalToRegionCountRule for the countryroad game (Every node must have at least one diagonal)
 */
public class DiagonalCellNotEmptyAndExluyentGenerator {

    private final Board board;

    public DiagonalCellNotEmptyAndExluyentGenerator(Board board) {
        this.board = board;
    }

    public List<Rule> createRules() {
        List<Rule> rulesGenerated = new ArrayList<Rule>();

        for (int row = 1; row <= board.getRows() - 1; row ++) {
            for (int col = 1; col <= board.getCols() - 1; col ++) {
                List<AbstractNode> region = new ArrayList<AbstractNode>();
                addNode(board, region, row, col);
                addNode(board, region, row, col + 1);
                addNode(board, region, row + 1, col);
                addNode(board, region, row + 1, col + 1);

                Rule rule = new EdgesInternalToRegionCountRule(region, "1");
                rulesGenerated.add(rule);
            }
        }
        return rulesGenerated;
    }

    private void addNode(Board board, List<AbstractNode> region, int row, int col) {
        Position position = new ClassicPosition(row, col);
        region.add(board.getNode(position));
    }
}
