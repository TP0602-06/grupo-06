package ar.fiuba.tdd.tp.nikoligames.reporter;

import ar.fiuba.tdd.tp.nikoligames.model.game.Game;
import ar.fiuba.tdd.tp.nikoligames.model.play.AbstractPlay;
import org.json.simple.JSONObject;

import java.util.List;

/**
 * Responsabilidades:
 * 1. generar reporte del juego
 */
public interface AbstractPlaysReporter {

    JSONObject makeJsonReport(Game game, List<AbstractPlay> gameMoves) throws Exception;

    void writeReport(Game game, List<AbstractPlay> gamePlays, String filenameOutput) throws Exception;
}
