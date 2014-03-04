package com.vlad.pong.input;

import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;

import com.vlad.pong.gameobjects.Player;

public class PaddleKeyListener implements KeyListener {

    private Player[] players;

    public PaddleKeyListener(Player... players) {
        this.players = players;
    }

    @Override
    public void inputEnded() {
    }

    @Override
    public void inputStarted() {
    }

    @Override
    public boolean isAcceptingInput() {
        return true;
    }

    @Override
    public void setInput(Input arg0) {
    }

    @Override
    public void keyPressed(int key, char arg1) {
        for (int i = 0; i < players.length; ++i) {
            players[i].update(key);
        }
    }

    @Override
    public void keyReleased(int arg0, char arg1) {
    }

}