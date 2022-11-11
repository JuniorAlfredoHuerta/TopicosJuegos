package com.mygdx.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.core.screens.PhysicsScreen;
import com.mygdx.game.entities.CustomButton;
import com.mygdx.game.entities.Player;
import com.mygdx.game.factory.FloorFactory;
import com.mygdx.game.factory.SpikeFactory;
import com.mygdx.game.helpers.AssetsManager;

public class GameScreen extends PhysicsScreen {

    private Player player;
    private FloorFactory floorFactory;
    private SpikeFactory spikeFactory;
    private Music music;
    private Sound die;
    private Sound jump;
    private CustomButton botonperdiste;

    @Override
    protected void init() {
        requiredProcessor = true;
        music = AssetsManager.getAssetManager().get("audio/song.ogg");
        //music.play();
        jump = AssetsManager.getAssetManager().get("audio/jump.ogg");
        die = AssetsManager.getAssetManager().get("audio/die.ogg");
        //jump.play();
        die.play();
        this.debugging = true;
        this.gravity = new Vector2(0,-10);
        super.init();
        Gdx.app.log("SCREEN","GAME PHYSICS");
        Texture playerTexture = AssetsManager.getAssetManager().get("player.png");
        player = new Player(world,playerTexture,new Vector2(1,2));
        stage.addActor(player);

        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.font = new BitmapFont();
        style.fontColor = Color.GOLD;
        style.overFontColor = Color.GREEN;
        style.downFontColor = Color.RED;
        botonperdiste = new CustomButton("Presiona si perdiste",style,new Vector2(200,200),new Vector2(200,80),new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                MyGdxGame.instance.setScreen(new GameOverScreen());
            }
        });
        addActor(botonperdiste);



        /*floorFactory = new FloorFactory();
        floorFactory.addObject(world,null,null);
        spikeFactory = new SpikeFactory();
        spikeFactory.addObject(world,null,null);
        world.setContactListener(new ContactListener() {
            @Override
            public void beginContact(Contact contact) {

            }

            @Override
            public void endContact(Contact contact) {

            }

            @Override
            public void preSolve(Contact contact, Manifold oldManifold) {

            }

            @Override
            public void postSolve(Contact contact, ContactImpulse impulse) {

            }
        });*/
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        if(Gdx.input.isTouched()){
            player.jump();
        }
    }

    @Override
    protected void draw(float delta) {

    }


    @Override
    public void dispose() {
        super.dispose();
        stage.dispose();
        player.destroy();
        world.dispose();
    }
}
