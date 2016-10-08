package ar.fiuba.tdd.tp.nikoligames.engine.model.game;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.DrawableBoard;
import ar.fiuba.tdd.tp.nikoligames.engine.model.position.Position;
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
        board.changeNodeValue(position, value);
    }

    public void createEdge(Position position1, Position position2) {
        board.createEdge(position1, position2);
        // TODO verificar que sea una conexion valida
    }

    public boolean checkActualBoard() {
        return this.ruleManager.checkActualRules();
    }

    ;


}
