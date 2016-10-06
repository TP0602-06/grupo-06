package ar.fiuba.tdd.tp.nikoligames.engine.model.board.cell;


/**
 * Cell contiene los aspectos generales de cualquier celda de cualquier juego.
 */
public class Cell extends AbstractCell {

    protected String value = "";

    protected boolean editable;

    public Cell(String value, boolean editable) {
        this.value = value;
        this.editable = editable;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isEmpty() {
        return (this.value.equals(""));
    }

    public boolean isEditable() {
        return editable;
    }


}
