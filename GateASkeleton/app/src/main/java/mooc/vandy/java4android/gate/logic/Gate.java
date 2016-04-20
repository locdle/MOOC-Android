package mooc.vandy.java4android.gate.logic;

/**
 * @@ Julie, please fill in here.
 */
public class Gate {
    // TODO -- Fill in your code here
    public static final  int IN = 1;
    public static final int OUT = -1;
    private boolean locked;
    private int swing;

    public Gate() {
        locked = true;
        swing = 0;
    }

    public boolean setSwing(int direction){
        if(direction == IN){
            this.swing = IN;
            return true;
        }
        else if(direction == OUT){
            this.swing = OUT;
            return true;
        }
        else return false;
    }

    //TODO implement open method
    public boolean open(int direction){
        if (direction == IN){
            swing = IN;
            locked = false;
            return locked;
        }
        else if (direction == OUT){
            swing = OUT;
            return locked;
        }
        else{
            return locked;
        }
    }

    public void close() {
    }

    public boolean isLocked() {
        return locked;
    }

    public int getSwingDirection() {
        return swing;
    }

    public int thru(int count){
        if (swing == IN) return count;
        else if(swing == OUT) return -count;
        else return 0;
    }

    public String toString(){
        if(locked){
            return "This gate is locked";
        }
        else if (locked && swing == IN){
            return "This gate is not locked and swings to enter the pen only";
        }
        else if (locked && swing == OUT){
            return "This gate is not locked and swings to exit the pen only";
        }
        else return  "This gate is not locked and swings but the swing is not set properly";
    }

}
