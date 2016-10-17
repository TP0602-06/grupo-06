package ar.fiuba.tdd.tp.nikoligames.engine.reporter;

import ar.fiuba.tdd.tp.nikoligames.engine.model.game.Game;
import ar.fiuba.tdd.tp.nikoligames.engine.model.play.AbstractPlay;
import ar.fiuba.tdd.tp.nikoligames.engine.model.play.ChangeNodeValuePlay;

import java.util.List;

/**
 * Responsabilidades:
 * 1. generar reporte del juego
 */
public interface ReportMoves {

    String makeReport(Game game, List<AbstractPlay> moves) throws Exception;
}
