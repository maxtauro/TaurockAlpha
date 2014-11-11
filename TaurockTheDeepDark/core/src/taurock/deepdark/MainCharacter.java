package taurock.deepdark;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


/**
 * Created by Matthew Brock on 27/10/2014.
 */

//https://github.com/libgdx/libgdx/wiki/2D-Animation
public class MainCharacter implements ApplicationListener {



    static int nCharacterRotation = 1;
    static int  nSHeight, nSWidth;
    Animation[] araWalking;
    Texture tDownSheet, tUpSheet, tLeftSheet, tRightSheet, tStandDown, tStandUp, tStandLeft, tStandRight;
    SpriteBatch sbSpriteBatch;
    float stateTime;

    @Override
    public void create() {
        nSHeight = Gdx.graphics.getHeight();
        nSWidth = Gdx.graphics.getWidth();
        araWalking = new Animation[8];
        sbSpriteBatch = new SpriteBatch();
        tStandDown = new Texture(Gdx.files.internal("BadLuckStandDown.png"));
        tStandLeft = new Texture(Gdx.files.internal("BadLuckStandLeft.png"));
        tStandRight = new Texture(Gdx.files.internal("BadLuckStandRight.png"));
        tStandUp = new Texture(Gdx.files.internal("BadLuckStandUp.png"));
        tDownSheet = new Texture(Gdx.files.internal("BadLuckDown.png"));
        tUpSheet = new Texture(Gdx.files.internal("BadLuckUp.png"));
        tLeftSheet = new Texture(Gdx.files.internal("BadLuckLeft.png"));
        tRightSheet = new Texture(Gdx.files.internal("BadLuckRight.png"));

        araWalking[0] = BuildAnimation.build(tStandUp, 1, 1);
        araWalking[1] = BuildAnimation.build(tStandDown, 1, 1);
        araWalking[2] = BuildAnimation.build(tStandLeft, 1, 1);
        araWalking[3] = BuildAnimation.build(tStandRight, 1, 1);
        araWalking[4] = BuildAnimation.build(tUpSheet, 1, 3);
        araWalking[5] = BuildAnimation.build(tDownSheet, 1, 3);
        araWalking[6] = BuildAnimation.build(tLeftSheet, 1, 3);
        araWalking[7] = BuildAnimation.build(tRightSheet, 1, 3);

        stateTime = 0f;
    }

    @Override
    public void resize(int width, int height) {

    }

    public static void setCharacterRotation(int nRotation) {
        nCharacterRotation = nRotation;
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        Gdx.gl.glClearColor(1, 1, 1, 1);
        stateTime += Gdx.graphics.getDeltaTime();
        sbSpriteBatch.begin();
        sbSpriteBatch.draw(araWalking[nCharacterRotation].getKeyFrame(stateTime, true), nSWidth / 2, nSHeight / 2, nSWidth * 110 / 1794, nSHeight * 120 /1080);
        sbSpriteBatch.end();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}

