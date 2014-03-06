/**
 *
 */
package com.vlad.pong.geometry;

public class Position {

    private int deltaX = 0;
    private int deltaY = 0;

    public Position(int deltaX, int deltaY) {
        this.deltaX = deltaX;
        this.deltaY = deltaY;
    }

    public int getDeltaX() {
        return this.deltaX;
    }

    public void setDeltaX(int deltaX) {
        this.deltaX = deltaX;
    }

    public int getDeltaY() {
        return this.deltaY;
    }

    public void setDeltaY(int deltaY) {
        this.deltaY = deltaY;
    }

    public Position translateLeft() {
        Position result = new Position(this.deltaX - 5, deltaY);
        return result;
    }

    public Position translateRight() {
        Position result = new Position(this.deltaX + 5, deltaY);
        return result;
    }
}