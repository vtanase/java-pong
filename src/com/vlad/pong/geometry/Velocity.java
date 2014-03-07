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
}