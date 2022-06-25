import mayflower.*;

public class Win extends World
{
    // Constructor
    
    /**
     * Initializes a Win object
     */
    public Win()
    {
        setBackground("img/bluebonnets.jpg");
        showText("Congradulations! you win", getWidth() / 2 - 200, 80, Color.BLACK);
        
    }

    /**
     * Abstract method
     */
    public void act()
    {
        
    }
}