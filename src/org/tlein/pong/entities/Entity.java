package org.tlein.pong.entities;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Shape;
import org.tlein.pong.GameObject;

/**
 * Entity is a GameObject with a defined shape. This shape is used for position
 * and collision checking.
 * 
 * @author Tucker Lein
 */
public class Entity extends GameObject {
	/* Shape of the Entity */
	protected Shape shape;
	
	/**
	 * Constructs a new Entity with given shape
	 * 
	 * @param shape Shape of Entity
	 */
	public Entity(Shape shape) {
		this.shape = shape;
	}

	/**
	 * Inits Entity
	 * 
	 * @param gc GameContainer context
	 */
	@Override
	public void init(GameContainer gc) throws SlickException {
	}

	/**
	 * Updates Entity
	 * 
	 * @param gc GameContainer context
	 * @param delta time since last update
	 */
	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
	}

	/**
	 * Renders the Entity
	 * 
	 * @param gc GameContainer context
	 * @param g Graphics context
	 */
	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
	}

	/**
	 * @return the shape
	 */
	public Shape getShape() {
		return shape;
	}

	/**
	 * @param shape the shape to set
	 */
	public void setShape(Shape shape) {
		this.shape = shape;
	}

}
