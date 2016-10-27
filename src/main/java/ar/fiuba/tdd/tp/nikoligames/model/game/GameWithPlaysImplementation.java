package ar.fiuba.tdd.tp.nikoligames.model.game;

import ar.fiuba.tdd.tp.nikoligames.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.model.board.DrawableBoard;
import ar.fiuba.tdd.tp.nikoligames.model.board.EdgeAlreadyExistsExpection;
import ar.fiuba.tdd.tp.nikoligames.model.board.EdgeNotExistsExpection;
import ar.fiuba.tdd.tp.nikoligames.model.board.node.NotEditableExpection;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.Position;
import ar.fiuba.tdd.tp.nikoligames.model.play.AbstractPlayHistory;
import ar.fiuba.tdd.tp.nikoligames.model.play.PlayHistory;
import ar.fiuba.tdd.tp.nikoligames.model.rules.Rule;
import ar.fiuba.tdd.tp.nikoligames.model.rules.RuleManager;

import java.util.List;

/**
 * Responsibilities:
 * 1. Actual implementation of the game.
 */

public class GameWithPlaysImplementation implements Game {
    protected RuleManager ruleManager;
    protected AbstractPlayHistory playHistory;
    protected Board board;

    public GameWithPlaysImplementation(Board board, List<Rule> rules) {
        this.board = board;
        this.ruleManager = new RuleManager(rules);
        this.playHistory = new PlayHistory(this, board);
    }

    public boolean checkWin() {
        return this.ruleManager.checkRules();
    }

    public boolean getBoardStatus() {
        return this.ruleManager.checkActualRules();
    }

    public void changeNodeValue(Position position, String value) throws NotEditableExpection {
        playHistory.changeNodeValue(value, position);
    }

    public void createDirectedEdge(Position position1, Position position2) throws EdgeAlreadyExistsExpection {
        playHistory.createDirectedEdge(position1, position2);
    }

    public void createUndirectedEdge(Position position1, Position position2) throws EdgeAlreadyExistsExpection {
        playHistory.createUndirectedEdge(position1, position2);
    }

    public void removeUndirectedEdge(Position position1, Position position2) throws EdgeNotExistsExpection {
        playHistory.removeUndirectedEdge(position1, position2);
    }

    public void removeDirectedEdge(Position position1, Position position2) throws EdgeNotExistsExpection {
        playHistory.removeDirectedEdge(position1, position2);
    }

    @Override
    public void undoLastPlayMade() {
        playHistory.undo();
    }

    public DrawableBoard getDrawableBoard() {
        return board;
    }

    @Override
    public Board getBoard() {
        return board;
    }


}
