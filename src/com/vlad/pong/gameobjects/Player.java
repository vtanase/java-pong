package com.vlad.pong.gameobjects;

import com.vlad.pong.input.Keymap;
import com.vlad.pong.input.PaddleCommand;

public class Player {

    private Paddle paddle;
    private Keymap keymap;

    public Player(Paddle paddle, Keymap keymap) {
        this.paddle = paddle;
        this.keymap = keymap;
    }

    public Paddle getPaddle() {
        return this.paddle;
    }

    public Keymap getKeymap() {
        return this.keymap;
    }

    public void update(int key) {
        if (this.getKeymap().supports(key)) {
            PaddleCommand command = this.getKeymap().toCommand(key);
            command.execute(this.getPaddle());
        }
    }

}