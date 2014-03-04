package com.vlad.pong;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import com.vlad.pong.gameobjects.Field;
import com.vlad.pong.gameobjects.Paddle;
import com.vlad.pong.geometry.Position;
import com.vlad.pong.geometry.Size;

public class Game extends BasicGame {


  private static final Size PADDLE_SIZE = new Size(150, 25);
  private Paddle topPaddle;
  private Paddle bottomPaddle;
  private Field field;

    public Game(String gamename) {
        super(gamename);
    }

    @Override
    public void render(GameContainer container, Graphics graphics) throws SlickException {
        // graphics.drawString("Hello world!", 10, 10);
        graphics.setColor(Color.white);
        field.draw(graphics);
        topPaddle.draw(graphics);
        bottomPaddle.draw(graphics);
    }

    @Override
    public void init(GameContainer container) throws SlickException {
        this.topPaddle = new Paddle(new Position(0, 5), PADDLE_SIZE);
        this.bottomPaddle = new Paddle(new Position(0, container.getHeight() - PADDLE_SIZE.getHeight() - 5), PADDLE_SIZE);
        this.field = new Field(new Size(container.getWidth(), container.getHeight()));
    }

    @Override
    public void update(GameContainer arg0, int arg1) throws SlickException {
    }

}
