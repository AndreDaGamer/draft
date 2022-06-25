import mayflower.*;

public class MyWorld extends World
{
    private Cat cat;
    private Collectible y;
    
    /**
     * Initializes MyWorld object
     */
    public MyWorld()
    {
        setBackground("img/forest_mtns.png");

        cat = new Cat();
        addObject(cat, 600, 200);
        
        Block blockG = new Block();
        addObject(blockG, 400, 500);
        
        Block blockG2 = new Block();
        addObject(blockG2, 272, 500);
        
        Block block = new Block();
        addObject(block, 144, 372);
        
        Block block2 = new Block();
        addObject(block2, 528, 372);
        
        Mayflower.showBounds(true);
        
        // Dog walk = new Dog();
        // addObject(walk, 280, 400);
        
        Spike spike = new Spike();        
        addObject(spike, 385, 432);
        
        y = new Collectible();
        addObject(y, 200, 500-128-y.getHeight());
        
        showText("Score: " + cat.getScore() + " Lives: " + cat.getLives(), 10, 30, Color.BLACK);
        
        
    }
    
    /**
     * Sets world to gameOver if instance variable lives is equal to zero
     * Changes current world to World LevelFour if all Collectible objects
     *are acquired 
     */
    public void act()
    {
        if(cat.getLives() == 0){
            World gameOver = new GameOver();
            Mayflower.setWorld(gameOver);
        }else if(y.getAcquired()){
            World level2 = new LevelTwo();
            Mayflower.setWorld(level2);
        }
    }
}