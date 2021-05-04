package com.testjava;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentB#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentB extends Fragment {

    public static FragmentB fragmentB;
    private static final String TAG = FragmentB.class.getSimpleName();

    public static FragmentB newInstance() {
        if (fragmentB == null)
            fragmentB = new FragmentB();
        return fragmentB;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView: " + "Fragment B called");
        return inflater.inflate(R.layout.fragment_b, container, false);
    }
}