package com.neetogami.criptoapp.Splash;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;

import com.neetogami.criptoapp.Activities.LoginActivity;
import com.neetogami.criptoapp.Activities.MainActivity;
import com.neetogami.criptoapp.Utils.Util;


public class SplashActivity extends AppCompatActivity {

    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prefs = getSharedPreferences("Preferences", Context.MODE_PRIVATE);
        Intent intentLogin = new Intent(this,LoginActivity.class);
        Intent intentMain = new Intent(this,MainActivity.class);
        if(!TextUtils.isEmpty(Util.getValuePrefs(prefs,"email")) &&
                !TextUtils.isEmpty(Util.getValuePrefs(prefs,"pass"))){
            startActivity(intentMain);
        }else{
            startActivity(intentLogin);
        }
        finish();
    }
}
