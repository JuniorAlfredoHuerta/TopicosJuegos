package com.mygdx.game.GameObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.Interface.IFigure;

public class Ballas extends Figure  implements IFigure {

    public Ballas(int x, int y, int size, int xSpeed, int ySpeed) {
        super(x,y,size,xSpeed,ySpeed);
        color = Color.GREEN;
    }

    @Override
    protected Rectangle getArea() {
        return new Rectangle(this.x,this.y,this.size * 2,this.size*2);
    }

    protected void draw(ShapeRenderer shapeRenderer) {
        super.draw(shapeRenderer);
        shapeRenderer.circle(x,y,size);
    }

    protected void update() {
        x += xSpeed;
        y += ySpeed;
        if (x < 0 || x > Gdx.graphics.getWidth()) {
            xSpeed = -xSpeed;
        }
        if (y < 0 || y > Gdx.graphics.getHeight()) {
            ySpeed = -ySpeed;
        }
    }

    @Override
    public void render(ShapeRenderer shapeRenderer) {
        draw(shapeRenderer);
    }

    @Override
    public void draw() {
        update();
    }
}
