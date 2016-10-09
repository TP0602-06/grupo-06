package ar.fiuba.tdd.tp.nikoligames.view.graphics;

/**
 * Este enum es el encargado de obtener los escalados para dibujar.
 */
public enum LinePosition {
    TOP_LEFT(0, 0),
    TOP_RIGHT(1, 0),
    TOP_CENTER(0.5, 0.0),
    MIDDLE_LEFT(0.0, 0.5),
    MIDDLE_CENTER(0.5, 0.5),
    MIDDLE_RIGHT(1, 0.5),
    BOTTOM_LEFT(0, 1),
    BOTTOM_RIGHT(1, 1),
    BOTTOM_CENTER(0.5, 1);

    private double escalatorX;
    private double escalatorY;

    LinePosition(double startX, double startY) {
        this.escalatorX = startX;
        this.escalatorY = startY;
    }

    public double getWidth(double width) {
        return escalatorX * width;
    }

    public double getHeight(double height) {
        return escalatorY * height;
    }
}
