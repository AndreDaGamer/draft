import mayflower.*;

public class GameOver extends World
{
    // Constructor
    /**
     * Initializes a GameOver object
     */
    public GameOver()
    {
        setBackground("img/bluebonnets.jpg");
        showText("GAMEOVER", getWidth() / 2 - 90, 100, Color.BLACK);
        
    }
    
    /**
     * Sets World GameOver as the current world
     */
    public void act()
    {
        if(Mayflower.isKeyDown(Keyboard.KEY_SPACE)){
            World myWorld = new MyWorld();
            Mayflower.setWorld(myWorld);
        }
    }
}