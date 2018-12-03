import greenfoot.*;

/**
 * Write a description of class Balls here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Balls extends Actor
{
    private int rot;
    private int stop;
    private Score f;
    private int deltaX;
    GreenfootSound wind = new GreenfootSound("pop.wav");
    GreenfootSound tada = new GreenfootSound("tada.wav");
    public Balls(Score tempScore)
    {
        int rot = (int)(Math.random()*90)+225;
        setRotation(rot);
        f = tempScore;
        stop =0;
    }
    
    public void act() 
    {
        if (stop == 0)
        {
            move(6);
        }
        BounceAtEdge();
        die();
        win();
    }
    
    public void BounceAtEdge()
    {
        if (getX() > 695 || getX() < 5)
        {
            setRotation(180-getRotation());
            move(8);
    
        }
        
        if (getY() < 10)
        {
            setRotation(getRotation()*(-1));
            
        }
        
        if (isTouching(Paddle.class))
        {
            Actor paddle =getOneIntersectingObject(Paddle.class);
            int offSet = getX() - paddle.getX();
            setRotation(getRotation()*(-1) + offSet);
            move(8);
        }
        
        if (isTouching(Block.class))
        {
            removeTouching(Block.class);
            f.addScore();
            setRotation(getRotation()*(-1));
            wind.play();
        }
    }  
    public void die()
    {
       if(getY() > 590)
       {
           World myWorld = getWorld();
           myWorld.removeObjects(myWorld.getObjects(Paddle.class));
           GameOver gameover = new GameOver();
           Paddle paddle = new Paddle();
           myWorld.addObject(paddle, myWorld.getWidth()/2, myWorld.getHeight() - 50);
           paddle.reset();
           myWorld.addObject(gameover, 350, 450);
           Stop();
           setLocation(myWorld.getWidth()/2, myWorld.getHeight() - 70);
        }
    }

    public void Stop()
    {
        stop = 1;
    }
    
    public void win()
       {
           if (f.returnScore() == 15)
           {
               Score score = new Score();
               World myWorld = getWorld();
               Win win = new Win();
               myWorld.addObject(win, 350, 450);
               myWorld.removeObjects(myWorld.getObjects(Paddle.class));
               Paddle paddle = new Paddle();
               myWorld.addObject(paddle, myWorld.getWidth()/2, myWorld.getHeight() - 50);
               setLocation(myWorld.getWidth()/2, myWorld.getHeight() - 70);
               tada.play();
               f.addScore();
           }
       }
    
    
}
