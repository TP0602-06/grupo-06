package ar.fiuba.tdd.tp.nikoligames.view.regionpainter.borderSavers;

import ar.fiuba.tdd.tp.nikoligames.model.board.position.Position;

import java.util.*;

/**
 * Created by tobias on 19/10/16.
 */
public abstract class BorderSaver {
    protected Map<Integer, Integer> borders;

    public BorderSaver() {
        borders = new HashMap<>();
    }

    public void update(Integer row, Integer column) {
        if (newKey(row, column)) {
            addPair(row, column);
        } else if (newValue(row, column)) {
            replace(row, column);
        }
    }

    protected abstract void addPair(Integer row, Integer column);

    protected abstract void replace(Integer row, Integer column);

    protected abstract boolean newValue(Integer row, Integer column);

    protected abstract boolean newKey(Integer row, Integer column);

    public List<Position> getPositions() {
        List<Position> positions = new ArrayList<>();
        Iterator mapIterator = borders.entrySet().iterator();
        while (mapIterator.hasNext()) {
            Map.Entry pair = (Map.Entry) mapIterator.next();
            Integer key = (Integer) pair.getKey();
            Integer value = (Integer) pair.getValue();
            Position position = makePosition(key, value);
            positions.add(position);
        }
        return positions;
    }

    protected abstract Position makePosition(Integer key, Integer value);
}
