import greenfoot.*;

/**
 * Write a description of class Board here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Board extends World
{
    private int n;
    Score score;
    
    public Board()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(700, 600, 1); 
        score = new Score();
        addObject(score, 113, 594);
        addObject(new Paddle(), getWidth()/2, getHeight()-50);
        addObject(new Balls(score), getWidth()/2, getHeight()-70);
        n = 5;
        makeBlocks();
        
    }
    
    private void makeBlocks()
    {
        for (int n = 0; n < 3; n++)
        {
            for (int i = 0; i < 6; i++)
            {
                addObject(new Block(), getWidth()/6 * (i + 1) - 50, 35 + (35 * n));
            }
        }
    }
}