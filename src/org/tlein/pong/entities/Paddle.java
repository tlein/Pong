package org.tlein.pong.entities;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Shape;

public class Paddle extends ControlledEntity {	

	public Paddle(Shape shape) {
		super(shape);
		movementVect.set(0, 0.5f);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		super.init(gc);
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		super.update(gc, delta);
		if(!inputStack.isEmpty()) {
			checkInput(delta);
		}
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		super.render(gc, g);
		g.setColor(Color.white);
		g.fill(getShape());
	}
	
	private void checkInput(int delta) {
		if(inputStack.peek() == Input.KEY_UP) { //moving up
			yMovement(-movementVect.getY() * delta);
		} else if(inputStack.peek() == Input.KEY_DOWN) { //moving down
			yMovement(movementVect.getY() * delta);
		}
	}
	
}
