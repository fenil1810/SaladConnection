package com.example.android.saladconnection;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static android.R.attr.name;

public class FeedbackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
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
    public void mail(View view)
    {
        EditText name = (EditText) findViewById(R.id.name1);
        EditText emailid = (EditText) findViewById(R.id.emailid);
        EditText mobile = (EditText) findViewById(R.id.mobile);
        EditText feedback = (EditText) findViewById(R.id.feedback);
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"fenilshah333@gmail.com"});
        i.putExtra(Intent.EXTRA_SUBJECT, "Feedback  "   );
        i.putExtra(android.content.Intent.EXTRA_TEXT,"Name:"+name.getText().toString()+
                "\nEmail:"+emailid.getText().toString() +"\nMobile number:"+mobile.getText().toString()
                +"\nFeedback:\n"+feedback.getText().toString());
        //i.putExtra(android.content.Intent.EXTRA_TEXT,"Email:"+emailid.getText().toString());
        //i.putExtra(android.content.Intent.EXTRA_TEXT,"Feedback:\n"+feedback.getText().toString());
        try {
            startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(FeedbackActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }
}
