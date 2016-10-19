package ar.fiuba.tdd.tp.nikoligames.view.regionpainter.bordersavers;

import ar.fiuba.tdd.tp.nikoligames.model.board.position.ClassicPosition;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.Position;
import ar.fiuba.tdd.tp.nikoligames.view.regionpainter.bordersavers.fixedkeys.FixedKey;
import ar.fiuba.tdd.tp.nikoligames.view.regionpainter.bordersavers.valuecomparer.ValueComparer;

import java.util.*;

/**
 * Created by tobias on 19/10/16.
 */
public abstract class BorderSaver {
    protected Map<Integer, Integer> borders;
    private FixedKey fixedKey;
    private ValueComparer comparer;

    public BorderSaver(FixedKey fixedKey, ValueComparer comparer) {
        borders = new HashMap<>();
        this.fixedKey = fixedKey;
        this.comparer = comparer;
    }

    public void update(Integer row, Integer column) {
        if (newKey(row, column)) {
            addPair(row, column);
        } else if (newValue(row, column)) {
            replace(row, column);
        }
    }

    protected void addPair(Integer row, Integer column) {
        Integer key = fixedKey.getFirst(row, column);
        Integer value = fixedKey.getSecond(row, column);
        borders.put(key, value);
    }

    protected void replace(Integer row, Integer column) {
        Integer key = fixedKey.getFirst(row, column);
        Integer value = fixedKey.getSecond(row, column);
        borders.replace(key, value);
    }

    protected boolean newValue(Integer row, Integer column) {
        Integer key = fixedKey.getFirst(row, column);
        Integer actualValue = fixedKey.getSecond(row, column);
        Integer previousValue = borders.get(key);
        return comparer.isValid(actualValue, previousValue);
    }

    protected boolean newKey(Integer row, Integer column) {
        Integer key = fixedKey.getFirst(row, column);
        return !borders.containsKey(key);
    }

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

    protected Position makePosition(Integer key, Integer value) {
        Integer row = fixedKey.getFirst(key, value);
        Integer column = fixedKey.getSecond(key, value);
        return new ClassicPosition(row, column);
    }
}
