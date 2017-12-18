package com.neetogami.criptoapp.Utils;

import android.content.SharedPreferences;

import com.neetogami.criptoapp.Models.Country;

import java.util.ArrayList;
import java.util.List;


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
    public static List<Country> getCountries() {
        return new ArrayList<Country>() {{
            add(new Country("España", "ES"));
            add(new Country("Argentina", "AR"));
            add(new Country("Bolivia", "BO"));
            add(new Country("Chile", "CL"));
            add(new Country("Colombia", "CO"));
            add(new Country("Ecuador", "EC"));
            add(new Country("Mexico", "MX"));
            add(new Country("Perú", "PE"));
            add(new Country("Uruguay", "UY"));
            add(new Country("Venezuela", "VE"));
        }};
    }
}
