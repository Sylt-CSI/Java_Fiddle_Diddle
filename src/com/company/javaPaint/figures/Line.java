package com.company.javaPaint.figures;

import java.awt.*;

public class Line extends Figure {

    @Override
    public void draw(Graphics g) {
        g.drawLine(
                this.getX1(),
                this.getY1(),
                this.getX2(),
                this.getY2()
        );
    }
}
