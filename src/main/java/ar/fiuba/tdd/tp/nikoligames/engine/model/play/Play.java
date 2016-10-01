package ar.fiuba.tdd.tp.nikoligames.engine.model.play;

import ar.fiuba.tdd.tp.nikoligames.engine.model.ClassicCoordinates;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.cell.DrawableCell;
import ar.fiuba.tdd.tp.nikoligames.engine.model.GameImplementation;

/**
 * Esta clase representa el movimiento de una jugada.
 */
public class Play {

    private ClassicCoordinates position;
    private Integer num;
    private String value;

    public Play(Integer num, String value, ClassicCoordinates position) {
        this.position = position;
        this.num = num;
        this.value = value;
    }

    public boolean makeMove(GameImplementation game) throws Exception {
        game.playMove(position, value);
        DrawableCell cell = game.getDrawableBoard().getDrawableCell(position);
        String actualValue = cell.getValue();
        return actualValue.equals(value);
    }

    public  Integer getNum() {
        return num;
    }
}