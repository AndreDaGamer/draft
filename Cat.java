import mayflower.*;

public class Cat extends MovableAnimatedActor
{
    private Timer animationTimer;
    private Animation walkLeft;
    private Animation walkRight;
    private Animation idleRight;
    private Animation idleLeft;
    private Animation fallRight;
    private Animation fallLeft;
    private Animation jumpRight;
    private Animation jumpLeft;
    private static int score = 0;
    private int lives;
    
    /**
     * Initializes a Cat object
     * Sets the animations and bounds for the Cat object
     */
    public Cat()
    {
        lives = 3;
        String[] frames = new String[10];
        for(int i = 1; i <= 10; i++)
        {
            frames[i-1] = "img/cat/Walk (" + i + ").png";
        }
        walkRight = new Animation(60, frames);
        walkRight.changeScale(100, 87);
        walkRight.setBounds(18, 5, 54, 80);
        
        walkLeft = new Animation(60, frames);
        walkLeft.flipHorizontally();
        walkLeft.changeScale(100, 87);
        walkLeft.setBounds(28, 5, 54, 80);
        
        for(int i = 1; i <= 10; i++)
        {
            frames[i-1] = "img/cat/Idle (" + i + ").png";
        }
        idleRight = new Animation(60, frames);
        idleRight.changeScale(100, 87);
        idleRight.setBounds(18, 5, 54, 80);
        
        idleLeft = new Animation(60, frames);
        idleLeft.flipHorizontally();
        idleLeft.changeScale(100, 87);
        idleLeft.setBounds(28,5,54,80);
        
        frames = new String[8];
        for(int i = 1; i <= 8; i++)
        {
            frames[i-1] = "img/cat/Fall (" + i + ").png";
        }
        fallRight = new Animation(60, frames);
        fallRight.changeScale(100, 87);
        fallRight.setBounds(18,5,54,80);
        
        fallLeft = new Animation(60, frames);
        fallLeft.flipHorizontally();
        fallLeft.changeScale(100, 87);
        fallLeft.setBounds(28,5,54,80);
        
        for(int i = 1; i <= 8; i++)
        {
            frames[i-1] = "img/cat/Jump (" + i + ").png";
        }
        jumpRight = new Animation(60, frames);
        jumpRight.changeScale(100, 87);
        jumpRight.setBounds(18,5,54,80);
        
        jumpLeft = new Animation(60, frames);
        jumpLeft.flipHorizontally();
        jumpLeft.changeScale(100, 87);
        jumpLeft.setBounds(28,5,54,80);
        
        setWalkLeftAnimation(walkLeft);
        setWalkRightAnimation(walkRight);
        setIdleRightAnimation(idleRight);
        setIdleLeftAnimation(idleLeft);
        setFallRightAnimation(fallRight);
        setFallLeftAnimation(fallLeft);
        setJumpLeftAnimation(jumpLeft);
        setJumpRightAnimation(jumpRight);
    }
    
    /**
     * Increases instance variable score by int amount
     * 
     * @param amount - int added to instance variable score   
     */
    public void increaseScore(int amount){
        score += amount;
    }
    
    /**
     * Decreases instance variable lives by int amount
     * 
     * @param amount - int subtracted from instance variable lives 
     */
    public void decreaseLives(int amount){
        lives -= amount;
        updateText();

    }
    
    /**
     * Returns instance variable score 
     * 
     * @return score - The score of the Cat object
     */
    public int getScore(){
        return score;
    }
    
     /**
     * Returns instance variable lives 
     * 
     * @return lives - The lives of the Cat object
     */
    public int getLives(){
        return lives;
    }    
    
    /**
     * Displays the instance variables int lives and int score of the
     * Cat object on the screen
     */
    public void updateText(){
        World w = getWorld();
        w.removeText(10, 30);
        w.showText("Score: " + score + " Lives: " + lives, 10, 30, Color.BLACK);
        
    }
    
    /**
     * Subtracts one from the instance variable lives and resets 
     * the position of the Cat object if Cat object falls out of 
     * the current world
     * Removes Cat object from current world if instance variable 
     * lives equals zero
     */
    public void act()
    {
        super.act();
        if(getY() > 600){
            World w = getWorld();
            this.setLocation(600,200);
            this.decreaseLives(1);
            if(this.getLives() == 0){
                w.removeObject(this);
                
            }
        }
    }
}
