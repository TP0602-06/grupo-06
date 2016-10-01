package ar.fiuba.tdd.tp.nikoligames.engine.reporter;

import ar.fiuba.tdd.tp.nikoligames.engine.model.GameImplementation;
import ar.fiuba.tdd.tp.nikoligames.engine.model.play.Play;

import java.util.List;

/**
 *
 */
public interface ReportMoves {

    String makeReport(GameImplementation game, List<Play> moves) throws Exception;
}
