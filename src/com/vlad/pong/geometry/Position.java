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

  public int getDeltaY() {
    return this.deltaY;
  }
}