package com.example.android.saladconnection;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class Salad2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salad2);
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
    public void gotoSPdesc(View view){
        String desc="Fresh spicy potato with chopped green olives,grated carrot,lettuce garnished with pomegranate.";
        Intent i=new Intent(getApplicationContext(),SpicyPotatoDesc.class);
        i.putExtra("key1",desc);
        i.putExtra("key2","spicypotato");
        i.putExtra("key3","79");
        startActivity(i);
    }
    public void gotoBRDesc(View view)
    {
        String desc="Brown Rice with Broccoli and French Beans with garnishing of Spring Onions.";
        Intent i=new Intent(getApplicationContext(),SpicyPotatoDesc.class);
        i.putExtra("key1",desc);
        i.putExtra("key2","brownrice");
        i.putExtra("key3","89");
        startActivity(i);
    }

    public void gotoCSDesc(View view)
    {
        String desc="Chiaseeds with apples,oranges,pomegranate,banana and other seasonal fruits";
        Intent i=new Intent(getApplicationContext(),SpicyPotatoDesc.class);
        i.putExtra("key1",desc);
        i.putExtra("key2","chiaseed");
        i.putExtra("key3","99");
        startActivity(i);
    }
    public void gotobean(View view)
    {
        String desc="Bean Salad";
        Intent i=new Intent(getApplicationContext(),SpicyPotatoDesc.class);
        i.putExtra("key1",desc);
        i.putExtra("key2","bean");
        i.putExtra("key3","79");
        startActivity(i);
    }
    public void gotosoya(View view)
    {
        String desc="Soya Chunks";
        Intent i=new Intent(getApplicationContext(),SpicyPotatoDesc.class);
        i.putExtra("key1",desc);
        i.putExtra("key2","soya");
        i.putExtra("key3","69");
        startActivity(i);
    }

    public void gotoChickPeas(View view)
    {
        String desc="Chickpeas and Beet garnished with Tomatoes and olives";
        Intent i=new Intent(getApplicationContext(),SpicyPotatoDesc.class);
        i.putExtra("key1",desc);
        i.putExtra("key2","chickpeas");
        i.putExtra("key3","79");
        startActivity(i);
    }
    public void gotoSSDesc(View view)
    {
        String desc="Quinoa,bell peppers,red cabbage,flax seeds and lettuce.";
        Intent i=new Intent(getApplicationContext(),SpicyPotatoDesc.class);
        i.putExtra("key1",desc);
        i.putExtra("key2","superfood");
        i.putExtra("key3","109");
        startActivity(i);
    }
    public void gotoSpDesc(View view)
    {
        String desc="Chickpeas, Beet, Tomatoes, Lettuce and Olives.";
        Intent i=new Intent(getApplicationContext(),SpicyPotatoDesc.class);
        i.putExtra("key1",desc);
        i.putExtra("key2","sprout");
        i.putExtra("key3","79");
        startActivity(i);
    }
    public void gotoDSDesc(View view)
    {
        String desc="Tofu chunks with Cucumber, Broccoli, Prunes and Orange.";
        Intent i=new Intent(getApplicationContext(),SpicyPotatoDesc.class);
        i.putExtra("key1",desc);
        i.putExtra("key2","detox");
        i.putExtra("key3","109");
        startActivity(i);
    }
}
