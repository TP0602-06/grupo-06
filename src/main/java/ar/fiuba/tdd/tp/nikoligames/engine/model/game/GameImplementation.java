package ar.fiuba.tdd.tp.nikoligames.engine.model.game;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.DrawableBoard;
import ar.fiuba.tdd.tp.nikoligames.engine.model.inputmanager.ValidInputManager;
import ar.fiuba.tdd.tp.nikoligames.engine.model.position.Position;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.Rule;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.RuleManager;

import java.util.HashSet;
import java.util.List;

/**
 * GameImplementation. Adminstra el juego. Valida las reglas y permite que se modifiquen el valor de las celdas.
 */

public class GameImplementation implements Game {
    private final String gameName;
    private RuleManager ruleManager;
    private ValidInputManager validInputManager;
    private Board board;


    public GameImplementation(Board board, List<Rule> rules, ValidInputManager inputManager, String gameName) {
        this.board = board;
        this.validInputManager = inputManager;
        this.gameName = gameName;
        this.ruleManager = new RuleManager(rules);
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

    public void changeNodeValue(Position position, String value) throws Exception {
        ValidInputManager validInputManager = this.validInputManager;
        if (!validInputManager.isValidInput(value)) {
            throw new Exception("Not a valid input");
        }
        board.changeNodeValue(position, value);
    }

    public String getGameName() {
        return this.gameName;
    }

}
