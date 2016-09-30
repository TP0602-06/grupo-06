package ar.fiuba.tdd.tp.nikoligames.engine.model.board.cell;

/**
 * Da una interfaz para darle al exterior del modelo y este no pueda editar la celda.
 */
public interface DrawableCell {

    boolean isEmpty();

    boolean isEditable();

    boolean isReadOnly();

    String getValue();

}
