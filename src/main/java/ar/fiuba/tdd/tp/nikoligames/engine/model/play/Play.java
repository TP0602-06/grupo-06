package ar.fiuba.tdd.tp.nikoligames.engine.model.play;

import ar.fiuba.tdd.tp.nikoligames.engine.model.game.Game;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.position.Position;

/**
 * Esta clase representa el movimiento de una jugada.
 */
public class Play {

    private Position position;
    private Integer num;
    private String value;

    public Play(Integer num, String value, Position position) {
        this.position = position;
        this.num = num;
        this.value = value;
    }

    public boolean makeMove(Game game) throws Exception {
        game.changeNodeValue(position, value);
        return game.checkActualBoard();
    }

    public Integer getNum() {
        return num;
    }
}