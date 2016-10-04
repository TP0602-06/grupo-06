package ar.fiuba.tdd.tp.nikoligames.engine.model.play;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.cell.DrawableCell;
import ar.fiuba.tdd.tp.nikoligames.engine.model.game.Game;

import ar.fiuba.tdd.tp.nikoligames.engine.model.position.ClassicPosition;

/**
 * Esta clase representa el movimiento de una jugada.
 */
public class Play {

    private ClassicPosition position;
    private Integer num;
    private String value;

    public Play(Integer num, String value, ClassicPosition position) {
        this.position = position;
        this.num = num;
        this.value = value;
    }

    public boolean makeMove(Game game) throws Exception {
        return game.playMove(position, value);
    }

    public Integer getNum() {
        return num;
    }
}