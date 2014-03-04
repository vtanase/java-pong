package com.vlad.pong.input;

import com.vlad.pong.gameobjects.Paddle;

public class LeftPaddleCommand implements PaddleCommand {

    @Override
    public void execute(Paddle paddle) {
        paddle.moveLeft();
    }

}