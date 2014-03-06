package com.vlad.pong.input;

import com.vlad.pong.gameobjects.Field;
import com.vlad.pong.gameobjects.Paddle;
import com.vlad.pong.geometry.Position;

public class LeftPaddleCommand implements PaddleCommand {

    @Override
    public void execute(Paddle paddle, Field field) {
      Position newPosition = paddle.getPosition().translateLeft();
      if (field.isValidPaddlePosition(newPosition)) {
        paddle.moveTo(newPosition);
      }
    }

}