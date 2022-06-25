import mayflower.*;

public class Collectible extends Actor
{
    private boolean acquired;
    
    /**
     * Initializes Collectible object
     */
    public Collectible(){
        acquired = false;
        setImage("img/yarn.png");
    }
    
    long startTime = System.currentTimeMillis();
    
    /**
     * Increase instance variable score and removes Collectible 
     * object from current world if Cat object touches Collectible
     * object
     */
    public void act(){
        if(isTouching(Cat.class))
        {
            long endTime = System.currentTimeMillis();
            long timeTook = (endTime - startTime) / 1000;
            Object a = getOneIntersectingObject(Cat.class);
            Cat c = (Cat) a;
            World w = getWorld();
            w.removeObject(this);
            c.increaseScore(100 / (int)timeTook);
            c.updateText();
            acquired = true;
        }
    }
    
    /**
     * Returns instance variable aquired
     * 
     * @return - returns true if a Collectible object is acquired 
     * and false if not
     */
    public boolean getAcquired()
    {
        return acquired;
    }
}