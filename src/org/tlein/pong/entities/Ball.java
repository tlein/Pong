package org.tlein.pong.entities;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Shape;
import org.tlein.pong.Game;

public class Ball extends MoveableEntity {

	public Ball(Shape shape) {
		super(shape);
		movementVect.set(0.5f, 0.5f);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		super.init(gc);
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		super.update(gc, delta);
		xMovement(movementVect.getX() * delta);
		yMovement(movementVect.getY() * delta);
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		super.render(gc, g);
		g.setColor(Color.white);
		g.fill(shape);
	}
	
	@Override
	protected boolean checkCollision(Shape s) {
		if(s.getY() < 0 || s.getY() + s.getHeight() > Game.getHeight()) {
			movementVect.set(movementVect.getX(), -movementVect.getY());
			return true;
		}
		if(s.getX() < 0 || s.getX() + s.getWidth() > Game.getWidth()) {
			movementVect.set(-movementVect.getX(), movementVect.getY());
			if(s.getX() < 0) Game.getPoints()[1]++;
			else if(s.getX() + s.getWidth() > Game.getWidth()) Game.getPoints()[0]++;
			return true;
		}
		for(Entity e : Game.getEntities()) {
			if(!this.equals(e) && s.intersects(e.getShape())) {
				movementVect.set(-movementVect.getX(), movementVect.getY());
				return true;
			}
		}
		return false;
	}
	

}
