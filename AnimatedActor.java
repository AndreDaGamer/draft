import mayflower.*;

public class AnimatedActor extends GravityActor
{
    private Animation animation;
    private Timer animationTimer;
    
    /**
     * Initializes the Timer animationTime variable.
     */
    public AnimatedActor()
    {
        
    }
    
    /**
     * Initializes the Animation animation variable
     * Precondition: animation object must be initialized
     * Postcondition: Sets Animation animation object to Animation a object
     * 
     * @param a - Animation object to initialize instance variable animation 
     * for AnimatedActor object
     */
    public void setAnimation(Animation a)
    {
        animation = a;
        animationTimer = new Timer((int)1000000000.0/30);
    }
    
    /**
     * Loops through the frames array instance variable to create 
     * an animation of thr AnimatedActor object
     */
    public void act()
    {
        super.act();
        if(animation != null)
        {
            if(animationTimer.isDone())
            {
                animationTimer.reset();
                setImage(animation.getNextFrame());
            }
        }
    }
}
