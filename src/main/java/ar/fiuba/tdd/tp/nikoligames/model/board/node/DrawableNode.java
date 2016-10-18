package ar.fiuba.tdd.tp.nikoligames.model.board.node;

/**
 * Da una interfaz para darle al exterior del modelo y este no pueda editar la celda.
 */
public interface DrawableNode {

    boolean isEmpty();

    boolean isEditable();

    String getValue();

}
