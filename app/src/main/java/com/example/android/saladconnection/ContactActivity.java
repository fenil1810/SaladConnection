package com.example.android.saladconnection;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class ContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_contact);
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

            case R.id.action_sign_out:{
                GoogleLoginActivity googleLoginActivity=new GoogleLoginActivity();
                googleLoginActivity.signOut();
                googleLoginActivity.updateUI(null);
                Intent i=new Intent(this,GoogleLoginActivity.class);
                startActivity(i);
            }
            case R.id.action_feedback:{
                Intent i=new Intent(this,FeedbackActivity.class);
                startActivity(i);
            }
        }
        return true;
    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
