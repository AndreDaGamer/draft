import mayflower.*;

public class Title extends World
{
    // Constructor
    /**
    * Initializes a Title object
    */
    public Title()
    {
        setBackground("img/birf.png");

        Cat cat = new Cat();
        addObject(cat, 600, 200);
        
        Block blockG = new Block();
        addObject(blockG, 600, 600);
        
        Mayflower.showBounds(true);
        
        showText("Platformer", getWidth() / 2 - 90, 100, Color.BLACK);
        showText("Press SPACE to start", getWidth() / 2 - 165, 300, Color.BLACK);
        
    }
    
    /**
    * Sets this Title as the current world
    * Changes current world to World Title if spacebar is held down 
    */
    public void act()
    {
        if(Mayflower.isKeyDown(Keyboard.KEY_SPACE)){
            World myWorld = new MyWorld();
            Mayflower.setWorld(myWorld);
        }
    }
}