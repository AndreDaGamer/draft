import mayflower.*;

public class Dog extends AnimatedActor
{
    String[] frames;
    private int currentFrame;
    private Animation walkRight;
    private Animation walkLeft;
    String str;
    /**
     * Initializes a Dog object
     */
    public Dog()
    {
        currentFrame = 0;
        str = "";
        
        frames = new String[10];
        for (int i = 0; i < frames.length; i++){
            frames[i] = new String("img/dog/Walk (" + (i+1) +").png");
        }
        walkRight= new Animation(50,frames);
        walkRight.changeScale(100, 87);
        walkRight.setBounds(18,5,54,80);
        
        walkLeft = new Animation(60, frames);
        walkLeft.changeScale(100, 87);
        walkLeft.flipHorizontally();
        walkLeft.setBounds(28,5,54,80);
        
        setAnimation(walkRight);
    }
    
    /**
     * Sets the left and right walking animations for the Dog object
     * Decreases a life and moves Cat object if Cat Object touches Dog object
     * Removes Cat object from world if lives is equal to zero
     */
    public void act()
    {
        
        super.act();
        if(str.equals("")){
            setLocation(getX() +2, getY());
        }
        if(getX()-18 == 454){
            setAnimation(walkLeft);
            str = "walkLeft";
        }if(getX()-18 == 254){
            setAnimation(walkRight);
            str = "walkRight";
        }
        
        if(str.equals("walkRight")){
            setLocation(getX() +2, getY());
        }else if(str.equals("walkLeft")){
            setLocation(getX() -2,getY());
        }
        
        if(isTouching(Cat.class)){
            Object a = getOneIntersectingObject(Cat.class);
            Cat c = (Cat) a;
            World w = getWorld();
            
            c.setLocation(600,200);
            c.decreaseLives(1);
            if(c.getLives() == 0){
                w.removeObject(c);
                
            }
        }
    }
}