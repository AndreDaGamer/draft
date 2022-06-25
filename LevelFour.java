import mayflower.*;

public class LevelFour extends World
{
    private Cat cat = new Cat();
    private Collectible y;
    private Collectible y2;
    
    /**
     * Initializes a LevelFour object
     */
    public LevelFour()
    {
        setBackground("img/forest_mtns.png");
        
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
        
        Block block4 = new Block();
        addObject(block4, 656, 244);
        
        Block block5 = new Block();
        addObject(block5, 720, 116);
        
        Spike spike2 = new Spike();
        addObject(spike2, 690, 176);
        
        Mayflower.showBounds(true);
        
        Dog walk = new Dog();
        addObject(walk, 280, 400);
        
        y = new Collectible();
        addObject(y, 16+30,244-y.getHeight());
        
        y2 = new Collectible();
        addObject(y2, 720+30,116-y2.getHeight());
        
        showText("Score: " + cat.getScore() + " Lives: " + cat.getLives(), 10, 30, Color.BLACK);
        
        
    }
    
    /**
     * Sets world to gameOver if instance variable lives equals zero
     * Changes current world to World Win if all Collectible objects
     * are acquired
     */
    public void act()
    {
       if(cat.getLives() == 0){
            World gameOver = new GameOver();
            Mayflower.setWorld(gameOver);
        }else if(y.getAcquired() && y2.getAcquired()){
            World win = new Win();
            Mayflower.setWorld(win);
        }
    }
}