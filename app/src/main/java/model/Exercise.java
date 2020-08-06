package model;


import android.content.SharedPreferences;

import com.example.connectionwithbeing.R;

import java.util.HashMap;


//Model class holding all Exercise data.

 /*
 Self = 1
 Others = 2
 Nature = 3
 Society = 4
*/

public class Exercise {

    //Default constructor
    public Exercise() {}

    //Shared Preferences for the Exercise Menu. Controls yellow star on completion for each category.
    public static final String userActivityProgress = "exercises_completed"; //This is the main references key for all shared prefs.

    //Keys for building static HashMaps
    public static final String exercise1ImageKey = "exercise1_image";
    public static final String exercise2ImageKey = "exercise2_image";
    public static final String exercise3ImageKey = "exercise3_image";
    public static final String exercise4ImageKey = "exercise4_image";
    public static final String exercise5ImageKey  = "exercise5_image";
    public static final String exercise6ImageKey = "exercise6_image";


    public static final String exercise1StringKey = "exercise1_text";
    public static final String exercise2StringKey = "exercise2_text";
    public static final String exercise3StringKey = "exercise3_text";
    public static final String exercise4StringKey = "exercise4_text";
    public static final String exercise5StringKey  = "exercise5_text";
    public static final String exercise6StringKey = "exercise6_text";




    public static final String userSelfProgress="self_exercises_completed";

    public static final String selfE1 = "selfE1";
    public static final String selfE2 = "selfE2";
    public static final String selfE3 = "selfE3";
    public static final String selfE4 = "selfE4";
    public static final String selfE5 = "selfE5";
    public static final String selfE6 = "selfE6";

    public static int selfE1Completed = 0;
    public static int selfE2Completed = 0;
    public static int selfE3Completed = 0;
    public static int selfE4Completed = 0;
    public static int selfE5Completed = 0;
    public static int selfE6Completed = 0;




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


    public static final String userSocietyProgress="self_exercises_completed";

    public static final String societyE1 = "societyE1";
    public static final String societyE2 = "societyE2";
    public static final String societyE3 = "societyE3";
    public static final String societyE4 = "societyE4";
    public static final String societyE5 = "societyE5";
    public static final String societyE6 = "societyE6";

    public static int societyE1Completed = 0;
    public static int societyE2Completed = 0;
    public static int societyE3Completed = 0;
    public static int societyE4Completed = 0;
    public static int societyE5Completed = 0;
    public static int societyE6Completed = 0;




    public static final int[] selfExerciseTitles = {R.string.self_e1_title, R.string.self_e2_title, R.string.self_e3_title,
    R.string.self_e4_title, R.string.self_e5_title, R.string.self_e6_title};

    private static final String[] selfKeys = {selfE1, selfE2, selfE3, selfE4, selfE5, selfE6};

    private static final int[] selfValues = {selfE1Completed, selfE2Completed, selfE3Completed, selfE4Completed,
    selfE5Completed, selfE6Completed};

    private static final HashMap<String, Integer> selfExerciseImages = new HashMap<>();

    static {
        selfExerciseImages.put(exercise1ImageKey, R.drawable.selfexerciseoneimage);
        selfExerciseImages.put(exercise2ImageKey, R.drawable.selfexercisetwoimage);
        selfExerciseImages.put(exercise3ImageKey, R.drawable.selfexercisethreeimage);
        selfExerciseImages.put(exercise4ImageKey, R.drawable.selfexercisefourimage);
        selfExerciseImages.put(exercise5ImageKey, R.drawable.selfexercisefiveimage);
        selfExerciseImages.put(exercise6ImageKey, R.drawable.selfexercisesiximage);
    }

    private static final HashMap<String, Integer> selfExerciseStrings = new HashMap<>();

    static {
        selfExerciseStrings.put(exercise1StringKey, R.string.self_e1_text);
        selfExerciseStrings.put(exercise2StringKey, R.string.self_e2_text);
        selfExerciseStrings.put(exercise3StringKey, R.string.self_e3_text);
        selfExerciseStrings.put(exercise4StringKey, R.string.self_e4_text);
        selfExerciseStrings.put(exercise5StringKey, R.string.self_e5_text);
        selfExerciseStrings.put(exercise6StringKey, R.string.self_e6_text);
    }



    public static final int[] othersExerciseTitles = {R.string.others_e1_title, R.string.others_e2_title,
            R.string.others_e3_title,R.string.others_e4_title, R.string.others_e5_title, R.string.others_e6_title};

    private static final String[] othersKeys = {othersE1, othersE2, othersE3, othersE4, othersE5, othersE6};

    private static final int[] othersValues = {othersE1Completed, othersE2Completed,
            othersE3Completed, othersE4Completed, othersE5Completed, othersE6Completed};

    private static final HashMap<String, Integer> otherExerciseImages = new HashMap<>();

    static {
        otherExerciseImages.put(exercise1ImageKey, R.drawable.othersexerciseoneimage);
        otherExerciseImages.put(exercise2ImageKey, R.drawable.othersexercisetwoimage);
        otherExerciseImages.put(exercise3ImageKey, R.drawable.othersexercisethreeimage);
        otherExerciseImages.put(exercise4ImageKey, R.drawable.othersexercisefourimage);
        otherExerciseImages.put(exercise5ImageKey, R.drawable.othersexercisefiveimage);
        otherExerciseImages.put(exercise6ImageKey, R.drawable.othersexercisesiximage);
    }

    private static final HashMap<String, Integer> otherExerciseStrings = new HashMap<>();

    static {
        otherExerciseStrings.put(exercise1StringKey, R.string.others_e1_text);
        otherExerciseStrings.put(exercise2StringKey, R.string.others_e2_text);
        otherExerciseStrings.put(exercise3StringKey, R.string.others_e3_text);
        otherExerciseStrings.put(exercise4StringKey, R.string.others_e4_text);
        otherExerciseStrings.put(exercise5StringKey, R.string.others_e5_text);
        otherExerciseStrings.put(exercise6StringKey, R.string.others_e6_text);
    }



    public static final int[] natureExerciseTitles = {R.string.nature_e1_title,R.string.nature_e2_title, R.string.nature_e3_title,
            R.string.nature_e4_title, R.string.nature_e5_title, R.string.nature_e6_title};

    private final String[] natureKeys = {natureE1, natureE2, natureE3, natureE4, natureE5, natureE6};

    private final int[] natureValues = {natureE1Completed, natureE2Completed, natureE3Completed,
            natureE4Completed, natureE5Completed, natureE6Completed};

    //HashMaps holding all drawable and String ids for exercises

    private static final HashMap<String, Integer> natureExerciseImages = new HashMap<>();

    static {
        natureExerciseImages.put(exercise1ImageKey, R.drawable.natureexerciseoneimage);
        natureExerciseImages.put(exercise2ImageKey, R.drawable.natureexercisetwoimage);
        natureExerciseImages.put(exercise3ImageKey, R.drawable.natureexercisethreeimage);
        natureExerciseImages.put(exercise4ImageKey, R.drawable.natureexercisefourimage);
        natureExerciseImages.put(exercise5ImageKey, R.drawable.natureexercisefive);
        natureExerciseImages.put(exercise6ImageKey, R.drawable.natureexercisesiximage);
    }

    private static final HashMap<String, Integer> natureExerciseStrings = new HashMap<>();

    static {
        natureExerciseStrings.put(exercise1StringKey, R.string.nature_e1_text);
        natureExerciseStrings.put(exercise2StringKey, R.string.nature_e2_text);
        natureExerciseStrings.put(exercise3StringKey, R.string.nature_e3_text);
        natureExerciseStrings.put(exercise4StringKey, R.string.nature_e4_text);
        natureExerciseStrings.put(exercise5StringKey, R.string.nature_e5_text);
        natureExerciseStrings.put(exercise6StringKey, R.string.nature_e6_text);

    }



    public static int[] societyExerciseTitles = {R.string.society_e1_title, R.string.society_e2_title, R.string.society_e3_title,
            R.string.society_e4_title, R.string.society_e5_title, R.string.society_e6_title};

    private static final String[] societyKeys = {societyE1, societyE2, societyE3, societyE4, societyE5, societyE6};
    private static final int[] societyValues = {societyE1Completed, societyE2Completed, societyE3Completed, societyE4Completed,
            societyE5Completed, societyE6Completed};

    private static final HashMap<String, Integer> societyExerciseImages = new HashMap<>();

    static {
        societyExerciseImages.put(exercise1ImageKey, R.drawable.societyexerciseoneimage);
        societyExerciseImages.put(exercise2ImageKey, R.drawable.societyexercisetwoimage);
        societyExerciseImages.put(exercise3ImageKey, R.drawable.societyexercisethreeimage);
        societyExerciseImages.put(exercise4ImageKey, R.drawable.societyexercisefourimage);
        societyExerciseImages.put(exercise5ImageKey, R.drawable.societyexercisefiveimage);
        societyExerciseImages.put(exercise6ImageKey, R.drawable.societyexercisesiximage);
    }

    private static final HashMap<String, Integer> societyExerciseStrings = new HashMap<>();

    static {
        societyExerciseStrings.put(exercise1StringKey, R.string.society_e1_text);
        societyExerciseStrings.put(exercise2StringKey, R.string.society_e2_text);
        societyExerciseStrings.put(exercise3StringKey, R.string.society_e3_text);
        societyExerciseStrings.put(exercise4StringKey,R.string.society_e4_text);
        societyExerciseStrings.put(exercise5StringKey,R.string.society_e5_text);
        societyExerciseStrings.put(exercise6StringKey,R.string.society_e6_text);
    }




    public String[] getSocietyKeys() {
        return societyKeys;
    }

    public int[] getSocietyValues() {
        return societyValues;
    }

    public HashMap<String, Integer> getSocietyExerciseImages() {
        return societyExerciseImages;
    }

    public HashMap<String, Integer> getSocietyExerciseStrings() {
        return societyExerciseStrings;
    }

    public String[] getSelfKeys() {
        return selfKeys;
    }

    public int[] getSelfValues() {
        return selfValues;
    }

    public HashMap<String, Integer> getSelfExerciseImages() {
        return selfExerciseImages;
    }

    public HashMap<String, Integer> getSelfExerciseStrings() {
        return selfExerciseStrings;
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

}
