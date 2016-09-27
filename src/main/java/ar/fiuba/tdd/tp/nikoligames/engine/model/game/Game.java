package ar.fiuba.tdd.tp.nikoligames.engine.model.game;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.DrawableBoard;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.RuleManager;


/**
 * Created by fedebrasburg on 9/23/16.
 */
public abstract class Game {
    protected Board board;
    protected RuleManager ruleManager;

    public Game(Board board, RuleManager ruleManager) {
        this.board = board;
        this.ruleManager = ruleManager;
    }

    public DrawableBoard getDrawableBoard() {
        DrawableBoard drawableBoard = (DrawableBoard) this.board;
        return drawableBoard;
    }

    public boolean checkRules() {
        return ruleManager.checkRules();
    }

}
