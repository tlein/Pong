package org.tlein.pong.entities;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Shape;

/**
 * A player or AI controlled paddle to used to hit the ball and keep it out
 * of their goal. It extends ControlledEntity so it has the Shape definitions
 * of an Entity and the KeyListener and input stack of a Controlled Entity
 * 
 * @author Tucker Lein
 */
public class Paddle extends ControlledEntity {	

	/**
	 * Define a new paddle with the given Slick Shape
	 * 
	 * @param shape Shape of Paddle
	 */
	public Paddle(Shape shape) {
		super(shape);
		movementVect.set(0, 0.5f);
	}

	/**
	 * Inits Paddle, calls init on parent
	 * 
	 * @param gc GameContainer context
	 */
	@Override
	public void init(GameContainer gc) throws SlickException {
		super.init(gc);
	}

	/**
	 * Updates Paddle, checks input, calls update on parent
	 * 
	 * @param gc GameContainer context
	 * @param delta time since last update
	 */
	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		super.update(gc, delta);
		if(!inputStack.isEmpty()) {
			checkInput(delta);
		}
	}

	/**
	 * Renders the paddle, calls render on parent
	 * 
	 * @param gc GameContainer context
	 * @param g Graphics context
	 */
	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		super.render(gc, g);
		g.setColor(Color.white);
		g.fill(getShape());
	}
	
	/**
	 * Checks the current set of input, does the necessary action if correct input is found
	 * 
	 * @param delta time since last update
	 */
	private void checkInput(int delta) {
		if(inputStack.peek() == Input.KEY_UP) { //moving up
			yMovement(-movementVect.getY() * delta);
		} else if(inputStack.peek() == Input.KEY_DOWN) { //moving down
			yMovement(movementVect.getY() * delta);
		}
	}
	
}
