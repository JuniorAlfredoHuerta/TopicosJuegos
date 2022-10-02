package com.mygdx.game.Factory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.GameObjects.Ball;
import com.mygdx.game.GameObjects.Paddle;
import com.mygdx.game.Interface.IFactory;


import java.util.Random;

public class BallFactory implements IFactory {
    Ball ball;
    Random r = new Random();
    public BallFactory() {
        ball = new Ball(r.nextInt(Gdx.graphics.getWidth()),
                r.nextInt(Gdx.graphics.getHeight()),
                20,
                r.nextInt(15),
                r.nextInt(15));
    }

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public void collideWithPaddle(Paddle paddle) {
        if (ball.collideWith(paddle)) {
            ball.bounce();
        }
    }

    @Override
    public void render(ShapeRenderer renderer) {
        ball.draw();
        ball.render(renderer);
    }

    @Override
    public void destroy() {

    }
}
