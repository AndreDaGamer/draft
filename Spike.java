import mayflower.*;
public class Spike extends Actor
{
    /**
     * Intializes a Spike object.
     */
    
    public Spike()
    {
        setImage("img/spikecrop.png");
    }
    
    /**
     * Subtracts 1 from life instance variable and moves Cat object if Cat Object touches Spike object
     * Removes Cat object from world if lives instance variable is equal to zero
     */
    
    public void act()
    {
        if(isTouching(Cat.class)){
            Object a = getOneIntersectingObject(Cat.class);
            Cat c = (Cat) a;
            World w = getWorld();
            
            c.setLocation(600,200);
            c.decreaseLives(1);
            if(c.getLives() == 0){
                w.removeObject(c);
                
            }
            
        }
    }
}