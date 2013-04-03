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
	
	/* boolean determining if ball is being reset */
	private boolean reseting = false;
	
	/* time the ball was initially being reset at */
	private long curTime;
	
	/* direction the newly reset ball will be traveling in */
	private int resetDir;

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
		
		/* If the ball is reseting, call resetBall to check if time delay has passed */
		if(reseting) {
			resetBall(resetDir);
		} 
		/* Else if the ball is NOT reseting, apply the movement. This stops the ball from
		 * moving while the position is being reset.
		 */
		else {
			xMovement(movementVect.getX() * delta);
			yMovement(movementVect.getY() * delta);
		}
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
			if(s.getX() < 0) {
				Game.getPoints()[1]++;
				
				/* point was scored, reset the ball going to the right */
				resetBall(1);
			} else if(s.getX() + s.getWidth() > Game.getWidth()) {
				Game.getPoints()[0]++;
				
				/* point was scored, reset the ball going to the left */
				resetBall(0);
			}
			
			return true;
		}
		
		/* Loop through the entities, check for collision */
		for(Entity e : Game.getEntities()) {
			if(!this.equals(e) && s.intersects(e.getShape())) {
				/* if colliding with paddle, flip x movement */
				movementVect.set(-movementVect.getX(), movementVect.getY());
				
				/* Shifts the ball to the edge of the paddle, this is so the ball doesn't
				 * hit the top or bottom of the paddle and then get stuck flipping back 
				 * and forth in the x direction
				 */
				/* If the paddle is on the left side of the screen */
				if(e.getShape().getX() < Game.getWidth()/2) {
					/* set the ball to the right side of the paddle + 1 */
					shape.setX(e.getShape().getX() + e.getShape().getWidth() + 1);
				}
				/* else if the paddle is on the right side of the screen */
				else if(e.getShape().getX() > Game.getWidth()/2) {
					/* set the ball to the left side of the paddle - 1 */
					shape.setX(e.getShape().getX() - shape.getWidth() - 1);
				}
				
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Resets the ball and starts moving it in the direction provided
	 * 
	 * @param dir direction ball will start moving in, 0 for left 1 for right
	 */
	private void resetBall(int dir) {
		/* First time in, reseting will be false, grab the current time, the current dir,
		 * and setup the new location and movementVect's directions
		 */
		if(!reseting) {
			curTime = System.currentTimeMillis();
			resetDir = dir;
			reseting = true;
			if(dir == 0) {
				movementVect.set(Math.abs(movementVect.getX()), Math.abs(movementVect.getY()));
				shape.setLocation(50, 50);
			} else if(dir == 1) {
				movementVect.set(-(Math.abs(movementVect.getX())), Math.abs(movementVect.getY()));
				shape.setLocation(Game.getWidth() - 50 - shape.getWidth(), 50);
			}
		}
		
		/*
		 * If 500 milliseconds have passed (1/2 a second), set reseting to false. This
		 * resumes the movement of the ball
		 */
		if(System.currentTimeMillis() - curTime > 500) {
			reseting = false;
		}
	}
}
