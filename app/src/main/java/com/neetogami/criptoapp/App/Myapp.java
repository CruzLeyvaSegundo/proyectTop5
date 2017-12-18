package com.neetogami.criptoapp.App;

import android.app.Application;
import android.os.SystemClock;

/**
 * Created by segun on 09/12/2017.
 */

public class Myapp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SystemClock.sleep(1500);
    }
}
