package com.estudioencasa.mago;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private TextView infoTextView;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView=(BottomNavigationView) findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.Home:
                    showFragmentHome();
                    return true;
                case R.id.I_found:
                    showFragmentI_Found();
                    return true;
                case R.id.Lost:
                    showFragmentLost();
                   return true;
                default:
                    return false;
            }
        });
        showFragmentHome();
    }

    private void showFragmentLost() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Lost())
                .setReorderingAllowed(true).addToBackStack(null).commit();
    }

    private void showFragmentI_Found() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new I_Found())
                .setReorderingAllowed(true).addToBackStack(null).commit();
    }

    private void showFragmentHome() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment())
                .setReorderingAllowed(true).addToBackStack(null).commit();
    }

}