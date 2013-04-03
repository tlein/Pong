package org.tlein.pong.entities;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;
import org.tlein.pong.Game;

public class MoveableEntity extends Entity {
	protected Vector2f movementVect = new Vector2f(0, 0);
	
	protected Shape nextStep;

	protected boolean colliding = false;
	
	protected Shape collidingShape;
	
	public MoveableEntity(Shape shape) {
		super(shape);
		nextStep = new Rectangle(shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight());
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		super.init(gc);
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		super.update(gc, delta);
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		super.render(gc, g);
	}
	
	protected void xMovement(float amount) {
		nextStep.setX(getShape().getX() + amount);
		colliding = checkCollision(nextStep);
		if(!colliding) {
			getShape().setX(nextStep.getX());
		} else {
			nextStep.setLocation(getShape().getX(), getShape().getY());
		}
	}
	
	protected void yMovement(float amount) {
		nextStep.setY(getShape().getY() + amount);
		colliding = checkCollision(nextStep);
		if(!colliding) {
			getShape().setY(nextStep.getY());
		} else {
			nextStep.setLocation(getShape().getX(), getShape().getY());
		}
	}

	protected boolean checkCollision(Shape s) {
		if(s.getX() + s.getWidth() > Game.getWidth() || s.getX() < 0 
				|| s.getY() + s.getHeight() > Game.getHeight() || s.getY() < 0) {
			return true;
		}
		return false;
	}

}
