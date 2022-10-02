package com.mygdx.game.GameObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Brick extends Figure{
    public Brick(int x, int y, int width, int height,int xSpeed,int ySpeed) {
        super(x, y, width, height, xSpeed, ySpeed);
    }

    protected void update() {
        x += xSpeed;
        y += ySpeed;
        if(x < 0 || x > Gdx.graphics.getWidth()-width){
            xSpeed = -xSpeed;
        }
        if(y < 0 || y > Gdx.graphics.getHeight()-height){
            ySpeed = -ySpeed;
        }
    }

    protected void draw(ShapeRenderer shapeRenderer) {
        super.draw(shapeRenderer);
        shapeRenderer.rect(x,y,width,height);
    }
    public void render(ShapeRenderer shapeRenderer) {
        draw(shapeRenderer);
    }

    public void draw() {
        update();

    }

}
