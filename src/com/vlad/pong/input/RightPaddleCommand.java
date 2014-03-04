package com.vlad.pong.input;

import com.vlad.pong.gameobjects.Paddle;

public class RightPaddleCommand implements PaddleCommand {

    @Override
    public void execute(Paddle paddle) {
        paddle.moveRight();
    }

}