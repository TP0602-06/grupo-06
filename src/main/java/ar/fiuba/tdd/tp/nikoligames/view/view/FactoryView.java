package ar.fiuba.tdd.tp.nikoligames.view.view;

/**
 * Created by german on 9/25/2016.
 */
public class FactoryView implements AbstractFactoryView {
    private static String DEFAULT_TITLE = "Nikolio games";
    private static int DEFAULT_WIDTH = 600;
    private static int DEFAULT_HEIGHT = 800;

    @Override
    public View createDefaultWindow() {
        View view = new View(DEFAULT_TITLE, DEFAULT_WIDTH, DEFAULT_HEIGHT);

        return view;
    }
}
