package com.vlad.pong;

import static com.vlad.pong.gameobjects.ObjectSizes.PADDLE_SIZE;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import com.vlad.pong.gameobjects.Ball;
import com.vlad.pong.gameobjects.Field;
import com.vlad.pong.gameobjects.Paddle;
import com.vlad.pong.gameobjects.Player;
import com.vlad.pong.geometry.Direction;
import com.vlad.pong.geometry.Position;
import com.vlad.pong.geometry.Size;
import com.vlad.pong.input.Keymap;
import com.vlad.pong.input.LeftPaddleCommand;
import com.vlad.pong.input.PaddleCommand;
import com.vlad.pong.input.PaddleKeyListener;
import com.vlad.pong.input.RightPaddleCommand;

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
    private Ball ball;
    private boolean shutdown = false;

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
        ball.draw(graphics);
    }

    @Override
    public void init(GameContainer container) throws SlickException {
        // set the FPS
        container.setTargetFrameRate(120);
        // allow the player to hold down a key
        container.getInput().enableKeyRepeat();

        this.topPaddle = new Paddle(new Position(0, 5), PADDLE_SIZE);
        this.bottomPaddle = new Paddle(new Position(0, container.getHeight() - PADDLE_SIZE.getHeight() - 5),
                PADDLE_SIZE);
        this.field = new Field(new Size(container.getWidth(), container.getHeight()));
        Player player1 = new Player(bottomPaddle, field, new Keymap(arrowMap));
        Player player2 = new Player(topPaddle, field, new Keymap(wasdMap));
        container.getInput().addKeyListener(new PaddleKeyListener(this, player1, player2));
        //        this.ball = new Ball(new Position(container.getWidth() / 2, container.getHeight() / 2));
        this.ball = new Ball(bottomPaddle.ballOnTop(), Direction.UP);
    }

    @Override
    public void update(GameContainer container, int arg1) throws SlickException {
        if (this.shutdown) {
            container.exit();
        }
        Position newBallPosition = ball.getPosition().translate(ball.getVelocity());
        ball.moveTo(newBallPosition);
        if (ball.hitsBottom(field)) {
          // score 1 for player 2
            this.ball = new Ball(bottomPaddle.ballOnTop(), Direction.UP);
        }
        if (ball.hitsTop(field)) {
          // score 1 for player 1
            this.ball = new Ball(topPaddle.ballOnBottom(), Direction.DOWN);
        }
        if (ball.hitsPaddle(bottomPaddle) || ball.hitsPaddle(topPaddle)) {
          ball.bounceVertically();
        }
        if (ball.hitsSide(field)) {
          ball.bounceHorizontally();
        }
    }
    
    public void shutdown() {
        this.shutdown = true;
    }

}
