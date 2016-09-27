package ar.fiuba.tdd.tp.nikoligames.engine.parser;

import ar.fiuba.tdd.tp.nikoligames.engine.model.Game;

/**
 * Created by mcapolupo on 20/9/16.
 * This class will have all the necessary settings to create a {@link Game}.
 */

public class GameConfig {

    private SizeConfig size;
    private BoardConfig board;

    public GameConfig(SizeConfig sizeConfig, BoardConfig board) {
        this.size = sizeConfig;
        this.board = board;
    }

    public BoardConfig getBoard() {
        return board;
    }

    public SizeConfig getSize() {
        return size;
    }
}
