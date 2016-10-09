package ar.fiuba.tdd.tp.nikoligames.view.graphics;

/**
 * Created by tobias on 09/10/16.
 */
public enum LinePosition {
    TOP_LEFT (0,0),
    TOP_RIGHT (1,0),
    TOP_CENTER (0.5,0.0),
    MIDDLE_LEFT (0.0,0.5),
    MIDDLE_CENTER (0.5,0.5),
    MIDDLE_RIGHT (1,0.5),
    BOTTOM_LEFT (0,1),
    BOTTOM_RIGHT (1,1),
    BOTTOM_CENTER (0.5,1);

    private double xEscalator;
    private double yEscalator;

    LinePosition(double startX, double startY) {
        this.xEscalator = startX;
        this.yEscalator = startY;
    }

    public double getXEscalator() {
        return xEscalator;
    }

    public double getYEscalator() {
        return yEscalator;
    }
}
