package com.tauro.brock.android;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

/**
 * Created by Matthew Brock on 30/10/2014.
 */
//http://stackoverflow.com/questions/21488311/libgdx-how-to-create-a-button
public class MakeButtons extends Game {
    Stage stage;
    BitmapFont font;

    private TextButton tbUpButton, tbDownButton, tbLeftButton, tbRightButton;
    private TextButton.TextButtonStyle tbsUpButton, tbsDownButton, tbsLeftButton, tbsRightButton;
    private Skin sUpButton, sDownButton, sLeftButton, sRightButton;
    private TextureAtlas taUpButton, taDownButton, taLeftButton, taRightButton;

    @Override
    public void create() {
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        font = new BitmapFont();

        sUpButton = new Skin();
        taUpButton = new TextureAtlas(Gdx.files.internal("UpButton.pack"));
        sUpButton.addRegions(taUpButton);
        tbsUpButton = new TextButton.TextButtonStyle();
        tbsUpButton.font = font;
        tbsUpButton.up = sUpButton.getDrawable("ArrowUp");
        tbsUpButton.down = sUpButton.getDrawable("PressedArrowUp");
        tbsUpButton.checked = sUpButton.getDrawable("ArrowUp");
        tbUpButton = new TextButton("", tbsUpButton);
        tbUpButton.setSize(200, 200);
        tbUpButton.setPosition(200, 400);
        tbUpButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                MainCharacter.setCharacterRotation(0);
            }
        });
        stage.addActor(tbUpButton);

        sDownButton = new Skin();
        taDownButton = new TextureAtlas(Gdx.files.internal("DownButton.pack"));
        sDownButton.addRegions(taDownButton);
        tbsDownButton = new TextButton.TextButtonStyle();
        tbsDownButton.font = font;
        tbsDownButton.up = sDownButton.getDrawable("ArrowDown");
        tbsDownButton.down = sDownButton.getDrawable("PressedArrowDown");
        tbsDownButton.checked = sDownButton.getDrawable("ArrowDown");
        tbDownButton = new TextButton("", tbsDownButton);
        tbDownButton.setSize(200, 200);
        tbDownButton.setPosition(200, 0);
        tbDownButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                MainCharacter.setCharacterRotation(1);
            }
        });
        stage.addActor(tbDownButton);

        sLeftButton = new Skin();
        taLeftButton = new TextureAtlas(Gdx.files.internal("LeftButton.pack"));
        sLeftButton.addRegions(taLeftButton);
        tbsLeftButton = new TextButton.TextButtonStyle();
        tbsLeftButton.font = font;
        tbsLeftButton.up = sLeftButton.getDrawable("ArrowLeft");
        tbsLeftButton.down = sLeftButton.getDrawable("PressedArrowLeft");
        tbsLeftButton.checked = sLeftButton.getDrawable("ArrowLeft");
        tbLeftButton = new TextButton("", tbsLeftButton);
        tbLeftButton.setSize(200, 200);
        tbLeftButton.setPosition(0, 200);
        tbLeftButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                MainCharacter.setCharacterRotation(2);
            }
        });
        stage.addActor(tbLeftButton);

        sRightButton = new Skin();
        taRightButton = new TextureAtlas(Gdx.files.internal("RightButton.pack"));
        sRightButton.addRegions(taRightButton);
        tbsRightButton = new TextButton.TextButtonStyle();
        tbsRightButton.font = font;
        tbsRightButton.up = sRightButton.getDrawable("ArrowRight");
        tbsRightButton.down = sRightButton.getDrawable("PressedArrowRight");
        tbsRightButton.checked = sRightButton.getDrawable("ArrowRight");
        tbRightButton = new TextButton("", tbsRightButton);
        tbRightButton.setSize(200, 200);
        tbRightButton.setPosition(400, 200);
        tbRightButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                MainCharacter.setCharacterRotation(3);
            }
        });
        stage.addActor(tbRightButton);


    }

    @Override
    public void render() {
        //  Gdx.gl.glClearColor(1, 1, 1, 1);
        //Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        super.render();
        stage.draw();

    }

}
