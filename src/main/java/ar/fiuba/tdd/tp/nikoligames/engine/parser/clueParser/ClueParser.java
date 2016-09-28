package ar.fiuba.tdd.tp.nikoligames.engine.parser.clueParser;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.DrawableCell;

/**
 * Created by tobias on 28/09/16.
 */
public interface ClueParser {

    String topClue(DrawableCell cell);

    String bottomClue(DrawableCell cell);

    boolean hasTopClue(DrawableCell cell);

    boolean hasBottomClue(DrawableCell cell);

    boolean isBarClue(DrawableCell cell);

}
