package ar.fiuba.tdd.tp.nikoligames.engine.parser;

import ar.fiuba.tdd.tp.nikoligames.engine.model.game.Game;

/**
 * Created by mcapolupo on 20/9/16.
 * This class will have all the necessary settings to create a {@link Game}.
 */
@SuppressWarnings("CPD-START") //TODO: ver por que falla pmd
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

    @SuppressWarnings("CPD-END")
    public SizeConfig getSize() {
        return size;
    }
}
