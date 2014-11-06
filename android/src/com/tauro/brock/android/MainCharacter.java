package com.tauro.brock.android;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by Matthew Brock on 27/10/2014.
 */

//https://github.com/libgdx/libgdx/wiki/2D-Animation
public class MainCharacter implements ApplicationListener {

    private static final int FRAME_COLS = 2;
    private static final int FRAME_ROWS = 1;
    static int nCharacterRotation;
    static int nCount1=0,nCount2=0,nCount3=0,nCount4=0;

    Animation aWalkingDown,aWalkingUp,aWalkingLeft,aWalkingRight;
    Texture tDownSheet,tUpSheet,tLeftSheet,tRightSheet;
    TextureRegion[] trDownWalkFrames,trUpWalkFrames,trLeftWalkFrames,trRightWalkFrames;
    SpriteBatch sbSpriteBatch;
    TextureRegion currentFrame;

    float stateTime;
    @Override
    public void create() {
        tDownSheet = new Texture(Gdx.files.internal("WalkDown.png"));
        tUpSheet = new Texture(Gdx.files.internal("WalkUp.png"));
        tLeftSheet = new Texture(Gdx.files.internal("WalkLeft.png"));
        tRightSheet = new Texture(Gdx.files.internal("WalkRight.png"));
        TextureRegion[][] tmpDown = TextureRegion.split(tDownSheet, tDownSheet.getWidth() / FRAME_COLS, tDownSheet.getHeight() / FRAME_ROWS);
        TextureRegion[][] tmpUp = TextureRegion.split(tUpSheet, tUpSheet.getWidth() / FRAME_COLS, tUpSheet.getHeight() / FRAME_ROWS);
        TextureRegion[][] tmpLeft = TextureRegion.split(tLeftSheet, tLeftSheet.getWidth() / FRAME_COLS, tLeftSheet.getHeight() / FRAME_ROWS);
        TextureRegion[][] tmpRight = TextureRegion.split(tRightSheet, tRightSheet.getWidth() / FRAME_COLS, tRightSheet.getHeight() / FRAME_ROWS);
        trDownWalkFrames = new TextureRegion[FRAME_COLS * FRAME_ROWS];
        trUpWalkFrames = new TextureRegion[FRAME_COLS * FRAME_ROWS];
        trLeftWalkFrames = new TextureRegion[FRAME_COLS * FRAME_ROWS];
        trRightWalkFrames = new TextureRegion[FRAME_COLS * FRAME_ROWS];
        int index = 0;
        for (int i = 0; i < FRAME_ROWS; i++) {
            for (int j = 0; j < FRAME_COLS; j++) {
                trDownWalkFrames[nCount1++] = tmpDown[i][j];
                trUpWalkFrames[nCount2++] = tmpUp[i][j];
                trLeftWalkFrames[nCount3++] = tmpLeft[i][j];
                trRightWalkFrames[nCount4++] = tmpRight[i][j];

            }
        }
        aWalkingDown = new Animation(0.3f, trDownWalkFrames);
        aWalkingUp = new Animation(0.3f, trUpWalkFrames);
        aWalkingLeft = new Animation(0.3f, trLeftWalkFrames);
        aWalkingRight = new Animation(0.3f, trRightWalkFrames);
        sbSpriteBatch = new SpriteBatch();
        stateTime = 0f;
    }

    @Override
    public void resize(int width, int height) {

    }
    public static void setCharacterRotation(int nRotation){
        nCharacterRotation = nRotation;
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
        Gdx.gl.glClearColor(1, 1, 1, 1);
        stateTime += Gdx.graphics.getDeltaTime();

        if(nCharacterRotation==0) {
            currentFrame = aWalkingUp.getKeyFrame(stateTime, true);
        }
        else  if(nCharacterRotation==1) {
            currentFrame = aWalkingDown.getKeyFrame(stateTime, true);
        }
        else  if(nCharacterRotation==2) {
            currentFrame = aWalkingLeft.getKeyFrame(stateTime, true);
        }
        else  if(nCharacterRotation==3) {
            currentFrame = aWalkingRight.getKeyFrame(stateTime, true);
        }

        sbSpriteBatch.begin();
        sbSpriteBatch.draw(currentFrame, 800, 500, 100, 120);
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

