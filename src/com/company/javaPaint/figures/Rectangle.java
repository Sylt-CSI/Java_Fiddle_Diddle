package com.company.javaPaint.figures;

import java.awt.Graphics;

public class Rectangle extends Figure {

    @Override
    public void draw(Graphics g) {
        recalculatePositionWithOddNumbers();
        g.drawRect(
                this.getX1(),
                this.getY1(),
                Math.abs(this.getX2() - this.getX1()),
                Math.abs(this.getY2() - this.getY1())
        );
    }

}
