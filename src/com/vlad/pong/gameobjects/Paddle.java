package com.vlad.pong.gameobjects;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

import com.vlad.pong.geometry.Position;
import com.vlad.pong.geometry.Size;

public class Paddle implements Drawable {

    private Position position;
    private Size size;

    public Paddle(Position position, Size size) {
        this.position = position;
        this.size = size;
    }

    public Position getPosition() {
        return this.position;
    }

    public Size getSize() {
        return this.size;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.fill(new Rectangle(position.getDeltaX(), position.getDeltaY(), size.getWidth(), size.getHeight()));
    }

    public void moveLeft() {
        int oldPosition = this.getPosition().getDeltaX();
        this.getPosition().setDeltaX(oldPosition - 5);
    }

    public void moveRight() {
        int oldPosition = this.getPosition().getDeltaX();
        this.getPosition().setDeltaX(oldPosition + 5);
    }
}