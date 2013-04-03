package org.tlein.pong.entities;

import java.util.Stack;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Shape;

public class ControlledEntity extends MoveableEntity implements KeyListener {
	protected Stack<Integer> inputStack = new Stack<Integer>();

	public ControlledEntity(Shape shape) {
		super(shape);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
        super.init(gc);
        gc.getInput().addKeyListener(this);
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

	/* Unused KeyListener methods */
	public void inputEnded() {}
	public void inputStarted() {}
	public boolean isAcceptingInput() {return true;}
	public void setInput(Input input) {}
	

}
