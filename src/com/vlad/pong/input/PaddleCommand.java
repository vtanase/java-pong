package com.vlad.pong.input;

import com.vlad.pong.gameobjects.Paddle;

public interface PaddleCommand {

    void execute(Paddle paddle);
}