package ar.fiuba.tdd.tp.nikoligames.engine.model.game;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.DrawableBoard;
import ar.fiuba.tdd.tp.nikoligames.engine.model.inputmanager.ValidInputManager;
import ar.fiuba.tdd.tp.nikoligames.engine.model.position.Position;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.RuleManager;
import ar.fiuba.tdd.tp.nikoligames.engine.parser.utils.GameConfig;

import java.util.HashSet;
import java.util.List;

/**
 * GameImplementation. Adminstra el juego. Valida las reglas y permite que se modifiquen el valor de las celdas.
 */

public class GameImplementation implements Game {
    private GameConfig gameConfig;
    private RuleManager ruleManager;
    private ValidInputManager validInputManager;
    private Board board;


    public GameImplementation(Board board, RuleManager ruleManager, ValidInputManager inputManager) {
        this.board = board;
        this.ruleManager = ruleManager;
        this.validInputManager = inputManager;
    }

    public DrawableBoard getDrawableBoard() {
        return board;
    }

    @Override
    public HashSet<String> getValidInputs() {
        return validInputManager.getValidInputs();
    }

    public boolean checkRules() {
        return this.ruleManager.checkRules();
    }

    public void playMove(Position position, String value) throws Exception {
        ValidInputManager validInputManager = this.validInputManager;
        if (!validInputManager.isValidInput(value)) throw new Exception("Not a valid input");
        board.changeCellValue(position, value);
    }

    public String getGameName() {
        return this.gameConfig.getName();
    }

}