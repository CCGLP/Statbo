package com.moonwindgames.logic;


import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;
import com.moonwindgames.statbo.game.Nivel;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;

public class GameLogic implements InputProcessor, GestureListener {
private GestureListener listener;
private Nivel nivel;
private InputMultiplexer inputhandler;
private GestureDetector detector;
private float previousPanX, previousPanY;
private float fijar;
private TiledMapTileLayer layer;
	public GameLogic (Nivel nivel){
		//Necesitamos el nivel para cambiar cosas dentro de el, si no no tendría sentido la 
		// separacion de las clases
		this.nivel = nivel;
		// Para esto usamos InputMultiplexer, que es un manejador de varios input distintos a la vez
		// Como nuestra clase es un InputProccesor a la vez de gestos y de acciones normales utilizamos
		// Una trampa que es añadir un GestureDetector iniciado con la propia instancia de la clase
		// Y en el gestor "normal" añadir a pelo nuestra instancia.
		// Así se engaña al InputMultiplexer y se cree que tiene dos a la vez.
		inputhandler = new InputMultiplexer ();
		detector = new GestureDetector (this);
		inputhandler.addProcessor(this);
		inputhandler.addProcessor(detector);
		Gdx.input.setInputProcessor(inputhandler);
		this.layer = (TiledMapTileLayer) this.nivel.map.getLayers().get(0);
	}
	

	@Override
	public boolean touchDown(float x, float y, int pointer, int button) {
		// TODO Auto-generated method stub
		this.nivel.mensaje = "Touch Down";
		System.out.println ("This is TOUCH DOWN, first x "+ x + " : " + y );
		return false;
	}

	@Override
	public boolean tap(float x, float y, int count, int button) {
	//	if ((x <= (Gdx.app.getGraphics().getWidth()/2)) && (Gdx.app.getGraphics().getWidth) ){
		//	if 
	//	}
			
		layer.getCell((int)(x/64), (int)(y/64)).getTile();
		System.out.println ("This is TAP, first x "+ x + " : " + y );

		this.nivel.mensaje = x + " " + y;
		
		return false;
	}

	@Override
	public boolean longPress(float x, float y) {
		// TODO Auto-generated method stub
		this.nivel.mensaje = "You Long Pressed! Ouch";
		return false;
	}

	@Override
	public boolean fling(float velocityX, float velocityY, int button) {
		// TODO Auto-generated method stub
		this.nivel.mensaje = "What in da world is a fling?";
		return false;
	}

	@Override
	public boolean pan(float x, float y, float deltaX, float deltaY) {
		// TODO Auto-generated method stub
		System.out.println("This is DELTA Y " +deltaY);
		System.out.println("This is DELTA X " +deltaX);
		if (x > this.previousPanX)
			this.nivel.camera.position.x -= 6;
		else if (x < this.previousPanX)
			this.nivel.camera.position.x += 6;
		
		if (y > this.previousPanY)
			this.nivel.camera.position.y += 6;
		else if (y < this.previousPanY)
			this.nivel.camera.position.y -= 6;
		
		this.nivel.mensaje = "Pan: Camera position X " + this.nivel.camera.position.x + " Pan: Camera position Y : " + this.nivel.camera.position.y;
		this.previousPanX = x;
		this.previousPanY = y;
		return false;
	}

	@Override
	public boolean panStop(float x, float y, int pointer, int button) {
		// TODO Auto-generated method stub
		this.nivel.mensaje = "Stop Pan";
		return false;
	}

	@Override
	public boolean zoom(float initialDistance, float distance) {
		if (distance > initialDistance+50){
			
			if (this.fijar > (-0.5)){
				this.fijar -= 0.01;
				this.nivel.camera.zoom -= 0.008;
				this.nivel.camera.update();
			}
			this.nivel.mensaje = "ZOOM AMOUNT " + this.fijar;
		}
		else if (distance < initialDistance-50){
			
			if (this.fijar < 2){
				this.fijar += 0.01;
				this.nivel.camera.zoom += 0.008;
				this.nivel.camera.update();
			}
			this.nivel.mensaje = "ZOOM AMOUNT " + this.fijar;
		}
	
		return false;
	}

	@Override
	public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2,
			Vector2 pointer1, Vector2 pointer2) {
		// TODO Auto-generated method stub
			this.nivel.mensaje = "Pinched";
		return false;
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
