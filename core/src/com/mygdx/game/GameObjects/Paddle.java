package com.mygdx.game.GameObjects;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Paddle {
    int x;
    int y;
    int height;
    int width;


    public Paddle(int x, int y, int height, int width) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }

    public void draw(ShapeRenderer shapeRenderer){
        shapeRenderer.rect(x , y ,height, width);
    }
}
