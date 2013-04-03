package org.tlein.pong.entities;

import java.util.Stack;

import org.newdawn.slick.ControllerListener;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Shape;

public class ControlledEntity extends MoveableEntity implements KeyListener, ControllerListener {
	protected Stack<Integer> inputStack = new Stack<Integer>();

	protected Stack<Integer> controllerStack = new Stack<Integer>();

	public ControlledEntity(Shape shape) {
		super(shape);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
        super.init(gc);
        gc.getInput().addKeyListener(this);
        gc.getInput().addControllerListener(this);
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		super.update(gc, delta);
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		super.render(gc, g);
	}
	
	@Override
	public void keyPressed(int key, char c) {
		inputStack.push(key);
	}

	@Override
	public void keyReleased(int key, char c) {
		if(inputStack.contains(key)) {
			inputStack.remove((Integer)key);
		}
	}

	@Override
	public void controllerUpPressed(int controller) {
		controllerStack.add(0);
	}

	@Override
	public void controllerUpReleased(int controller) {
		if(controllerStack.contains(0)) {
			controllerStack.remove((Integer)0);
		}
	}

	@Override
	public void controllerDownPressed(int controller) {
		controllerStack.add(1);
	}

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
	public void controllerButtonPressed(int controller, int button) { } 
	public void controllerButtonReleased(int controller, int button) { } 
	public void controllerLeftPressed(int controller) { } 
	public void controllerLeftReleased(int controller) { } 
	public void controllerRightPressed(int controller) { } 
	public void controllerRightReleased(int controller) { }

}
