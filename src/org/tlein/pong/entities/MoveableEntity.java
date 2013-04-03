package org.tlein.pong.entities;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;
import org.tlein.pong.Game;

/**
 * A MoveableEntity extends Entity so that the Entity has a shape, but also has 
 * a Vector to determine movement, and collision detection
 * 
 * @author Tucker Lein
 */
public class MoveableEntity extends Entity {
	/* Vector defining the movement speeds. the x value is the amount of movement
	 * in the x direction during one step, the y value is the amount of movement
	 * int he y direction during one step. Defaults to values of 0.
	 */
	protected Vector2f movementVect = new Vector2f(0, 0);
	
	/* Shape that first checks the next movement for collision before applying the
	 * movement to the real shape.
	 */
	protected Shape nextStep;
	
	/* true if colliding with something, false if not */
	protected boolean colliding = false;
	
	/* Shape the MoveableEntity is colliding with */
	protected Shape collidingShape;
	
	/**
	 * Constructs a new MoveableEntity with the given Shape. nextStep's values
	 * are set to the shape's values
	 * 
	 * @param shape Shape of MoveableEntity
	 */
	public MoveableEntity(Shape shape) {
		super(shape);
		nextStep = new Rectangle(shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight());
	}

	/**
	 * Inits MoveableEntity, calls parent init
	 * 
	 * @param gc GameContainer context
	 */
	@Override
	public void init(GameContainer gc) throws SlickException {
		super.init(gc);
	}

	/**
	 * Updates MoveableEntity, calls parent update
	 * 
	 * @param gc GameContainer context
	 * @param delta time since last update
	 */
	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		super.update(gc, delta);
	}

	/**
	 * Renders the MoveableEntity, calls parent render
	 * 
	 * @param gc GameContainer context
	 * @param g Graphics context
	 */
	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		super.render(gc, g);
	}
	
	/**
	 * Applys movement in the x direction of the given amount. First the nextStep
	 * is moved the amount, is checked for collision. If there is no collision the
	 * actual step is moved the amount, if not the nextStep is set to the location
	 * of the actual shape (before the amount was applied)
	 * 
	 * @param amount amount to move in the x direction
	 */
	protected void xMovement(float amount) {
		nextStep.setX(getShape().getX() + amount);
		colliding = checkCollision(nextStep);
		if(!colliding) {
			getShape().setX(nextStep.getX());
		} else {
			nextStep.setLocation(getShape().getX(), getShape().getY());
		}
	}

	/**
	 * Applys movement in the y direction of the given amount. First the nextStep
	 * is moved the amount, is checked for collision. If there is no collision the
	 * actual step is moved the amount, if not the nextStep is set to the location
	 * of the actual shape (before the amount was applied)
	 * 
	 * @param amount amount to move in the y direction
	 */
	protected void yMovement(float amount) {
		nextStep.setY(getShape().getY() + amount);
		colliding = checkCollision(nextStep);
		if(!colliding) {
			getShape().setY(nextStep.getY());
		} else {
			nextStep.setLocation(getShape().getX(), getShape().getY());
		}
	}

	/**
	 * Checks if the MoveableEntity is colliding with the bounds of the screen
	 * 
	 * @param s Shape to check collisions on
	 * @return true if colliding, false if not
	 */
	protected boolean checkCollision(Shape s) {
		return s.getX() + s.getWidth() > Game.getWidth() || s.getX() < 0 
				|| s.getY() + s.getHeight() > Game.getHeight() || s.getY() < 0;
	}

}
