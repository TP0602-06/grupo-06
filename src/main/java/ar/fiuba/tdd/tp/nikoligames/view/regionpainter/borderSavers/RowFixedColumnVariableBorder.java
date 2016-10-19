package ar.fiuba.tdd.tp.nikoligames.view.regionpainter.borderSavers;

import ar.fiuba.tdd.tp.nikoligames.model.board.position.ClassicPosition;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.Position;
import ar.fiuba.tdd.tp.nikoligames.view.regionpainter.borderSavers.BorderSaver;

/**
 * Created by tobias on 19/10/16.
 */
public abstract class RowFixedColumnVariableBorder extends BorderSaver {
    @Override
    protected void addPair(Integer row, Integer column) {
        borders.put(row,column);
    }

    @Override
    protected void replace(Integer row, Integer column) {
        borders.replace(row,column);
    }

    @Override
    protected boolean newValue(Integer row, Integer column) {
        Integer previousValue = borders.get(row);
        return isNew(column,previousValue);
    }

    protected abstract boolean isNew(Integer column, Integer previousValue);

    @Override
    protected boolean newKey(Integer row, Integer column) {
        return !borders.containsKey(row);
    }

    @Override
    protected Position makePosition(Integer key, Integer value) {
        return new ClassicPosition(key, value);
    }
}
