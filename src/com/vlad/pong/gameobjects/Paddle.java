package com.vlad.pong.gameobjects;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

import com.vlad.pong.geometry.Position;
import com.vlad.pong.geometry.Size;

/**
 * Class representing the paddle used by a player in the game.
 */
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

    /**
     * Moves the paddle to the specified position.
     */
    public void moveTo(Position position) {
        this.position = position;
    }

    public Position ballOnTop() {
        int ballX = this.position.getDeltaX() + this.size.getWidth() / 2;
        int ballY = this.position.getDeltaY() - Ball.RADIUS;
        return new Position(ballX, ballY);
    }

    public Position ballOnBottom() {
        int ballX = this.position.getDeltaX() + this.size.getWidth() / 2;
        int ballY = this.position.getDeltaY() + this.size.getHeight() + Ball.RADIUS;
        return new Position(ballX, ballY);
    }

}