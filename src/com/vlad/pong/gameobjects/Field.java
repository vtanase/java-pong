package com.vlad.pong.gameobjects;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;

import com.vlad.pong.geometry.Position;
import com.vlad.pong.geometry.Size;

import static com.vlad.pong.gameobjects.ObjectSizes.PADDLE_SIZE;

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

    /**
     * Checks if a position is valid for the current playing field. Since the
     * game does not support vertical movement, only the X axis needs to be
     * checked.
     *
     * @param paddle
     *            the paddle for which we want to check the boundary.
     * @return true if the paddle is in bounds, false otherwise.
     */
    public boolean isValidPaddlePosition(Position position) {
        // check left
        int deltaX = position.getDeltaX();
        if (deltaX < 0) {
            return false;
        }
        // check right
        int fieldLeftBound = size.getWidth();
        int paddleWidth = PADDLE_SIZE.getWidth();
        if (deltaX > (fieldLeftBound - paddleWidth)) {
            return false;
        }
        return true;
    }

    public int getWidth() {
        return this.size.getWidth();
    }

    public int getHeight() {
        return this.size.getHeight();
    }

}