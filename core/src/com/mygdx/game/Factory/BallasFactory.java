package com.mygdx.game.Factory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.GameObjects.Ball;
import com.mygdx.game.GameObjects.Ballas;
import com.mygdx.game.GameObjects.Brick;
import com.mygdx.game.Interface.IFactory;

import java.util.ArrayList;

public class BallasFactory implements IFactory {

    ArrayList<Ballas> ballass;

    public BallasFactory(){
        ballass = new ArrayList<>();
    }

    public void build(int index,int y){
        Ballas ballas = new Ballas(0,0,15,20,20);
        //Brick brick = new Brick(0, 0,20,20);
        int x = index * (ballas.getSize()+40);
        ballas.setY(Gdx.graphics.getHeight()- ballas.getSize()-y);
        ballas.setX(x);
        ballass.add(ballas);
    }
    @Override
    public void render(ShapeRenderer renderer) {
        for (Ballas ballas: ballass){
            ballas.draw();
            ballas.render(renderer);
        }

    }


    @Override
    public void destroy() {

    }
}
