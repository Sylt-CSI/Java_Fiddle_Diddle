package com.company.javaPaint.figures;

import java.awt.*;

abstract public class Figure {

    private int x1, y1, x2, y2;
    private Color color = Color.BLACK;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public void recalculatePositionWithOddNumbers(){
        // Flip Y2 and Y1 axis.
        if (this.getY2() < this.getY1()){
            this.setY1(this.getY1() ^ this.getY2());
            this.setY2(this.getY1() ^ this.getY2());
            this.setY1(this.getY1() ^ this.getY2());
        }
        // etc.
        if (this.getX2() < this.getX1()){
            this.setX1(this.getX1() ^ this.getX2());
            this.setX2(this.getX1() ^ this.getX2());
            this.setX1(this.getX1() ^ this.getX2());
        }
    }

    abstract public void draw(Graphics g);
}
