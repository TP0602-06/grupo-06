package ar.fiuba.tdd.tp.nikoligames.engine.model;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.DrawableBoard;
import ar.fiuba.tdd.tp.nikoligames.engine.parser.GameConfig;

/**
 * Game. Adminstra el juego. Valida las reglas y permite que se modifiquen el valor de las celdas.
 */

public class Game {
    protected GameConfig gameConfig;

    public Game(GameConfig gameConfig) {
        this.gameConfig = gameConfig;
    }

    public DrawableBoard getDrawableBoard() {
        DrawableBoard drawableBoard = this.gameConfig.getBoard();
        return drawableBoard;
    }

    public boolean checkRules() {
        return this.gameConfig.getRuleManager().checkRules();
    }

    public void playMove(Coordinates position, String value) throws Exception {
        ValidInputManager validInputManager = this.gameConfig.getValidInputManager();
        if (!validInputManager.isValidInput(value)) throw new Exception("Not a valid input");

        Board board = this.gameConfig.getBoard();
        board.setCellValue(position, value);
    }

    public String getGameName(){
        return this.gameConfig.getName();
    }

}
