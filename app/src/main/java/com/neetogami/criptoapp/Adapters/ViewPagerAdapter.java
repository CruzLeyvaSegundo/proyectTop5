package com.neetogami.criptoapp.Adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.neetogami.criptoapp.Fragments.CuentaFragment;
import com.neetogami.criptoapp.Fragments.CursosFragment;
import com.neetogami.criptoapp.Fragments.test;

import static com.neetogami.criptoapp.Activities.MainActivity.PERSON_CUENTA_FRAGMENT;
import static com.neetogami.criptoapp.Activities.MainActivity.PERSON_CURSOS_FRAGMENT;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private int numberOfTabs;


    public ViewPagerAdapter(FragmentManager fm, Context context, int numberOfTabs) {
        super(fm);
        this.numberOfTabs = numberOfTabs;
    }


    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case PERSON_CUENTA_FRAGMENT:
                return new CuentaFragment();
            case PERSON_CURSOS_FRAGMENT:
                return new CursosFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }

}
