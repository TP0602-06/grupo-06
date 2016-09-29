package ar.fiuba.tdd.tp.nikoligames.engine.GameMove;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.DrawableCell;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Position;
import ar.fiuba.tdd.tp.nikoligames.engine.model.game.Game;

/**
 * Esta clase representa el movimiento de una jugada.
 */
public class GameMove {

    private Position position;
    private Integer num;
    private String value;

    public GameMove(Integer num, String value, Position position) {
        this.position = position;
        this.num = num;
        this.value = value;
    }

    public boolean makeMove(Game game) {
        game.insertValueInCell(position, value);
        DrawableCell cell = game.getDrawableBoard().getADrawableCell(position);
        String actualValue = cell.getValue();
        return actualValue.equals(value);
    }

    public  Integer getNum() {
        return num;
    }
}