package com.askar.makassarfoods;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.askar.makassarfoods.Adapters.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class Activity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_);

        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        viewPagerAdapter.AddFragement(new FoodFragment(), "Food");
        viewPagerAdapter.AddFragement(new DessertFragment(), "Dessert");
//        viewPagerAdapter.AddFragement(new DrinkFragment(), "Drink");

        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_local_dining);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_spa_black);
//        tabLayout.getTabAt(2).setIcon(R.drawable.ic_free_breakfast);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setElevation(0);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_item, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem){
        switch (menuItem.getItemId()){
            case R.id.acttion_about:
                Intent i = new Intent(this, AboutActivity.class);
                startActivity(i);
                break;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        exitDialog("Apakah Anda Yakin Ingin Keluar ?");
    }

    private void exitDialog(CharSequence message){
        new AlertDialog.Builder(Activity.this)
                .setMessage(message)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        System.exit(0);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                }).show();
    }

    // TODO : Edit color alertdialog

}
