package com.vlad.pong;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Main {

    public static void main(String[] args) {
        try {
            AppGameContainer gameContainer = new AppGameContainer(new Game("Hi there!"));
            gameContainer.setDisplayMode(640, 480, false);
            gameContainer.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
        
    }
}
