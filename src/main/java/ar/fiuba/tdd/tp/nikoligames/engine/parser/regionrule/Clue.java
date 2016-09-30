package ar.fiuba.tdd.tp.nikoligames.engine.parser.regionrule;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Position;

/**
 * Created by tobias on 29/09/16.
 */
public class Clue {
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    private Position position;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    private String value;


}
