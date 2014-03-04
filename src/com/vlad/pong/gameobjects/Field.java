package com.vlad.pong.gameobjects;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;

import com.vlad.pong.geometry.Size;

public class Field implements Drawable {

    private Size size;

    public Field(Size size) {
        this.size = size;
    }

    @Override
    public void draw(Graphics graphics) {
        Rectangle middleLine = new Rectangle(0, size.getHeight() / 2, size.getWidth(), 1);
        graphics.fill(middleLine);
        Circle middleCircle = new Circle(size.getWidth() / 2, size.getHeight() / 2, 100);
        graphics.draw(middleCircle);
    }

}