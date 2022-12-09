package com.example.myapplication;

import android.content.Intent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.Timer;
import java.util.TimerTask;


public class SwipePagerAdapter  extends FragmentStatePagerAdapter{


    public musicFragment musicFragment;
    public radarFragment radarFragment;


    public SwipePagerAdapter(@NonNull FragmentManager fm) {
        super(fm);

        musicFragment = new musicFragment();





    }

    @NonNull
    @Override

    public Fragment getItem(int position) {

        switch (position){
            case 0:
                return musicFragment;



        }

        return null;
    }

    @Override
    public int getCount() {
        return 1;
    }



}
