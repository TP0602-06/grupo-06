package ar.fiuba.tdd.tp.nikoligames.model.rules.generators.adjacentlist.adjacentposition;

import ar.fiuba.tdd.tp.nikoligames.model.board.position.ClassicPosition;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.Position;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tobias on 18/10/16.
 */
public class DiagonalAdjacents extends AdjacentPositionGenerator {

    @Override
    protected List<Position> getListFor(Integer row, Integer colum) {
        List<Position> adjacents = new ArrayList<>();

        adjacents.add(new ClassicPosition(row + 1, colum - 1));
        adjacents.add(new ClassicPosition(row - 1, colum - 1));
        adjacents.add(new ClassicPosition(row + 1, colum + 1));
        adjacents.add(new ClassicPosition(row - 1, colum + 1));

        return adjacents;
    }
}
