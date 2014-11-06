package com.tauro.brock.android;
import com.badlogic.gdx.ApplicationListener;


/**
 * Created by Matthew Brock on 30/10/2014.
 */
//http://obviam.net/index.php/getting-started-in-android-game-development-with-libgdx-create-a-working-prototype-in-a-day-tutorial-part-1/
public class Main implements ApplicationListener {
    MainCharacter mainChracter;
    MakeButtons makeButtons;
    @Override
    public void create() {
        makeButtons = new MakeButtons();
        mainChracter = new MainCharacter();
        mainChracter.create();
        makeButtons.create();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void render() {
        mainChracter.render();
        makeButtons.render();
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
