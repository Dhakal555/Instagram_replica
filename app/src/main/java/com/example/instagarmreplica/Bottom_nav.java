package com.example.instagarmreplica;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.instagarmreplica.fragments.HomeFragment;
import com.example.instagarmreplica.fragments.SearchFragment;
import com.example.instagarmreplica.model.PostList;
import com.example.instagarmreplica.model.Story;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class Bottom_nav extends AppCompatActivity {
    BottomNavigationView bnv;
    Fragment selectedFragment = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_nav);

        bnv = findViewById(R.id.bottom_nav_menu);
        bnv.setOnNavigationItemSelectedListener(selected_nav_items);
        bnv.setSelectedItemId(R.id.nav_home_menu);
        getSupportFragmentManager().beginTransaction().replace(R.id.container_fragment, new HomeFragment()).commit();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener selected_nav_items = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Menu menu = bnv.getMenu();
            menu.findItem(R.id.nav_home_menu).setIcon(R.drawable.instahome);
            menu.findItem(R.id.nav_search_menu).setIcon(R.drawable.instasearch);
            menu.findItem(R.id.nav_add_menu).setIcon(R.drawable.instaadd);
            menu.findItem(R.id.nav_fav_menu).setIcon(R.drawable.instalike);
            menu.findItem(R.id.nav_avatar_menu).setIcon(R.drawable.instauser);

            switch (menuItem.getItemId()) {
                case R.id.nav_home_menu:
                    selectedFragment = new HomeFragment();
                    menuItem.setIcon(R.drawable.instahomeselected);
                    break;
                case R.id.nav_search_menu:
                    selectedFragment = new SearchFragment();
                    menuItem.setIcon(R.drawable.instasearchselected);
                    break;
                case  R.id.nav_add_menu:
                    menuItem.setIcon(R.drawable.instaaddselected);
                    break;
                case R.id.nav_fav_menu:
                    menuItem.setIcon(R.drawable.instalikeselected);

                    break;
                case R.id.nav_avatar_menu:
                    menuItem.setIcon(R.drawable.instauserselected1);
                    break;

            }
            getSupportFragmentManager().beginTransaction().replace(R.id.container_fragment,
                    selectedFragment).commit();

            if (selectedFragment != null){
                getSupportFragmentManager().beginTransaction().replace(R.id.container_fragment, selectedFragment).commit();
            }
            return true;
        }
    };

}
