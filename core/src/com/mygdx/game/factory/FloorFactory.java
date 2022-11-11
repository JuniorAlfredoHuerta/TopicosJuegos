package com.mygdx.game.factory;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.entities.Floor;

public class FloorFactory extends BaseFactory{
    @Override
    public void addObject(World world, Texture texture, Vector2 position) {
        Floor floor = new Floor(world,null,null);
        objects.add(floor);
    }
}
