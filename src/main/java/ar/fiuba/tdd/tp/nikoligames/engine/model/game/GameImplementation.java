package ar.fiuba.tdd.tp.nikoligames.engine.model.game;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.DrawableBoard;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.position.Position;
import ar.fiuba.tdd.tp.nikoligames.engine.model.play.AbstractPlay;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.Rule;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.RuleManager;

import java.util.List;

/**
 * GameImplementation. Adminstra el juego. Valida las reglas y permite que se modifiquen el valor de las celdas.
 * patron de diseno:
 * Mediador
 */

public abstract class GameImplementation implements Game {
    protected RuleManager ruleManager;
    public List<AbstractPlay> playHistory;

    protected Board board;

    public GameImplementation(Board board, List<Rule> rules) {
        this.board = board;
        this.ruleManager = new RuleManager(rules);
    }

    public abstract boolean changeNodeValue(Position position, String value);

    public abstract boolean createDirectedEdge(Position position1, Position position2);

    public abstract boolean createUndirectedEdge(Position position1, Position position2);

    public abstract boolean removeUndirectedEdge(Position position1, Position position2);

    public abstract boolean removeDirectedEdge(Position position1, Position position2);

    public DrawableBoard getDrawableBoard() {
        return board;
    }

    public boolean checkWin() {
        return this.ruleManager.checkRules();
    }

    public boolean getBoardStatus() {
        return this.ruleManager.checkActualRules();
    }

}
