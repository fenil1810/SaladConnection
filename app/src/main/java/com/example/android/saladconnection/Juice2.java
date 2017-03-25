package com.example.android.saladconnection;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class Juice2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juice2);
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
    public void gotowatermelon(View view){
        String desc="Cool and refreshing ,with juicy watermelon blended with fresh and fragrant basil.";
        Intent i=new Intent(getApplicationContext(),WatermelonBasildesc.class);
        i.putExtra("key1",desc);
        i.putExtra("key2","watermelon");
        i.putExtra("key3","39");
        startActivity(i);
    }
    public void gotoorange(View view){
        String desc="Bright orange coloured juice with freshly cut oranges and flaxseeds.";
        Intent i=new Intent(getApplicationContext(),WatermelonBasildesc.class);
        i.putExtra("key1",desc);
        i.putExtra("key2","orange");
        i.putExtra("key3","49");
        startActivity(i);
    }
    public void gotochikoo(View view)
    {
        String desc="Simple smooth and sweet milkshake with sliced chikoo in chocolate Soy milk.";
        Intent i=new Intent(getApplicationContext(),WatermelonBasildesc.class);
        i.putExtra("key1",desc);
        i.putExtra("key2","chikoo");
        i.putExtra("key3","49");
        startActivity(i);
    }

    public void gotopineapple(View view)
    {
        String desc="Additional hints of aniseed ,the pineapple juice packs a powerful punch with an overwhelming taste.";
        Intent i=new Intent(getApplicationContext(),WatermelonBasildesc.class);
        i.putExtra("key1",desc);
        i.putExtra("key2","pineapple");
        i.putExtra("key3","49");
        startActivity(i);
    }

    public void gotoapple(View view)
    {
        String desc="A grounding ,sweet and savory,light energizing green juice with cumin seeds.";
        Intent i=new Intent(getApplicationContext(),WatermelonBasildesc.class);
        i.putExtra("key1",desc);
        i.putExtra("key2","apple");
        i.putExtra("key3","59");
        startActivity(i);
    }
    public void gotopomegranate(View view)
    {
        String desc="Exotic Pomegranate juice flavoured with dark chocolate.";
        Intent i=new Intent(getApplicationContext(),WatermelonBasildesc.class);
        i.putExtra("key1",desc);
        i.putExtra("key2","pomegranate");
        i.putExtra("key3","59");
        startActivity(i);
    }
    public void gotokiwi(View view)
    {
        String desc="Freshly chopped kiwi with cardamom for extra flavour and kick provides a refreshing taste.";
        Intent i=new Intent(getApplicationContext(),WatermelonBasildesc.class);
        i.putExtra("key1",desc);
        i.putExtra("key2","kiwi");
        i.putExtra("key3","69");
        startActivity(i);
    }
}
