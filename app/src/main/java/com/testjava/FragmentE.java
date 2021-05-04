package com.testjava;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentE#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentE extends Fragment {

    public static FragmentE fragmentE;

    public static FragmentE newInstance() {
        if (fragmentE == null)
            fragmentE = new FragmentE();
        return fragmentE;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_e, container, false);
    }
}