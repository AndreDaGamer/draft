import mayflower.*;

public class Animation
{
    private MayflowerImage[] frames;
    private int frameRate;
    private int currentFrame;
    
    /**
     * Initializes an Animation object.
     * Precondition: Animation object must take an int fr and String[] frames.
     * Postcondition: Instance variables int frameRate and MayflowerImage[] frames are initialized with int fr and 
     * (MayflowerImage) frames.length
     * 
     * @param fr - int that initializes instance variable frameRate for Animation object
     * @param frames - length of String array initializes instance variable frame's length for Animation object
     */
    public Animation(int fr, String[] frames)
    {
        currentFrame = 0;
        this.frames = new MayflowerImage[frames.length];
        frameRate = fr;
        for(int i = 0; i < frames.length; i++)
        {
            this.frames[i] = new MayflowerImage(frames[i]);
        }
    }
    
    /**
     * Returns the int frameRate of a given Animation object.
     * Precondition: Animation object must be initialized.
     * Postcondition: Returns int frameRate accessed from the Animation object.
     * 
     * @return frameRate - the frameRate of the Animation object
     */
    public int getFrameRate()
    {
        return frameRate;
    }
    
    /**
     * Scales the images in the MayflowerImage[] frames to a double amount.
     * Precondition: changeScale method must take a double amount
     * Postcondition: Instance  variable MayflowerImage[] frames is scaled to double amount
     * 
     * @param amount - double to be used as the actual paramater in the scale(double x) method
     */
    public void changeScale(double proportion)
    {
        for(int i = 0; i < frames.length; i++)
        {
            frames[i].scale(proportion);
        }
    }
    
    /**
     * Scales the images in the MayflowerImage[] frames to an int height and int width.
     * Precondition: changeScale method must take an int height and int width
     * Postcondition: Instance  variable MayflowerImage[] frames is scaled to an int height and int width
     * 
     * @param height - int to fill height parameter in scale method
     * @param width - int to fill width parameter in scale method
     */
    public void changeScale(int height, int width)
    {
        for(int i = 0; i < frames.length; i++)
        {
            frames[i].scale(height, width);
        }
    }
    
    /**
     * Flips the array of MayflowerImages array horizontally
     * Precondition: MayflowerImage[] frames must be initialized
     * Postcondition: Instance variable MayflowerImage[] frames is flipped horizontally.
     */
    public void flipHorizontally()
    {
        for(int i = 0; i < frames.length; i++)
        {
            frames[i].mirrorHorizontally();
        }
    }
    
    /**
     * Returns the MayflowerImage nextFrame of a given Animation object.
     * Precondition: Animation object must be initialized.
     * Postcondition: Returns currentFrame + 1 or MayflowerImage nextFrame of the given Animation object.
     * 
     * @return nextFrame - the nextFrame of the current Animation object.
     */
    public MayflowerImage getNextFrame()
    {
        MayflowerImage temp = frames[currentFrame];
        currentFrame++;
        if(currentFrame >= frames.length)
        {
            currentFrame = 0;
        }
        return temp;
    }
    
    /**
     * Sets the bounds for the Animation object by cropping variable MayflowerImage[] frames.
     * Precondition: setBounds method must take an int x, int y, int w, and int h
     * Postcondition: Animation object is cropped with values of int x, int y, int w, and int h
     * 
     * @param x - int to fill x paramater in crop method
     * @param y - int to fill y paramater in crop method
     * @param w - int to fill w paramater in crop method
     * @param h - int to fill h paramater in crop method
     */
    public void setBounds(int x, int y, int w, int h)
    {
        for(int i = 0; i < frames.length; i++)
        {
            frames[i].crop(x, y, w, h);
        }
    }
}
