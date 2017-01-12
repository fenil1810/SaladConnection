package com.example.android.saladconnection;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;

import java.lang.reflect.Field;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_icons, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_cart: {
                Intent i = new Intent(this, OrderSummary.class);
                startActivity(i);
                return true;
            }
        }
        return true;
    }
    public void gotosignin(View view){
       Intent i=new Intent(this,SignInActivity.class);
        startActivity(i);
    }
    public void gotoJuices(View view){
        Intent i=new Intent(this,JuiceActivity.class);
        startActivity(i);
    }
    public void gotoSoups(View view){
        Intent i=new Intent(this,SoupActivity.class);
        startActivity(i);
    }
    public void gotoSalads(View view){
        Intent i=new Intent(this,SaladActivity.class);
        startActivity(i);
    }
    public void gotoFeedback(View view){
        Intent i=new Intent(this,FeedbackActivity.class);
        startActivity(i);
    }
    public void gotoContact(View view){
        Intent i=new Intent(this,ContactActivity.class);
        startActivity(i);
    }
    public void gotoOrderSummary(View view){
        Intent i=new Intent(this,OrderSummary.class);
        startActivity(i);
    }
}
