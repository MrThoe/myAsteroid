import greenfoot.*;

/**
 * Write a description of class Paddle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Paddle extends Actor
{
    private int state;
    
    public Paddle()
    {
        state = 0;
    }
    
    public void act() 
    {
        if (Greenfoot.isKeyDown("RIGHT") && state == 0)
        {
            move(5);
        }
        if (Greenfoot.isKeyDown("LEFT") && state == 0)
        {
            move(-5);
        }
    }    
    
    public void reset()
    {
        state = 1;
        
    }
}

