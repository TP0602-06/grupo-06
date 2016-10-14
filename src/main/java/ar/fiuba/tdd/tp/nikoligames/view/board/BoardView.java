package ar.fiuba.tdd.tp.nikoligames.view.board;

import ar.fiuba.tdd.tp.nikoligames.view.edge.DrawableEdge;
import ar.fiuba.tdd.tp.nikoligames.view.grids.GridView;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.plaf.BorderUIResource;
import java.awt.*;
import java.util.Iterator;
import java.util.List;

/**
 * Created by tobias on 14/10/16.
 */
public class BoardView extends JPanel{

    private int backLayer = 1;
    private int frontLayer = 2;
    private GridView cellgrid;
    private JLayeredPane pane;

    public BoardView(){
        super();
        //setLayout(new BorderLayout());
        pane = new JLayeredPane();
        pane.setPreferredSize(new Dimension(300,300));
        add(pane);
        setBorder(new LineBorder(Color.GREEN));

    }
    public void addGrid(GridView gridLayer){

        pane.add(gridLayer);
        //pane.setLayer(gridLayer, backLayer);
        gridLayer.setBounds(0,0,300,300);
        cellgrid = gridLayer;
    }

    public void addDrawbleEdges(List<DrawableEdge> edges){
        Iterator listIterator = edges.iterator();
        while (listIterator.hasNext()){
            DrawableEdge edge = (DrawableEdge) listIterator.next();
            //setPosition(edge);
            pane.add(edge);
            pane.setLayer(edge,frontLayer);
        }
    }


}
