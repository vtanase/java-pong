package com.vlad.pong;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.ShapeFill;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;

import sun.java2d.pipe.SolidTextRenderer;

public class Game extends BasicGame {
    
    private static final int PADDLE_HEIGHT = 25;

    public Game(String gamename) {
        super(gamename);
    }

    @Override
    public void render(GameContainer container, Graphics graphics) throws SlickException {
//        graphics.drawString("Hello world!", 10, 10);
        graphics.setColor(Color.white);
        Rectangle middleLine = new Rectangle(0, container.getHeight()/2, container.getWidth(), 1);
        graphics.fill(middleLine);
        Circle middleCircle = new Circle(container.getWidth()/2, container.getHeight()/2, 100);
        graphics.draw(middleCircle);
        Rectangle topPaddle = new Rectangle(0, 5, 150, PADDLE_HEIGHT);
        Rectangle bottomPaddle = new Rectangle(0, container.getHeight()-PADDLE_HEIGHT - 5, 150, PADDLE_HEIGHT);
        graphics.fill(topPaddle);
        graphics.fill(bottomPaddle);

    }

    @Override
    public void init(GameContainer arg0) throws SlickException {
    }

    @Override
    public void update(GameContainer arg0, int arg1) throws SlickException {
    }

}
