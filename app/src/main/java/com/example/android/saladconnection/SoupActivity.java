package com.example.android.saladconnection;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static android.R.attr.description;


public class SoupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soup);
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
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
    void gotospinach(View view) {
        String desc="A rich, smooth and creamy soup with the addition of fresh spinach.";
        String img="R.drawable.spinachsoup";
        Intent i=new Intent(getApplicationContext(),SpinachSoup.class);
        i.putExtra("key1",desc);
        i.putExtra("key2","spinachsoup");
        i.putExtra("key3","39");
        startActivity(i);
    }
    void gototomato(View view) {
        String desc="A deep red classic tomato soup with thin skin and sweet juicy flesh with superb flavour and aroma.";
        Intent i=new Intent(getApplicationContext(),SpinachSoup.class);
        i.putExtra("key1",desc);
        i.putExtra("key2","tomatosoup");
        i.putExtra("key3","39");
        startActivity(i);
    }
    void gotolauki(View view) {
        String desc="A creamy delicious and extremely healthy soup with very few ingredients .";
        Intent i=new Intent(getApplicationContext(),SpinachSoup.class);
        i.putExtra("key1",desc);
        i.putExtra("key2","laukisoup");
        i.putExtra("key3","39");
        startActivity(i);
    }
    void gotobeet(View view) {
        String desc="A gorgeous purple coloured soup prepared with fresh beet roots with garnishing of cream.";
        Intent i=new Intent(getApplicationContext(),SpinachSoup.class);
        i.putExtra("key1",desc);
        i.putExtra("key2","beetsoup");
        i.putExtra("key3","49");
        startActivity(i);
    }
    void gotocarrot(View view) {
        String desc="A flavoursome sweet and healthy soup with fresh and  ground carrots.";
        Intent i=new Intent(getApplicationContext(),SpinachSoup.class);
        i.putExtra("key1",desc);
        i.putExtra("key2","carrotsoup");
        i.putExtra("key3","49");
        startActivity(i);
    }
    void gotocauliflower(View view) {
        String desc="Creamy soup loaded with tender cauliflower and finished with subtle notes of garlic and spices.";
        Intent i=new Intent(getApplicationContext(),SpinachSoup.class);
        i.putExtra("key1",desc);
        i.putExtra("key2","cauliflowersoup");
        i.putExtra("key3","49");
        startActivity(i);
    }
    void gotokarela(View view) {
        String desc="A bitter yet healthy soup with fresh bitter gourd with tinch of salt and pepper as a garnish.";
        Intent i=new Intent(getApplicationContext(),SpinachSoup.class);
        i.putExtra("key1",desc);
        i.putExtra("key2","karelasoup");
        i.putExtra("key3","49");
        startActivity(i);
    }
    void gotocabbage(View view) {
        String desc="Finely chopped cabbage along with some mixed vegetables and garnishing of coriander.";
        Intent i=new Intent(getApplicationContext(),SpinachSoup.class);
        i.putExtra("key1",desc);
        i.putExtra("key2","cabbagesoup");
        i.putExtra("key3","49");
        startActivity(i);
    }
    void gotobroccoli(View view) {
        String desc="Chopped Brocolli simmered with fresh cream.";
        Intent i=new Intent(getApplicationContext(),SpinachSoup.class);
        i.putExtra("key1",desc);
        i.putExtra("key2","broccolisoup");
        i.putExtra("key3","59");
        startActivity(i);
    }
}

