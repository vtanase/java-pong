package com.vlad.pong;

import java.util.HashMap;
import java.util.Map;
import java.util.Collections;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import com.vlad.pong.gameobjects.Field;
import com.vlad.pong.gameobjects.Paddle;
import com.vlad.pong.gameobjects.Player;
import com.vlad.pong.geometry.Position;
import com.vlad.pong.geometry.Size;
import com.vlad.pong.input.Keymap;
import com.vlad.pong.input.LeftPaddleCommand;
import com.vlad.pong.input.PaddleCommand;
import com.vlad.pong.input.PaddleKeyListener;
import com.vlad.pong.input.RightPaddleCommand;

import static com.vlad.pong.gameobjects.ObjectSizes.PADDLE_SIZE;

public class Game extends BasicGame {

    private static final Map<Integer, PaddleCommand> wasdMap;
    static {
        Map<Integer, PaddleCommand> temp = new HashMap<Integer, PaddleCommand>();
        temp.put(Input.KEY_A, new LeftPaddleCommand());
        temp.put(Input.KEY_D, new RightPaddleCommand());
        wasdMap = Collections.unmodifiableMap(temp);
    }

    private static final Map<Integer, PaddleCommand> arrowMap;
    static {
        Map<Integer, PaddleCommand> temp = new HashMap<Integer, PaddleCommand>();
        temp.put(Input.KEY_LEFT, new LeftPaddleCommand());
        temp.put(Input.KEY_RIGHT, new RightPaddleCommand());
        arrowMap = Collections.unmodifiableMap(temp);
    }

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
        this.bottomPaddle = new Paddle(new Position(0, container.getHeight() - PADDLE_SIZE.getHeight() - 5),
                PADDLE_SIZE);
        this.field = new Field(new Size(container.getWidth(), container.getHeight()));
        container.getInput().enableKeyRepeat();
        Player player1 = new Player(bottomPaddle, field, new Keymap(arrowMap));
        Player player2 = new Player(topPaddle, field, new Keymap(wasdMap));
        container.getInput().addKeyListener(new PaddleKeyListener(player1, player2));
    }

    @Override
    public void update(GameContainer arg0, int arg1) throws SlickException {
    }

}
