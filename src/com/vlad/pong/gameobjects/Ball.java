package com.vlad.pong.gameobjects;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;

import com.vlad.pong.geometry.Position;
import com.vlad.pong.geometry.Velocity;

public class Ball implements Drawable {

    private Position position;
    private Velocity velocity;

    public Ball(Position position) {
        this.position = position;
        this.velocity = new Velocity(2, 2);
    }

    public void updatePosition() {
        int newDeltaX = this.position.getDeltaX() + velocity.onX();
        int newDeltaY = this.position.getDeltaY() + velocity.onY();
        this.position = new Position(newDeltaX, newDeltaY);
    }

    @Override
    public void draw(Graphics graphics) {
        Circle ball = new Circle(position.getDeltaX(), position.getDeltaY(), 15);
        graphics.fill(ball);
    }

}