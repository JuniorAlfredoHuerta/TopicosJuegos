package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.Factory.BallFactory;
import com.mygdx.game.Factory.BrickFactory;
import com.mygdx.game.Factory.BrickVolteado;
import com.mygdx.game.Factory.PaddleFactory;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MyGdxGame extends ApplicationAdapter {
    ShapeRenderer shapeRenderer;
    PaddleFactory paddleFactory;
    BrickFactory brickFactory;
    BrickVolteado columanFactory;
    int elementos;
    int columnas;

    @Override
    public void create() {

        paddleFactory = new PaddleFactory();
        shapeRenderer = new ShapeRenderer();
        brickFactory = new BrickFactory();
        columanFactory = new BrickVolteado();
        InitGame();
    }

    private void InitGame(){
        Scanner capt = new Scanner(System.in);
        System.out.println("Numero de elementos");
        int elementos = capt.nextInt();
        System.out.println("Numero de columnas");
        int columnas = capt.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <elementos-columnas;i++){
            list.add(0);
        }

        for (int i = 0; i <columnas;i++){
            list.add(1);
        }
        Collections.shuffle(list);
        //System.out.println(list);
        int y =  0;
        int index = -1;
        for (int i = 0; i < elementos; i++) {
            index++;
            if(index % 11 == 0){
                y += 65;
                index = 0;
            }
            if ( list.get(i) == 0){
                //System.out.println(i);
                brickFactory.build(index,y);


            }
            else{
                columanFactory.build(index,y);



            }
            }
        }
    
    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        paddleFactory.render(shapeRenderer);
        columanFactory.render(shapeRenderer);
        brickFactory.render(shapeRenderer);
		shapeRenderer.end();
        update();
    }

    private void update(){
        paddleFactory.update(Gdx.input.getX());

    }

    @Override
    public void dispose() {

    }
}
