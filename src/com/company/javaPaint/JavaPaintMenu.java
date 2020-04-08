package com.company.javaPaint;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class JavaPaintMenu implements ActionListener {
    public JavaPaintMenu(JFrame jFrame) {
        JMenuBar javaPaintMenuBar = new JMenuBar();
        JMenuItem menuItem;
        generateFileMenuBarElement(javaPaintMenuBar);
        generateFiguresMenuBarElement(javaPaintMenuBar);


        // todo make it active on click
//        Color backgroundColor = JColorChooser.showDialog(jFrame,
//                "Choose background color", Color.white);


        jFrame.setJMenuBar(javaPaintMenuBar);
    }
    // todo transform it into a single function which is called with different parameters.
    private void generateFileMenuBarElement(JMenuBar menuBar) {
        //todo make it clickable
        String[] textLabelButtonArray = {"Save", "Clear", "Undo"};
        JMenu menu = new JMenu("File");
        menuBar.add(menu);
        for (String nameOfLabel : textLabelButtonArray
        ) {
            JMenuItem menuItem = new JMenuItem(nameOfLabel);
            menu.add(menuItem);
            menuItem.addActionListener(this);
            menuItem.setActionCommand(nameOfLabel);
        }
    }

    private void generateFiguresMenuBarElement(JMenuBar menuBar) {
        //todo make it clickable
        String[] textLabelButtonArray = {"Line", "Oval", "Rectangle"};
        JMenu menu = new JMenu("Figures");
        menuBar.add(menu);
        for (String nameOfLabel : textLabelButtonArray
        ) {
            JMenuItem menuItem = new JMenuItem(nameOfLabel);
            menu.add(menuItem);
        }

    }

    private void generateColorMenuBarElement() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
    }
}
