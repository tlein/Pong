package org.tlein.pong.entities;

import java.util.Stack;

import org.newdawn.slick.ControllerListener;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Shape;

/**
 * ControlledEntity is a MoveableEntity with KeyListener and ControllerListener
 * enabled. Inputs received from the controller and keyboard are pushed onto 
 * stacks. Peeking the stack will reveal the latest input the player has given.
 * When a player releases a key it is removed from the stacks regardless if it
 * is at the top of the stack or elsewhere.
 * 
 * @author Tucker Lein
 */
public class ControlledEntity extends MoveableEntity implements KeyListener, ControllerListener {
	/* Stack containing the input keys from the keyboard entered by the user */
	protected Stack<Integer> inputStack = new Stack<Integer>();

	/* Stack containing the input keys from the controller entered by the user */
	protected Stack<Integer> controllerStack = new Stack<Integer>();

	/**
	 * Construct a new ControlledEntity with the given shapes
	 * 
	 * @param shape Shape of ControlledEntity
	 */
	public ControlledEntity(Shape shape) {
		super(shape);
	}


	/**
	 * Inits ControlledEntity, calls init on parent, and adds input and 
	 * controller listeners
	 * 
	 * @param gc GameContainer context
	 */
	@Override
	public void init(GameContainer gc) throws SlickException {
        super.init(gc);
        gc.getInput().addKeyListener(this);
        gc.getInput().addControllerListener(this);
	}

	/**
	 * Updates ControlledEntity, calls update on parent
	 * 
	 * @param gc GameContainer context
	 * @param delta time since last update
	 */
	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		super.update(gc, delta);
	}

	/**
	 * Renders the ControlledEntity, calls render on parent
	 * 
	 * @param gc GameContainer context
	 * @param g Graphics context
	 */
	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		super.render(gc, g);
	}

	/**
	 * Called when a key is pressed, adds the key to the inputStack
	 * 
	 * @param key the Input key code of the given key pressed - Ex: when 
	 * pressing ;, the key parameter will be Input.KEY_SEMICOLON
	 * @param c the character representation of the key pressed - Ex: when 
	 * pressing %, the c parameter will be '%'
	 */
	@Override
	public void keyPressed(int key, char c) {
		inputStack.push(key);
	}

	/**
	 * Called when a key is released, removes that key from the inputStack
	 * 
	 * @param key the Input key code of the given key pressed - Ex: when 
	 * pressing ;, the key parameter will be Input.KEY_SEMICOLON
	 * @param c the character representation of the key pressed - Ex: when 
	 * pressing %, the c parameter will be '%'
	 */
	@Override
	public void keyReleased(int key, char c) {
		if(inputStack.contains(key)) {
			inputStack.remove((Integer)key);
		}
	}

	/**
	 * Called when the controller's default UP button is pressed
	 * 
	 * @param controller the int value of the controller pressed
	 */
	@Override
	public void controllerUpPressed(int controller) {
		/* add 0 to controllerStack, 0 now represents UP */
		controllerStack.add(0);
	}

	/**
	 * Called when the controller's default UP button is released
	 * 
	 * @param controller the int value of the controller released
	 */
	@Override
	public void controllerUpReleased(int controller) {
		if(controllerStack.contains(0)) {
			controllerStack.remove((Integer)0);
		}
	}

	/**
	 * Called when the controller's default DOWN button is pressed
	 * 
	 * @param controller the int value of the controller pressed
	 */
	@Override
	public void controllerDownPressed(int controller) {
		/* add 1 to controllerStack, 1 now represents DOWN */
		controllerStack.add(1);
	}

	/**
	 * Called when the controller's default DOWN button is released
	 * 
	 * @param controller the int value of the controller released
	 */
	@Override
	public void controllerDownReleased(int controller) {
		if(controllerStack.contains(1)) {
			controllerStack.remove((Integer)1);
		}
	}


	/* Unused KeyListener and ControllerListener methods */
	public void inputEnded() {}
	public void inputStarted() {}
	public boolean isAcceptingInput() {return true;}
	public void setInput(Input input) {} 
	public void controllerButtonPressed(int controller, int button) {} 
	public void controllerButtonReleased(int controller, int button) {} 
	public void controllerLeftPressed(int controller) {} 
	public void controllerLeftReleased(int controller) {} 
	public void controllerRightPressed(int controller) {} 
	public void controllerRightReleased(int controller) {}

}
