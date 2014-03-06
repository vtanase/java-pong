package com.vlad.pong.gameobjects;

import com.vlad.pong.input.Keymap;
import com.vlad.pong.input.PaddleCommand;

public class Player {

    private Paddle paddle;
    private Keymap keymap;
    private Field field;

    public Player(Paddle paddle, Field field, Keymap keymap) {
        this.paddle = paddle;
        this.field = field;
        this.keymap = keymap;
    }

    public Keymap getKeymap() {
        return this.keymap;
    }

    public void update(int key) {
        if (this.getKeymap().supports(key)) {
            PaddleCommand command = this.getKeymap().toCommand(key);
            command.execute(this.paddle, this.field);
        }
    }

}