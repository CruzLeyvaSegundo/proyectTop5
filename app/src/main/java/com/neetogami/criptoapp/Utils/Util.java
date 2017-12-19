package com.neetogami.criptoapp.Utils;

import android.content.SharedPreferences;


/**
 * Created by segun on 09/12/2017.
 */

public class Util {
    public static String getValuePrefs(SharedPreferences preferences, String keyPrefs){
        return preferences.getString(keyPrefs,"");
    }
    public static void removeUserSharedPreferences(SharedPreferences preferences){
        SharedPreferences.Editor editor = preferences.edit();
        //editor.clear()    //Borra todas las shared preferences
        editor.remove("email");
        editor.remove("pass");
        editor.apply();
    }
}
