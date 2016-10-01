package ar.fiuba.tdd.tp.nikoligames.engine.model.board.cell;


/**
 * Cell contiene los aspectos generales de cualquier celda de cualquier juego.
 */
public class Cell implements DrawableCell {

    protected String value = "";

    protected boolean editable;
    protected boolean readOnly;

    public Cell(String value, boolean editable, boolean readOnly) {
        this.value = value;
        this.editable = editable;
        this.readOnly = readOnly;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean isEmpty() {
        return (this.value.equals(""));
    }

    @Override
    public boolean isEditable() {
        return editable;
    }

    @Override
    public boolean isReadOnly() {
        return readOnly;
    }

}
