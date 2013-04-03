package org.tlein.pong.entities;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Shape;
import org.tlein.pong.Game;

/**
 * The ball which the paddles try to hit. Extends MoveableEntity
 * so it has the movement vector, and shape of an entity
 * 
 * @author Tucker Lein
 */
public class Ball extends MoveableEntity {

	/**
	 * Constructs the Ball with the given shape
	 * 
	 * @param shape
	 */
	public Ball(Shape shape) {
		super(shape);
		
		/*set the unique movement speed of the ball */
		movementVect.set(0.5f, 0.5f); 
	}


	/**
	 * Inits Ball, calls init on parent
	 * 
	 * @param gc GameContainer context
	 */
	@Override
	public void init(GameContainer gc) throws SlickException {
		super.init(gc);
	}


	/**
	 * Updates Ball, determines movement, calls update on parent
	 * 
	 * @param gc GameContainer context
	 * @param delta time since last update
	 */
	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		super.update(gc, delta);
		xMovement(movementVect.getX() * delta);
		yMovement(movementVect.getY() * delta);
	}


	/**
	 * Renders the ball, calls render on parent
	 * 
	 * @param gc GameContainer context
	 * @param g Graphics context
	 */
	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		super.render(gc, g);
		g.setColor(Color.white);
		g.fill(shape);
	}
	
	/**
	 * Override checkCollision to do specialized actions when a collision is found
	 * 
	 * @param s Shape to check for collision
	 */
	@Override
	protected boolean checkCollision(Shape s) {
		/* If the shape is colliding with a top or bottom wall */
		if(s.getY() < 0 || s.getY() + s.getHeight() > Game.getHeight()) {
			/* flip the y movement */
			movementVect.set(movementVect.getX(), -movementVect.getY());
			return true;
		}
		/* If the shape is colliding with a left or right wall */
		if(s.getX() < 0 || s.getX() + s.getWidth() > Game.getWidth()) {
			/* flip the x movement */
			movementVect.set(-movementVect.getX(), movementVect.getY());
			
			/* determine which paddle to give points to */
			if(s.getX() < 0) Game.getPoints()[1]++;
			else if(s.getX() + s.getWidth() > Game.getWidth()) Game.getPoints()[0]++;
			return true;
		}
		
		/* Loop through the entities, check for collision */
		for(Entity e : Game.getEntities()) {
			if(!this.equals(e) && s.intersects(e.getShape())) {
				/* if colliding with paddle, flip x movement */
				movementVect.set(-movementVect.getX(), movementVect.getY());
				return true;
			}
		}
		return false;
	}
}
