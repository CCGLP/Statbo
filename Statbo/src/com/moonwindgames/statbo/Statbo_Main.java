package com.moonwindgames.statbo;


import com.badlogic.gdx.Game;
import com.moonwindgames.statbo.game.Nivel;
public class Statbo_Main extends Game {
	
	
	@Override
	public void create() {		
		this.setScreen(new Nivel());
		
		
	}

	@Override
	public void dispose() {
		super.dispose();
		
	}

	@Override
	public void render() {		
		super.render();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}
}
