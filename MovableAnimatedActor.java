import mayflower.*;

public class MovableAnimatedActor extends AnimatedActor
{
    private Animation walkLeft;
    private Animation walkRight;
    private Animation idleRight;
    private Animation idleLeft;
    private Animation fallRight;
    private Animation fallLeft;
    private Animation jumpRight;
    private Animation jumpLeft;
    private String currentAction;
    private String lastCurrentAction;
    private boolean facingRight;
    
    /**
     * Intializes MoveableAnimatedActor object
     */
    public MovableAnimatedActor()
    {
        walkRight = null;
        idleRight = null;
        currentAction = null;
        lastCurrentAction = "";
        facingRight = true;
    }
    
    /**
     * Sets fluid animations for the MoveableAnimatedActor object
     */
    public void act()
    {
        super.act();
        String newAction = "";
        if(currentAction == null)
        {
            newAction = "fallRight";
        }
        int x = getX();
        int y = getY();
        int w = getWidth();
        int h = getHeight();
        boolean changedLocation = false;
        if(x < 800 - 100)
        {
            if(Mayflower.isKeyDown(Keyboard.KEY_RIGHT))
            {
                setLocation(x+3,y);
                if(isBlocked())
                {
                    setLocation(getX()-3, y);
                }
                newAction = "walkRight";
                changedLocation = true;
                facingRight = true;
            }
        }
        if(x > 0)
        {
            if(Mayflower.isKeyDown(Keyboard.KEY_LEFT))
            {
                setLocation(x-3,y);
                if(isBlocked())
                {
                    setLocation(getX()+3, y);
                }
                newAction = "walkLeft";
                changedLocation = true;
                facingRight = false;
            }
        }
        if(y > 0)
        {
            if(Mayflower.isKeyDown(Keyboard.KEY_UP) && !isFalling())
            {
                setLocation(x, y-2);
                setVelocity(-20);
                changedLocation = true;
            }
        }
        if(currentAction != null && getVelocity() > 1 && newAction.equals(""))
        {
            if(facingRight)
            {
                newAction = "fallRight";
            }
            else
            {
                newAction = "fallLeft";
            }
            changedLocation = true;
        }
        if(currentAction != null && getVelocity() < 0 && newAction.equals(""))
        {
            if(facingRight)
            {
                newAction = "jumpRight";
            }
            else
            {
                newAction = "jumpLeft";
            }
            changedLocation = true;
        }
        if(!changedLocation && currentAction != null)
        {
                if(facingRight)
                {
                    newAction = "idleRight";
                }
                else
                {
                    newAction = "idleLeft";
                }
        }
        if(!newAction.equals(currentAction))
        {
            if(newAction.equals("idleRight"))
            {
                setAnimation(idleRight);
            }
            else if(newAction.equals("idleLeft"))
            {
                setAnimation(idleLeft);
            }
            else if(newAction.equals("walkRight"))
            {
                setAnimation(walkRight);
            }
            else if(newAction.equals("walkLeft"))
            {
                setAnimation(walkLeft);
            }
            else if(newAction.equals("fallRight"))
            {
                setAnimation(fallRight);
            }
            else if(newAction.equals("fallLeft"))
            {
                setAnimation(fallLeft);
            }
            else if(newAction.equals("jumpRight"))
            {
                setAnimation(jumpRight);
            }
            else if(newAction.equals("jumpLeft"))
            {
                setAnimation(jumpLeft);
            }
        }
        changedLocation = false;
        currentAction = newAction;
    }
    
    /**
     * Sets walking left animation for MoveableAnimatedActor object
     * 
     * @param ani - Animation object to initialize walkLeft instance variable 
     */
    public void setWalkLeftAnimation(Animation ani)
    {
        walkLeft = ani;
    }
    
    /**
     * Sets walking right animation for MoveableAnimatedActor object
     * 
     * @param ani - Animation object to initialize walkRight instance variable 
     */
    public void setWalkRightAnimation(Animation ani)
    {
        walkRight = ani;
    }
    
    /**
     * Sets idling right animation for MoveableAnimatedActor object
     * 
     * @param ani - Animation object to initialize idleRight instance variable 
     */
    public void setIdleRightAnimation(Animation ani)
    {
        idleRight = ani;
    }
    
    /**
     * Sets idling left animation for MoveableAnimatedActor object
     * 
     * @param ani - Animation object to initialize idleLeft instance variable 
     */
    public void setIdleLeftAnimation(Animation ani)
    {
        idleLeft = ani;
    }
    
    /**
     * Sets falling right animation for MoveableAnimatedActor object
     * 
     * @param ani - Animation object to initialize fallRight instance variable 
     */
    public void setFallRightAnimation(Animation ani)
    {
        fallRight = ani;
    }
    
    /**
     * Sets falling left animation for MoveableAnimatedActor object
     * 
     * @param ani - Animation object to initialize fallLeft instance variable 
     */
    public void setFallLeftAnimation(Animation ani)
    {
        fallLeft = ani;
    }
    
     /**
     * Sets jumping right animation for MoveableAnimatedActor object
     * 
     * @param ani - Animation object to initialize jumpRight 
     * instance variable 
     */
    public void setJumpRightAnimation(Animation ani)
    {
        jumpRight = ani;
    }
    
    /**
     * Sets jumping left animation for MoveableAnimatedActor object
     * 
     * @param ani - Animation object to initialize jumpLeft 
     * instance variable 
     */
    public void setJumpLeftAnimation(Animation ani)
    {
        jumpLeft = ani;
    }
    
    /**
     * Sets animation for MoveableAnimatedActor object
     * 
     * @param a - Animation object set as Animation
     */
    public void setAnimation(Animation a)
    {
        super.setAnimation(a);
    }
    
    /**
     * Returns instance variable currentAction
     * 
     * @return currentAction - String that holds the 
     * MovableAnimatedActor Object's current action
     */
    public String getCurrentAction()
    {
        return currentAction;
    }
}