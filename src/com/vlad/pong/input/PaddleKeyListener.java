package com.vlad.pong.input;

import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;

import com.vlad.pong.Game;
import com.vlad.pong.gameobjects.Player;

public class PaddleKeyListener implements KeyListener {

    private Player[] players;
    private Game game;

    public PaddleKeyListener(Game game, Player... players) {
        this.game = game;
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
        if (key == Input.KEY_ESCAPE) {
            game.shutdown();
        }
        for (int i = 0; i < players.length; ++i) {
            players[i].update(key);
        }
    }

    @Override
    public void keyReleased(int arg0, char arg1) {
    }

}