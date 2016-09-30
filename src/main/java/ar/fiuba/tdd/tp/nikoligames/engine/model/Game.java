package ar.fiuba.tdd.tp.nikoligames.engine.model;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.ConcreteBoard;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.DrawableBoard;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.RuleManager;
import ar.fiuba.tdd.tp.nikoligames.engine.parser.GameConfig;

/**
 * Game. Adminstra el juego. Valida las reglas y permite que se modifiquen el valor de las celdas.
 */

public class Game {
    protected GameConfig gameConfig;
    RuleManager ruleManager;
    private ValidInputManager validInputManager;

    private ConcreteBoard board;

    public Game(GameConfig gameConfig) {
        this.gameConfig = gameConfig;
        this.board = new ConcreteBoard(this.gameConfig.getSizeConfig().getRows(), this.gameConfig.getSizeConfig().getCols(), this.gameConfig.getInitialCells());
        this.ruleManager = new RuleManager(board, this.gameConfig.getRules());
        this.validInputManager = new ValidInputManager(this.gameConfig.getValidInputs());
    }

    public DrawableBoard getDrawableBoard() {
        DrawableBoard drawableBoard = this.board;
        return drawableBoard;
    }

    public boolean checkRules() {
        return this.ruleManager.checkRules();
    }

    public void playMove(Coordinates position, String value) throws Exception {
        ValidInputManager validInputManager = this.validInputManager;
        if (!validInputManager.isValidInput(value)) throw new Exception("Not a valid input");

        Board board = this.board;
        board.setCellValue(position, value);
    }

    public String getGameName() {
        return this.gameConfig.getName();
    }

}
