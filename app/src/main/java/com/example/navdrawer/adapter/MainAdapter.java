package com.example.navdrawer.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.navdrawer.R;

import java.util.ArrayList;

public class MainAdapter extends FragmentPagerAdapter {

    Context context;
    public static final int[] TAB_TITLE = new int[]{R.string.all,R.string.folder};

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return context.getResources().getString(TAB_TITLE[position]);
    }

    ArrayList<Fragment> fragments;

    public MainAdapter(@NonNull FragmentManager fm,Context context,ArrayList<Fragment> fragments) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.context = context;
        this.fragments = fragments;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
