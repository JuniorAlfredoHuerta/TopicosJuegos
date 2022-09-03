package com.mygdx.game.GameObjects;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Figure {
    protected  int x;
    protected  int y;
    protected Color color = Color.WHITE;

    public Figure(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(ShapeRenderer shapeRenderer){
        shapeRenderer.setColor(color);
    }

    public  void update(){}

    protected boolean collideWith(Figure figure){
        return true;
    }

    public int getX(){
        return x;
    }

    public void setX(int x){
        this.x = x;
    }

    public int getY(){
        return y;
    }

    public void setY(int y){
        this.y = y;
    }
}
