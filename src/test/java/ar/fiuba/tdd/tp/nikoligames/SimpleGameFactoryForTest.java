package ar.fiuba.tdd.tp.nikoligames;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.UndirectedBoard;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.ConcreteNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.game.Game;
import ar.fiuba.tdd.tp.nikoligames.engine.model.game.GameImplementation;
import ar.fiuba.tdd.tp.nikoligames.engine.model.position.ClassicPosition;
import ar.fiuba.tdd.tp.nikoligames.engine.model.position.Position;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.Rule;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.NoDuplicatesRule;

import java.util.ArrayList;
import java.util.List;

public class SimpleGameFactoryForTest {

    private Integer rows = 2;
    private Integer cols = 2;
    public static final String one = "1";
    public static final String two = "2";

    public Game makeGame() {
        Board board = new UndirectedBoard(rows, cols);
        fillBoard(board);
        List<Rule> rules = new ArrayList<>();
        Rule rule = new NoDuplicatesRule(makePositions(board));
        rules.add(rule);


        return new GameImplementation(board, rules);
    }

    private void fillBoard(Board board) {
        for (int i = 1; i <= board.getRows(); i++) {
            for (int j = 1; j <= board.getCols(); j++) {
                AbstractNode cell = new ConcreteNode("", true);
                Position position = new ClassicPosition(i, j);
                board.setNode(position, cell);
            }
        }
    }

    private ArrayList<AbstractNode> makePositions(Board board) {
        ArrayList<AbstractNode> nodes = new ArrayList<>();

        for (int i = 1; i <= board.getRows(); i++) {
            for (int j = 1; j <= board.getCols(); j++) {
                Position position = new ClassicPosition(i, j);
                nodes.add(board.getNode(position));
            }
        }
        return nodes;

    }
}
