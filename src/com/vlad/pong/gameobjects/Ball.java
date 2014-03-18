package com.vlad.pong.gameobjects;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;

import com.vlad.pong.geometry.Direction;
import com.vlad.pong.geometry.Position;
import com.vlad.pong.geometry.Velocity;

public class Ball implements Drawable {

    public static final int RADIUS = 15;
    private Position position;
    private Velocity velocity;

    public Ball(Position position, Direction direction) {
        this.position = position;
        if (direction == Direction.UP) {
          this.velocity = new Velocity(2, -2);
        } else {
          this.velocity = new Velocity(2, 2);
        }
    }

    public void moveTo(Position position) {
        this.position = position;
    }

    @Override
    public void draw(Graphics graphics) {
        Circle ball = new Circle(position.getDeltaX(), position.getDeltaY(), RADIUS);
        graphics.fill(ball);
    }

    public Position getPosition() {
        return this.position;
    }

    public Velocity getVelocity() {
        return this.velocity;
    }

    public boolean hitsTop(Field field) {
        return false;
    }

    public boolean hitsBottom(Field field) {
        return false;
    }

    public boolean hitsPaddle(Paddle paddle) {
        int circleX = this.getPosition().getDeltaX();
        int circleBottomY = this.getPosition().getDeltaY() + RADIUS;
        int circleTopY = this.getPosition().getDeltaY() - RADIUS;

        int paddleLeft = paddle.getPosition().getDeltaX();
        int paddleRight = paddle.getPosition().getDeltaX() + ObjectSizes.PADDLE_SIZE.getWidth();
        int paddleBottom = paddle.getPosition().getDeltaY();
        int paddleTop = paddle.getPosition().getDeltaY() + ObjectSizes.PADDLE_SIZE.getHeight();

        if (circleX >= paddleLeft && circleX <= paddleRight) {
          if (circleBottomY >= paddleBottom && circleBottomY <= paddleTop) {
            return true;
          }
          if (circleTopY >= paddleBottom && circleTopY <= paddleTop) {
            return true;
          }
        }
        return false;
    }

    public boolean hitsSide(Field field) {
        int ballLeftEdge = this.position.getDeltaX() - RADIUS;
        int ballRightEdge = this.position.getDeltaX() + RADIUS;
        if (ballLeftEdge <= 0) {
            return true;
        }
        if (ballRightEdge >= field.getWidth()) {
            return true;
        }
        return false;
    }

    public void bounceVertically() {
        this.velocity.reverseOnY();
    }

    public void bounceHorizontally() {
        this.velocity.reverseOnX();
    }

}