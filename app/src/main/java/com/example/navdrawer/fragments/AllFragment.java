package com.example.navdrawer.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.navdrawer.R;

public class AllFragment extends Fragment {

    String title;
    int pgNO;

    public AllFragment(int contentLayoutId, String title, int pgNO) {
        super(contentLayoutId);
        this.title = title;
        this.pgNO = pgNO;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_all,container,false);
    }
}
