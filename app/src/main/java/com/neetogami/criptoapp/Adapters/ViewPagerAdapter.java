package com.neetogami.criptoapp.Adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.neetogami.criptoapp.Fragments.CuentaFragment;
import com.neetogami.criptoapp.Fragments.CursosFragment;

import static com.neetogami.criptoapp.Activities.MainActivity.PERSON_CUENTA_FRAGMENT;
import static com.neetogami.criptoapp.Activities.MainActivity.PERSON_CURSOS_FRAGMENT;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private int numberOfTabs;
    private String user;

    public ViewPagerAdapter(FragmentManager fm, Context context, int numberOfTabs, String user) {
        super(fm);
        this.numberOfTabs = numberOfTabs;
        this.user = user;
    }


    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case PERSON_CUENTA_FRAGMENT:
                {

                    CuentaFragment cuenta = new CuentaFragment();
                    cuenta.sendUser(user);
                    return cuenta;
                }
            case PERSON_CURSOS_FRAGMENT:
            {
                CursosFragment cuenta = new CursosFragment();
                cuenta.sendUser(user);
                return cuenta;
            }
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
