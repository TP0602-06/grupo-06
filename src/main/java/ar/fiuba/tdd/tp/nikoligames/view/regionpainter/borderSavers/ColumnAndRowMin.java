package ar.fiuba.tdd.tp.nikoligames.view.regionpainter.borderSavers;

/**
 * Created by tobias on 19/10/16.
 */
public class ColumnAndRowMin extends ColumnFixedRowVariableBorder {
    @Override
    protected boolean isNew(Integer row, Integer previousValue) {
        return row < previousValue;
    }
}
