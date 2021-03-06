package mooc.vandy.java4android.birthdayprob.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import mooc.vandy.java4android.birthdayprob.ui.OutputInterface;

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
    private static final String TAG =
        Logic.class.getName();

    public static String getTAG() {
        return TAG;
    }

    /**
    * This is the variable that stores our OutputInterface instance.
    * <p>
    * This is how we will interact with the User Interface [MainActivity.java].
    * <p>
    * It is called 'out' because it is where we 'out-put' our
    * results. (It is also the 'in-put' from where we get values from,
    * but it only needs 1 name, and 'out' is good enough)
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
     * on-screen button labelled 'Process...' is pressed.
     */
    public void process() {
        int groupSize = mOut.getSize();
        int simulationCount = mOut.getCount();

        if (groupSize < 2 || groupSize > 365) {
            mOut.makeAlertToast("Group Size must be in the range 2-365.");
            return;
        }

        if (simulationCount <= 0) {
            mOut.makeAlertToast("Simulation Count must be positive.");
            return;
        }

        double percent = calculate(groupSize,
                                   simulationCount);

        // report results
        mOut.println("For a group of " + groupSize + " people, the percentage");
        mOut.println("of times that two people share the same birthday is");
        mOut.println(String.format("%.2f%% of the time.", percent));
    }

    /**
     * This is the method that actually does the calculations.
     * <p>
     * We provide you this method that way we can test it with unit
     * testing.
     */
    public double calculate(int size, int count) {
        // TODO -- add your code here
        List<Integer> probability = new ArrayList<>();
        for (int i = 0; i <count ; i++) {
            List<Integer> randomBirthday = generateBirthdayForGroupOfPeople(size);
            if(compareBirthday(randomBirthday) == -1){
                probability.add(0);
            }
            else{
                probability.add(compareBirthday(randomBirthday));
            }
        }
        double result = 0.0;
        for (int i = 0; i < probability.size(); i++) {
            result += probability.get(i);
        }
        return result/probability.size()*100;
    }

    public static List<Integer> generateBirthdayForGroupOfPeople(int size){
        List<Integer> listPeopleBirthday = new ArrayList<>();
        Random random = new Random();
//        Numbers random = new Numbers();
        for (int i = 0; i <size ; i++) {
            int n = random.nextInt();
            listPeopleBirthday.add(n);
        }
        return listPeopleBirthday;
    }

    public static int compareBirthday(List<Integer> listOfPeopleWithBirthday) {
        int index = -1;
        for (int i = 0; i < listOfPeopleWithBirthday.size() - 1; i++) {
            int compare = listOfPeopleWithBirthday.get(i);
            for (int j = i + 1; j < listOfPeopleWithBirthday.size() - 1; j++) {
                if (compare == listOfPeopleWithBirthday.get(j)) {
                    index = j;
                    break;
                }
            }
            break;
        }
        return index;
    }
}
