package mooc.vandy.java4android.gate.logic.tools;

import android.util.Log;

import org.junit.Test;

import java.io.File;

import mooc.vandy.java4android.gate.logic.GateUnitTests;

/**
 * IGNORE THIS CLASS.
 * <p>
 * This class exists to assist in the auto-grading framework that we have developed.
 * Knowledge of this class and how it works will not be required in this course at all.
 */
public class AutoGrader {

    @Test
    public void mainTest(){
        try {
            AndroidHandinUtil.generateHandinPackage("Asgn2", new File("./"),
                    GateUnitTests.class);
        }catch(Exception e){
            Log.d("AutoGrader :", e.getMessage());
        }

    }
}
