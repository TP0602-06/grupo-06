package ar.fiuba.tdd.tp.nikoligames.engine.parser.clueParser;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.DrawableCell;

/**
 * Clase que parsea la clue de kakuro json.
 */
public class ClueJsonParser implements ClueParser {
    private static final Integer topIndex = 1;
    private static final Integer bottomIndex = 0;
    private static final String separator = "\\\\";
    private static final String EMPTY_CLUE = "*";

    public String topClue(DrawableCell cell){
        return extractClue(cell, topIndex);
    }

    public String bottomClue(DrawableCell cell){
        return extractClue(cell,bottomIndex);
    }

    @Override
    public boolean hasTopClue(DrawableCell cell) {
        return isEmptyClue(topClue(cell));
    }

    @Override
    public boolean hasBottomClue(DrawableCell cell) {
        return isEmptyClue(bottomClue(cell));
    }

    private String extractClue(DrawableCell cell, Integer index) {
        String value = cell.getValue();
        return value.split(separator)[index];
    }

    private boolean isEmptyClue(String value){
        return !value.equals(EMPTY_CLUE);
    }

    public boolean isBarClue(DrawableCell cell){
        String value = cell.getValue();
        return value.contains("\\");
    }
}
