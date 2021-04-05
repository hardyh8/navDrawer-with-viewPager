package com.example.navdrawer.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.navdrawer.R;
import com.example.navdrawer.adapter.MainAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    Context context;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.content_main,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        context = view.getContext();

        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new AllFragment(R.layout.fragment_all,getString(R.string.all),0));
        fragments.add(new FolderFragment(R.layout.fragment_folder,getString(R.string.folder),1));

        ViewPager viewPager = view.findViewById(R.id.viewPager);
        MainAdapter adapter = new MainAdapter(getActivity().getSupportFragmentManager(),context,fragments);
        viewPager.setAdapter(adapter);

        TabLayout tabs = view.findViewById(R.id.tab_layout);
        tabs.setupWithViewPager(viewPager);

    }
}
