package com.testjava;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentD#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentD extends Fragment {

    public static FragmentD fragmentD;

    public static FragmentD newInstance() {
        if (fragmentD == null)
            fragmentD = new FragmentD();
        return fragmentD;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_d, container, false);
    }
}