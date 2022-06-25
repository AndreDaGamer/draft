import mayflower.*;

public class GravityActor extends Actor
{
    private int velocity;
    
    /**
     * Initializes a GravityActor object.
     * Precondition: Boolean landed and int velocity declared.
     * Postcondition: Boolean landed initialized to false and int velocity initialized to 1
     */
    public GravityActor()
    {
        velocity = 1;
    }
    
    /**
     * Stops Actor object from falling when Actor object touches a block object
     * Precondition: GravitActor object must be initialized
     * Postcondtion: Actor object stops falling when intersecting with Block object
     */
    public void act()
    {
        int x = getX();
        int y = getY();
        if(isBlocked())
        {
            Block block = getOneIntersectingObject(Block.class);
            int blockY = block.getY();
            setLocation(getX(), blockY - getHeight());
            velocity = 0;
        }
        else
        {
            velocity += 1;
            setLocation(x, y+velocity);
        }
    }
    
     /**
     * Returns true if GravityActor is touching Block object and not
     * 
     * @return isTouching(Block.class) - A boolean method that returns true if current object is touching other object and false if not.
     */
    public boolean isBlocked()
    {
        return isTouching(Block.class);
    }
    
    /**
     *Returns true if GravityActor is currently falling
     *
     *@return !isBlocked - returns true if GravityActor object is 
     *not blocked and false if GravityActor object is blocked
     */
    public boolean isFalling()
    {
        return !isBlocked();
    }
    
    /**
     * Returns instance variable velocity.
     * 
     * @return velocity - the velocity of the GravityActor objecy
     */
    public int getVelocity()
    {
        return velocity;
    }
    
    /**
     * Initializes velocity variable to a different value
     * Precondtion: Velocity variable must be declared
     * Postcondtion: Velocity variable is changed to the value of int vel
     * 
     * @param vel - the new value of velocity to be set for GravityActor object
     */
    public void setVelocity(int vel)
    {
        velocity = vel;
    }
}