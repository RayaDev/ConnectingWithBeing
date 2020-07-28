package model;


import android.content.SharedPreferences;

import com.example.connectionwithbeing.R;

import java.util.HashMap;


//Model class holding all Exercise data.

public class Exercise {



    //Default constructor
    public Exercise() {}

    //Shared Preferences for the Exercise Menu. Controls yellow star on completion for each category.
    public static final String userActivityProgress = "exercises_completed"; //This is the main references key for all shared prefs.

//    public static SharedPreferences natureSharedPreferences;
    public static final String userNatureProgress = "nature_exercises_completed";

    //Keys
    public static  final String natureE1 = "natureE1";
    public static final String natureE2 = "natureE2";
    public static final String natureE3 = "natureE3";
    public static final String natureE4 = "natureE4";
    public static final String natureE5 = "natureE5";
    public static final String natureE6 = "natureE6";

    //Values
    public static int natureE1Completed = 0;
    public static int natureE2Completed = 0;
    public static int natureE3Completed = 0;
    public static int natureE4Completed = 0;
    public static int natureE5Completed = 0;
    public static int natureE6Completed = 0;


    private final String[] natureKeys = {natureE1, natureE2, natureE3, natureE4, natureE5, natureE6};

    private final int[] natureValues = {natureE1Completed, natureE2Completed, natureE3Completed,
            natureE4Completed, natureE5Completed, natureE6Completed};

//    public static SharedPreferences othersSharedPreferences;
    public static final String userOthersProgress = "others_exercises_completed";

    public static final String othersE1 = "othersE1";
    public static final String othersE2 = "othersE2";
    public static final String othersE3 = "othersE3";
    public static final String othersE4 = "othersE4";
    public static final String othersE5 = "othersE5";
    public static final String othersE6 = "othersE6";

    public static int othersE1Completed = 0;
    public static int othersE2Completed = 0;
    public static int othersE3Completed = 0;
    public static int othersE4Completed = 0;
    public static int othersE5Completed = 0;
    public static int othersE6Completed = 0;


    private static final String[] othersKeys = {othersE1, othersE2, othersE3, othersE4, othersE5, othersE6};

    private static final int[] othersValues = {othersE1Completed, othersE2Completed,
            othersE3Completed, othersE4Completed, othersE5Completed, othersE6Completed};


    //HashMaps holding all drawable and String ids for exercises

    private static final HashMap<String, Integer> natureExerciseImages = new HashMap<>();

    static {
        natureExerciseImages.put("exercise1_image", R.drawable.bigtree);
        natureExerciseImages.put("exercise2_image", R.drawable.bookmark);
    }

    private static final HashMap<String, Integer> natureExerciseStrings = new HashMap<>();

    static {
        natureExerciseStrings.put("exercise1_text", R.string.exercise1_center_text_string);
        natureExerciseStrings.put("exercise2_text", R.string.exercise2_center_text_string);
        natureExerciseStrings.put("exercise3_text", R.string.app_name);
    }


    private static final HashMap<String, Integer> otherExerciseImages = new HashMap<>();

    static {
        otherExerciseImages.put("exercise1_image", R.drawable.cwblogotest);
        otherExerciseImages.put("exercise2_image", R.drawable.othershomepng);
    }


    private static final HashMap<String, Integer> otherExerciseStrings = new HashMap<>();

    static {
        otherExerciseStrings.put("exercise1_text", R.string.nature_e1_q3_text);
        otherExerciseStrings.put("exercise2_text", R.string.nature_e1_q1_text);
        otherExerciseStrings.put("exercise2_text", R.string.nature_e1_q3_text);
    }


    public String[] getNatureKeys() {
        return natureKeys;
    }

    public int[] getNatureValues() {
        return natureValues;
    }

    public HashMap<String, Integer> getNatureExerciseImages() {
        return natureExerciseImages;
    }

    public HashMap<String, Integer> getNatureExerciseStrings() {
        return natureExerciseStrings;
    }

    public String[] getOthersKeys() {
        return othersKeys;
    }

    public int[] getOthersValues() {
        return othersValues;
    }

    public HashMap<String, Integer> getOtherExerciseStrings() {
        return otherExerciseStrings;
    }

    public HashMap<String, Integer> getOtherExerciseImages() {
        return otherExerciseImages;
    }

}
