package com.vlad.pong;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Game extends BasicGame {
    
    public Game(String gamename) {
        super(gamename);
    }

    @Override
    public void render(GameContainer container, Graphics graphics) throws SlickException {
        graphics.drawString("Hello world!", 10, 10);
    }

    @Override
    public void init(GameContainer arg0) throws SlickException {
    }

    @Override
    public void update(GameContainer arg0, int arg1) throws SlickException {
    }

}
