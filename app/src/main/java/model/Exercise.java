package model;


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

    //Keys for referencing completed number on main menu.
    public static final String othersProgress = "others_progress";
    public static final String natureProgress = "nature_progress";
    public static final String societyProgress= "society_progress";
    public static final String selfProgress = "self_progress";

    //Keys
    public static final String menuCategory = "menu_category";

    //Values, passed as extra for determining which menu to construct.
    public static final int selfMenu = 1;
    public static final int othersMenu = 2;
    public static final int natureMenu = 3;
    public static final int societyMenu = 4;


    //Default constructor
    public Exercise() {}

    //Shared Preferences for the Exercise Menu. Controls yellow star on completion for each category. And exercise completion count.
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

    public static final String selfE1CompletedKey = "selfE1";
    public static final String selfE2CompletedKey = "selfE2";
    public static final String selfE3CompletedKey = "selfE3";
    public static final String selfE4CompletedKey = "selfE4";
    public static final String selfE5CompletedKey = "selfE5";
    public static final String selfE6CompletedKey = "selfE6";


    public static final String othersE1CompletedKey = "othersE1";
    public static final String othersE2CompletedKey = "othersE2";
    public static final String othersE3CompletedKey = "othersE3";
    public static final String othersE4CompletedKey = "othersE4";
    public static final String othersE5CompletedKey = "othersE5";
    public static final String othersE6CompletedKey = "othersE6";



    //Keys
    public static  final String natureE1CompletedKey = "natureE1";
    public static final String natureE2CompletedKey = "natureE2";
    public static final String natureE3CompletedKey = "natureE3";
    public static final String natureE4CompletedKey = "natureE4";
    public static final String natureE5CompletedKey = "natureE5";
    public static final String natureE6CompletedKey = "natureE6";


    public static final String societyE1CompletedKey = "societyE1";
    public static final String societyE2CompletedKey = "societyE2";
    public static final String societyE3CompletedKey = "societyE3";
    public static final String societyE4CompletedKey = "societyE4";
    public static final String societyE5CompletedKey = "societyE5";
    public static final String societyE6CompletedKey = "societyE6";




    public static final int[] selfExerciseTitles = {R.string.self_e1_title, R.string.self_e2_title, R.string.self_e3_title,
    R.string.self_e4_title, R.string.self_e5_title, R.string.self_e6_title};

    public static final String[] selfKeys = {selfE1CompletedKey, selfE2CompletedKey, selfE3CompletedKey, selfE4CompletedKey, selfE5CompletedKey, selfE6CompletedKey};


    public static final HashMap<String, Integer> selfExerciseImages = new HashMap<>();

    static {
        selfExerciseImages.put(exercise1ImageKey, R.drawable.selfexerciseoneimage);
        selfExerciseImages.put(exercise2ImageKey, R.drawable.selfexercisetwoimage);
        selfExerciseImages.put(exercise3ImageKey, R.drawable.selfexercisethreeimage);
        selfExerciseImages.put(exercise4ImageKey, R.drawable.selfexercisefourimage);
        selfExerciseImages.put(exercise5ImageKey, R.drawable.selfexercisefiveimage);
        selfExerciseImages.put(exercise6ImageKey, R.drawable.selfexercisesiximage);
    }

    public static final HashMap<String, Integer> selfExerciseStrings = new HashMap<>();

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

    public static final String[] othersKeys = {othersE1CompletedKey, othersE2CompletedKey, othersE3CompletedKey, othersE4CompletedKey, othersE5CompletedKey, othersE1CompletedKey};

    public static final HashMap<String, Integer> otherExerciseImages = new HashMap<>();

    static {
        otherExerciseImages.put(exercise1ImageKey, R.drawable.othersexerciseoneimage);
        otherExerciseImages.put(exercise2ImageKey, R.drawable.othersexercisetwoimage);
        otherExerciseImages.put(exercise3ImageKey, R.drawable.othersexercisethreeimage);
        otherExerciseImages.put(exercise4ImageKey, R.drawable.othersexercisefourimage);
        otherExerciseImages.put(exercise5ImageKey, R.drawable.othersexercisefiveimage);
        otherExerciseImages.put(exercise6ImageKey, R.drawable.othersexercisesiximage);
    }

    public static final HashMap<String, Integer> otherExerciseStrings = new HashMap<>();

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

    public static final String[] natureKeys = {natureE1CompletedKey, natureE2CompletedKey, natureE3CompletedKey, natureE4CompletedKey, natureE5CompletedKey, natureE6CompletedKey};


    //HashMaps holding all drawable and String ids for exercises

    public static final HashMap<String, Integer> natureExerciseImages = new HashMap<>();

    static {
        natureExerciseImages.put(exercise1ImageKey, R.drawable.natureexerciseoneimage);
        natureExerciseImages.put(exercise2ImageKey, R.drawable.natureexercisetwoimage);
        natureExerciseImages.put(exercise3ImageKey, R.drawable.natureexercisethreeimage);
        natureExerciseImages.put(exercise4ImageKey, R.drawable.natureexercisefourimage);
        natureExerciseImages.put(exercise5ImageKey, R.drawable.natureexercisefive);
        natureExerciseImages.put(exercise6ImageKey, R.drawable.natureexercisesiximage);
    }

    public static final HashMap<String, Integer> natureExerciseStrings = new HashMap<>();

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

    public static final String[] societyKeys = {societyE1CompletedKey, societyE2CompletedKey, societyE3CompletedKey, societyE4CompletedKey, societyE5CompletedKey, societyE6CompletedKey};


    public static final HashMap<String, Integer> societyExerciseImages = new HashMap<>();

    static {
        societyExerciseImages.put(exercise1ImageKey, R.drawable.societyexerciseoneimage);
        societyExerciseImages.put(exercise2ImageKey, R.drawable.societyexercisetwoimage);
        societyExerciseImages.put(exercise3ImageKey, R.drawable.societyexercisethreeimage);
        societyExerciseImages.put(exercise4ImageKey, R.drawable.societyexercisefourimage);
        societyExerciseImages.put(exercise5ImageKey, R.drawable.societyexercisefiveimage);
        societyExerciseImages.put(exercise6ImageKey, R.drawable.societyexercisesiximage);
    }

    public static final HashMap<String, Integer> societyExerciseStrings = new HashMap<>();

    static {
        societyExerciseStrings.put(exercise1StringKey, R.string.society_e1_text);
        societyExerciseStrings.put(exercise2StringKey, R.string.society_e2_text);
        societyExerciseStrings.put(exercise3StringKey, R.string.society_e3_text);
        societyExerciseStrings.put(exercise4StringKey,R.string.society_e4_text);
        societyExerciseStrings.put(exercise5StringKey,R.string.society_e5_text);
        societyExerciseStrings.put(exercise6StringKey,R.string.society_e6_text);
    }


}
