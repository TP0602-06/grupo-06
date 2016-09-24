package ar.fiuba.tdd.tp.nikoligames.engine.parser;

import ar.fiuba.tdd.tp.nikoligames.engine.model.Game;

/**
 * Created by mcapolupo on 20/9/16.
 * This class will have all the necessary settings to create a {@link Game}.
 */

public class GameConfig {

    private SizeConfig size;
    private BoardConfig problem;
    private BoardConfig solution;

    public GameConfig(SizeConfig sizeConfig, BoardConfig problem, BoardConfig solution) {
        this.size = sizeConfig;
        this.problem = problem;
        this.solution = solution;
    }

    public BoardConfig getProblem() {
        return problem;
    }

    public BoardConfig getSolution() {
        return solution;
    }

    public SizeConfig getSize() {
        return size;
    }
}
