package org.tlein.pong.entities;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Shape;
import org.tlein.pong.GameObject;

public class Entity extends GameObject {
	protected Shape shape;
	
	public Entity(Shape shape) {
		this.shape = shape;
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
	}

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
