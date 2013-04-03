package org.tlein.pong;

import org.newdawn.slick.*;

/**
 * Top level abstract class all objects inherit from
 * 
 * @author Tucker Lein
 */
public abstract class GameObject {
	
	//abstract init method all objects must implement
    public abstract void init(GameContainer gc) throws SlickException; 

    //abstract update method all objects must implement
    public abstract void update(GameContainer gc, int delta) throws SlickException; 

    //abstract render method all objects must implement
    public abstract void render(GameContainer gc, Graphics g) throws SlickException; 

}
