package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.Factory.BallasFactory;
import com.mygdx.game.Factory.BrickFactory;

public class MyGdxGame extends ApplicationAdapter {
    ShapeRenderer shapeRenderer;
    BrickFactory brickFactory;
    BallasFactory ballasFactory;

    @Override
    public void create() {

        shapeRenderer = new ShapeRenderer();
        brickFactory = new BrickFactory();
        ballasFactory = new BallasFactory();
        InitGame();
    }

    private void InitGame(){
        int y =  0;
        int index = -1;
        for (int i = 0; i < 50; i++) {
            index++;
            if(index % 11 == 0){
                y += 65;
                index = 0;
            }
            if ( i % 2 == 0){
                //System.out.println(i % 2 );
                ballasFactory.build(index,y);


            }
            else{
                brickFactory.build(index,y);


            }
            }
        }
    
    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        brickFactory.render(shapeRenderer);
        ballasFactory.render(shapeRenderer);
		shapeRenderer.end();
        update();
    }

    private void update(){
    }

    @Override
    public void dispose() {

    }
}
