package com.moonwindgames.statbo.game.objects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

public abstract class  AbstractGameObject extends Sprite {
	
	private TiledMapTileLayer layer;
	public AbstractGameObject (Texture texture, TiledMapTileLayer layer, float positionX, float positionY){
		super (texture);
		this.layer = layer;
		this.setPosition(positionX, positionY);
		
	}
}
