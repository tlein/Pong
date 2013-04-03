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
	
	/* Input int code of the key used to go upwards */
	private int upKey;
	
	/* Input int code of the key used to go downwards */
	private int downKey;
	
	/* determines if paddle is controlled by a controller */
	private boolean controller = false;

	/**
	 * Define a new paddle with the given Slick Shape
	 * 
	 * @param shape Shape of Paddle
	 */
	public Paddle(Shape shape) {
		super(shape);
		this.upKey = Input.KEY_UP;
		this.downKey = Input.KEY_DOWN;
		movementVect.set(0, 0.5f);
	}
	
	/**
	 * Constructs a new Paddle with the given shape, upKey, and downKey
	 * 
	 * @param shape Shape of Paddle
	 * @param upKey input key that the keyboard will relate to upward movement
	 * @param downKey input key that the keyboard will relate to downward movement
	 */
	public Paddle(Shape shape, int upKey, int downKey) {
		this(shape);
		this.upKey = upKey;
		this.downKey = downKey;
	}
	
	/**
	 * Constructs a new Paddle with the given shape, and controller boolean
	 * 
	 * @param shape Shape of Paddle
	 * @param controller true if controlled by controller, false by default
	 */
	public Paddle(Shape shape, boolean controller) {
		this(shape);
		this.controller = controller;
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
		if((!controller && !inputStack.isEmpty()) || (controller && !controllerStack.isEmpty())) {
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
		if(!controller) {
			if(inputStack.peek() == upKey) { //moving up
				yMovement(-movementVect.getY() * delta);
			} else if(inputStack.peek() == downKey) { //moving down
				yMovement(movementVect.getY() * delta);
			}
		} else {
			if(controllerStack.peek() == 0) { //moving up
				yMovement(-movementVect.getY() * delta);
			} else if(controllerStack.peek() == 1) { //moving down
				yMovement(movementVect.getY() * delta);
			}
		}
	}
	
}
