package ar.fiuba.tdd.tp.nikoligames.engine.reporter;

import ar.fiuba.tdd.tp.nikoligames.engine.GameMove.GameMove;
import ar.fiuba.tdd.tp.nikoligames.engine.model.game.Game;

import java.util.List;

/**
 *
 */
public interface ReportMoves {

    String makeReport(Game game, List<GameMove> moves);
}
