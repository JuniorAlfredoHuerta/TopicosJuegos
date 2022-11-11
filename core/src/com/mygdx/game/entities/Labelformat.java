package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;


public class Labelformat extends Label {

    public Labelformat(String text, LabelStyle style, Vector2 position){
        super(text,style);
        setPosition(position.x,position.y);
    }
}
