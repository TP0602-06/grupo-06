package ar.fiuba.tdd.tp.nikoligames.view.regionpainter.borderSavers;

import ar.fiuba.tdd.tp.nikoligames.model.board.position.ClassicPosition;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.Position;
import ar.fiuba.tdd.tp.nikoligames.view.regionpainter.borderSavers.BorderSaver;

/**
 * Created by tobias on 19/10/16.
 */
public abstract class ColumnFixedRowVariableBorder extends BorderSaver {
    @Override
    protected void addPair(Integer row, Integer column) {
        borders.put(column, row);
    }

    @Override
    protected void replace(Integer row, Integer column) {
        borders.replace(column, row);
    }

    @Override
    protected boolean newValue(Integer row, Integer column) {
        Integer previousValue = borders.get(column);
        return isNew(row, previousValue);
    }

    protected abstract boolean isNew(Integer row, Integer previousValue);

    @Override
    protected boolean newKey(Integer row, Integer column) {
        return !borders.containsKey(column);
    }

    @Override
    protected Position makePosition(Integer key, Integer value) {
        return new ClassicPosition(value, key);
    }
}
