package ar.fiuba.tdd.tp.nikoligames.view.parentview;

import java.awt.*;
import javax.swing.*;


/**
 * Responsabilidades:
 * 1. Crear la ventana que contendrá a los componentes del juego
 * Justificación de herencia: El paquete Swing se suele trabajar de esta forma
 */
public class GameView extends JFrame {

    public GameView(String title, Integer sizeX, Integer sizeY) {
        super(title);
        setSize(sizeX, sizeY);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new FlowLayout());
    }




}
