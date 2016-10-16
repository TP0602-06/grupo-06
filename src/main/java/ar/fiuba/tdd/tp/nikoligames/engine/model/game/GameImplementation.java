package ar.fiuba.tdd.tp.nikoligames.engine.model.game;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.DrawableBoard;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.position.Position;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.Rule;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.RuleManager;

import java.util.List;

/**
 * GameImplementation. Adminstra el juego. Valida las reglas y permite que se modifiquen el valor de las celdas.
 * patron de diseno:
 * Mediador
 */

public class GameImplementation implements Game {
    private RuleManager ruleManager;
    private Board board;


    public GameImplementation(Board board, List<Rule> rules) {
        this.board = board;
        this.ruleManager = new RuleManager(rules);
    }

    public DrawableBoard getDrawableBoard() {
        return board;
    }

    public boolean checkWin() {
        return this.ruleManager.checkRules();
    }

    public void changeNodeValue(Position position, String value) {
        String oldValue = board.getNodeValue(position);
        board.changeNodeValue(position, value);
        if (!checkActualBoard()) {
            board.changeNodeValue(position, oldValue);
        }
    }

    @Override
    public void createDirectedEdge(Position position1, Position position2) {
        board.createDirectedEdge(position1, position2);
    }

    @Override
    public void createUndirectedEdge(Position position1, Position position2) {
        board.createUndirectedEdge(position1, position2);
    }

    @Override
    public void removeUndirectedEdge(Position position1, Position position2) {
        board.removeUndirectedEdge(position1, position2);
    }

    @Override
    public void removeDirectedEdge(Position position1, Position position2) {
        board.removeDirectedEdge(position1, position2);
    }

    public boolean checkActualBoard() {
        return this.ruleManager.checkActualRules();
    }

}
