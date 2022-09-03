package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.GameObjects.Ball;

import java.util.ArrayList;
import java.util.Random;

public class MyGdxGame extends ApplicationAdapter {
	ArrayList<Ball> balls = new ArrayList<>();
	Random r = new Random();
	ShapeRenderer shapeRenderer;
	@Override
	public void create () {
		shapeRenderer = new ShapeRenderer();
		for ( int i = 0; i < 10; i++){
			balls.add( new Ball(r.nextInt(Gdx.graphics.getWidth()),
					r.nextInt(Gdx.graphics.getHeight()),
					r.nextInt(100),
					r.nextInt(15),
					r.nextInt(15)));
		}
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		/*Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		ball.update();*/
		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		for (Ball ball: balls){
			ball.update();
			ball.draw(shapeRenderer);
		}
		shapeRenderer.end();
	}
	
	@Override
	public void dispose () {


	}
}
