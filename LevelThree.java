import mayflower.*;

public class LevelThree extends World
{
    private Cat cat;
    private Collectible y;
    
    /**
     * Initializes a LevelThree object
     */
    public LevelThree()
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
        
        Block block3 = new Block();
        addObject(block3, 16, 244);
        
        Spike spike = new Spike();
        addObject(spike, 174, 304);
        
        Mayflower.showBounds(true);
        
        Dog walk = new Dog();
        addObject(walk, 280, 400);
        
        y = new Collectible();
        addObject(y,16+30,244-y.getHeight());
        
        showText("Score: " + cat.getScore() + " Lives: " + cat.getLives(), 10, 30, Color.BLACK);
        
        
    }
    
    /**
     * Sets world to gameOver if instance variable lives equals zero
     * Changes current world to World LevelFour if all Collectible objects
     * are acquired 
     */
    public void act()
    {
        if(cat.getLives() == 0){
            World gameOver = new GameOver();
            Mayflower.setWorld(gameOver);
        }else if(y.getAcquired()){
            World levelfour = new LevelFour();
            Mayflower.setWorld(levelfour);
        }
    }
}