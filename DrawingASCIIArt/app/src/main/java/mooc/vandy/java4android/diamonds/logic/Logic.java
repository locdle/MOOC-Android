package mooc.vandy.java4android.diamonds.logic;

import mooc.vandy.java4android.diamonds.ui.OutputInterface;

/**
 * This is where the logic of this App is centralized for this assignment.
 * <p>
 * The assignments are designed this way to simplify your early
 * Android interactions.  Designing the assignments this way allows
 * you to first learn key 'Java' features without having to beforehand
 * learn the complexities of Android.
 */
public class Logic
       implements LogicInterface {
    /**
     * This is a String to be used in Logging (if/when you decide you
     * need it for debugging).
     */
    public static final String TAG = Logic.class.getName();

    /**
     * This is the variable that stores our OutputInterface instance.
     * <p>
     * This is how we will interact with the User Interface [MainActivity.java].
     * <p>
     * It is called 'out' because it is where we 'out-put' our
     * results. (It is also the 'in-put' from where we get values
     * from, but it only needs 1 name, and 'out' is good enough).
     */
    private OutputInterface mOut;

    /**
     * This is the constructor of this class.
     * <p>
     * It assigns the passed in [MainActivity] instance (which
     * implements [OutputInterface]) to 'out'.
     */
    public Logic(OutputInterface out){
        mOut = out;
    }

    /**
     * This is the method that will (eventually) get called when the
     * on-screen button labeled 'Process...' is pressed.
     */
    public void process(int size) {

        // TODO -- add your code here
        drawTopOrBottomLine(size);

        drawTopDiamond(size, '/', '\\');

        drawDiamondLine(size, size, '<', '>');

        drawBottomDiamond(size, '\\', '/');

        drawTopOrBottomLine(size);
    }

    private void drawBottomDiamond(int size, char begin, char end) {
        for (int i = size - 1; i >= 1; i--) {
            drawDiamondLine(i, size, begin, end);
        }
    }

    private void drawTopDiamond(int size, char begin, char end) {
        for (int i = 1; i < size; i++) {
            drawDiamondLine(i, size, begin, end);
        }
    }

    private void drawTopOrBottomLine(int size) {
        mOut.print("+");
        for (int i = 0; i < 2*size; i++){
            mOut.print("-");
        }
        mOut.println("+");

    }

     // TODO -- add your code here
     public void drawDiamondLine(int line, int size, char firstCharacter, char lastCharacter) {
         char body = getBody(line);

         mOut.print("|");
         indent(line, size);
         mOut.print(firstCharacter);
         drawDiamondBody(line, body);
         mOut.print(lastCharacter);
         indent(line, size);
         mOut.println("|");
     }

    private void drawDiamondBody(int line, char body) {
        for (int i = 1; i < line * 2 - 1 ; i++) {
            mOut.print(body);
        }
    }

    private void indent(int line, int size) {
        for (int i = 0; i < size - line ; i++) {
            mOut.print(' ');
        }
    }

    private char getBody(int line) {
        char body;
        if (line % 2 == 0 ) {
            body = '-';
        } else {
            body = '=';
        }
        return body;
    }
}
