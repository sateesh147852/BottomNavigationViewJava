package com.testjava;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.testjava.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private ActivityMainBinding binding;
    private BottomNavigationView bottomNavigationView;
    private long backPressedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initializeToolBar();
        initializeViews();
    }

    private void initializeToolBar() {
        setSupportActionBar(binding.commonToolBar.toolBar);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        Toolbar toolbar = binding.commonToolBar.toolBar;
        toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
        toolbar.setNavigationOnClickListener(v -> onBackPressed());
        AppCompatTextView tvTitle = toolbar.findViewById(R.id.tvTitle);
        tvTitle.setText("Home");
    }

    private void initializeViews() {
        bottomNavigationView = binding.btNavigation;
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        loadFragment(FragmentA.newInstance(), 0);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                loadFragment(FragmentA.newInstance(), 0);
                return true;
            case R.id.feed:
                loadFragment(FragmentB.newInstance(), 1);
                return true;
            case R.id.history:
                loadFragment(FragmentC.newInstance(), 2);
                return true;
            case R.id.profile:
                loadFragment(FragmentD.newInstance(), 3);
                return true;
            case R.id.details:
                loadFragment(FragmentE.newInstance(), 4);
                return true;
        }
        return true;
    }

    private void loadFragment(Fragment fragment, int position) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        switch (position) {
            case 0:
                if (FragmentB.newInstance().isAdded())
                    fragmentTransaction.hide(FragmentB.newInstance());
                if (FragmentC.newInstance().isAdded())
                    fragmentTransaction.hide(FragmentC.newInstance());
                if (FragmentD.newInstance().isAdded())
                    fragmentTransaction.hide(FragmentD.newInstance());
                if (FragmentE.newInstance().isAdded())
                    fragmentTransaction.hide(FragmentE.newInstance());
                if (FragmentA.newInstance().isAdded())
                    fragmentTransaction.show(FragmentA.newInstance());
                else
                    fragmentTransaction.add(R.id.flContainer, fragment);
                break;


            case 1:
                if (FragmentA.newInstance().isAdded())
                    fragmentTransaction.hide(FragmentA.newInstance());
                if (FragmentC.newInstance().isAdded())
                    fragmentTransaction.hide(FragmentC.newInstance());
                if (FragmentD.newInstance().isAdded())
                    fragmentTransaction.hide(FragmentD.newInstance());
                if (FragmentE.newInstance().isAdded())
                    fragmentTransaction.hide(FragmentE.newInstance());
                if (FragmentB.newInstance().isAdded())
                    fragmentTransaction.show(FragmentB.newInstance());
                else
                    fragmentTransaction.add(R.id.flContainer, fragment);
                break;

            case 2:
                if (FragmentA.newInstance().isAdded())
                    fragmentTransaction.hide(FragmentA.newInstance());
                if (FragmentB.newInstance().isAdded())
                    fragmentTransaction.hide(FragmentB.newInstance());
                if (FragmentD.newInstance().isAdded())
                    fragmentTransaction.hide(FragmentD.newInstance());
                if (FragmentE.newInstance().isAdded())
                    fragmentTransaction.hide(FragmentE.newInstance());
                if (FragmentC.newInstance().isAdded())
                    fragmentTransaction.show(FragmentC.newInstance());
                else
                    fragmentTransaction.add(R.id.flContainer, fragment);
                break;

            case 3:
                if (FragmentA.newInstance().isAdded())
                    fragmentTransaction.hide(FragmentA.newInstance());
                if (FragmentB.newInstance().isAdded())
                    fragmentTransaction.hide(FragmentB.newInstance());
                if (FragmentC.newInstance().isAdded())
                    fragmentTransaction.hide(FragmentC.newInstance());
                if (FragmentE.newInstance().isAdded())
                    fragmentTransaction.hide(FragmentE.newInstance());
                if (FragmentD.newInstance().isAdded())
                    fragmentTransaction.show(FragmentD.newInstance());
                else
                    fragmentTransaction.add(R.id.flContainer, fragment);
                break;

            case 4:
                if (FragmentA.newInstance().isAdded())
                    fragmentTransaction.hide(FragmentA.newInstance());
                if (FragmentB.newInstance().isAdded())
                    fragmentTransaction.hide(FragmentB.newInstance());
                if (FragmentC.newInstance().isAdded())
                    fragmentTransaction.hide(FragmentC.newInstance());
                if (FragmentD.newInstance().isAdded())
                    fragmentTransaction.hide(FragmentD.newInstance());
                if (FragmentE.newInstance().isAdded())
                    fragmentTransaction.show(FragmentE.newInstance());
                else
                    fragmentTransaction.add(R.id.flContainer, fragment);
                break;
        }

        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis())
            finish();
        else
            Toast.makeText(this, "Press again to exit", Toast.LENGTH_SHORT).show();
        backPressedTime = System.currentTimeMillis();
    }
}