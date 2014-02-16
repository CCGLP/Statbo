package com.moonwindgames.statbo.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.moonwindgames.logic.GameLogic;
import com.moonwindgames.statbo.game.objects.Human;
import com.moonwindgames.statbo.game.objects.Staff;
import com.badlogic.gdx.graphics.Texture;

public class Nivel implements Screen {
	private GameLogic logic;
	private SpriteBatch batch;
	private OrthogonalTiledMapRenderer renderer;
	private BitmapFont font;
	// Los considerados como públicos es porque GameLogic tiene que acceder a ellos directamente.
	//A continuacion, elementos de juego
	public Staff baston;
	public Human humano;
	public String mensaje = "Nada ha sucedido aún";
	public OrthographicCamera camera;
	public TiledMap map;
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();
		renderer.setView(camera);
		renderer.render();
		renderer.getSpriteBatch().begin();
			humano.draw(renderer.getSpriteBatch());
			baston.draw(renderer.getSpriteBatch());
			font.drawMultiLine(renderer.getSpriteBatch(), mensaje, camera.position.x, camera.position.y);
		renderer.getSpriteBatch().end();
	}

	@Override
	public void resize(int width, int height) {
		camera.setToOrtho(false);

	}

	@Override
	public void show() {
		map = new TmxMapLoader().load("map/Map_1_prototype.tmx");
		renderer = new OrthogonalTiledMapRenderer (map);
		camera = new OrthographicCamera ();
		camera.setToOrtho(false);
//		 camera.zoom -= 0.5;
		baston = new Staff (new Texture(Gdx.files.internal("images/Staff.png")), (TiledMapTileLayer) map.getLayers().get(0),4*64,4*64);
		humano = new Human (new Texture(Gdx.files.internal("images/Human.png")),(TiledMapTileLayer)map.getLayers().get(0), 10*64, 10*64);
		
		font = new BitmapFont(Gdx.files.internal("fuentes/ComicSans.fnt"));
		
		logic = new GameLogic (this);
		
		
	
		

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
