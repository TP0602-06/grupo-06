package ar.fiuba.tdd.tp.nikoligames.model.rules.generators.adjacentlist.adjacentposition;

import ar.fiuba.tdd.tp.nikoligames.model.board.position.Position;

import java.util.List;

/**
 * Created by tobias on 18/10/16.
 */
public abstract class AdjacentPositionGenerator {

    public List<Position> getAdjacents(Position position) {
        Integer row = position.getRow();
        Integer colum = position.getColumn();
        return getListFor(row,colum);
    }

    protected abstract List<Position> getListFor(Integer row, Integer colum);

}
