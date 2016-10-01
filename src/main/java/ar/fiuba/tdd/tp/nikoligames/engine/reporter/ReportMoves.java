package ar.fiuba.tdd.tp.nikoligames.engine.reporter;

import ar.fiuba.tdd.tp.nikoligames.engine.model.game.GameImplementation;
import ar.fiuba.tdd.tp.nikoligames.engine.model.play.Play;

import java.util.List;

/**
 * Responsabilidades:
 * 1. generar reporte del juego
 */
public interface ReportMoves {

    String makeReport(GameImplementation game, List<Play> moves) throws Exception;
}
