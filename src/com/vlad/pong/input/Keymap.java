package com.vlad.pong.input;

import java.util.HashMap;
import java.util.Map;

public class Keymap {

    private Map<Integer, PaddleCommand> keyToCommand = new HashMap<Integer, PaddleCommand>();

    public Keymap(Map<Integer, PaddleCommand> keyToCommand) {
        this.keyToCommand = keyToCommand;
    }

    public boolean supports(int key) {
        return keyToCommand.containsKey(key);
    }

    public PaddleCommand toCommand(int key) {
        return keyToCommand.get(key);
    }
}