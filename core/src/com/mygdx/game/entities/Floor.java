package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.core.objects.PhysicsObject;
import com.mygdx.game.factory.PhysicsFactory;

public class Floor extends PhysicsObject {
    public Floor(World world, Texture texture, Vector2 position) {
        super(world, texture, position);
    }

    @Override
    protected void update(float delta) {

    }

    @Override
    protected void createFixture() {
        body = world.createBody(PhysicsFactory.createDef(BodyDef.BodyType.StaticBody,new Vector2(0,10)));
        PolygonShape floorShape = PhysicsFactory.createShape(new Vector2(1000,2));
        fixture = body.createFixture(floorShape,1);
        floorShape.dispose();
    }
}
