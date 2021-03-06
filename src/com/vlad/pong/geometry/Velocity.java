package com.vlad.pong.geometry;

public class Velocity {

    private int onX;
    private int onY;

    public Velocity(int onX, int onY) {
        this.onX = onX;
        this.onY = onY;
    }

    public int onX() {
        return this.onX;
    }

    public int onY() {
        return this.onY;
    }

    public void reverseOnY() {
        this.onY *= -1;
    }

    public void reverseOnX() {
        this.onX *= -1;
    }
}