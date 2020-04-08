package com.company.javaPaint;

import com.company.javaPaint.figures.Figure;
import com.company.javaPaint.figures.Line;
import com.company.javaPaint.figures.Oval;
import com.company.javaPaint.figures.Rectangle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class PaintEnvironment extends JFrame implements MouseListener {
    // todo make it changable to another figure.
    Figure figure = new Rectangle();
    ArrayList<Figure> arrayListOfDrawnFigures = new ArrayList<Figure>();


    public PaintEnvironment() {
        addMouseListener(this);
        JavaPaintMenu javaPaintMenu = new JavaPaintMenu(this);
        this.setSize(400, 400);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


    @Override
    public void paint(Graphics g){
        super.paint(g);
        for (Figure singleFigure : arrayListOfDrawnFigures)
            singleFigure.draw(g);
    }

    public static void main(String[] args) {
        PaintEnvironment paintEnvironment = new PaintEnvironment();
    }

    //todo couple it to its button.
    private void clearDrawing(){
        arrayListOfDrawnFigures.clear();
    }

    //todo couple it to its button.
    private void undoLastDrawing(){
        arrayListOfDrawnFigures.remove(arrayListOfDrawnFigures.size()-1);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        figure = new Line();
        figure.setX1(e.getX());
        figure.setY1(e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        figure.setX2(e.getX());
        figure.setY2(e.getY());
        arrayListOfDrawnFigures.add(figure);
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
