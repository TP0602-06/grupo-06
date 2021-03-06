package ar.fiuba.tdd.tp.nikoligames.view.grids.inputgridview;

import ar.fiuba.tdd.tp.nikoligames.view.grids.GridView;

import java.util.HashSet;
import java.util.Set;


/**
 * Responsabilidades:
 * 1. Crear una abstracción para la encapsulación de la creación de una grilla para panel de ingreso de valores
 * Patrón:
 * 1. Abstract Factory
 */
public interface AbstractFactoryInputGrid {
    GridView createInputGridForBoardView(Set<String> validInputs);

}
