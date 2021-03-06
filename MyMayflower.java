import mayflower.*;

public class MyMayflower extends Mayflower 
{
    //Constructor
    
    /**
     * Initializes a MyMayflower object
     */
    public MyMayflower()
    {
        //Create a window with 800x600 resolution
        super("Lab 6", 800, 600);
    }
    
    /**
     * Sets this world as the current world
     */
    public void init()
    {
        //Change this to true to run this program in fullscreen mode
        Mayflower.setFullScreen(false);
        World w =  new Title();
        Mayflower.setWorld(w);
    }
}
