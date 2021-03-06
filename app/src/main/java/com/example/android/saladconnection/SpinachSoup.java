package com.example.android.saladconnection;

import
        android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Date;

import static android.R.attr.order;
import static android.R.attr.value;
import static com.example.android.saladconnection.DbHelper.name;
import static com.example.android.saladconnection.R.drawable.spinachsoup;

public class SpinachSoup extends BaseActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    public class User {

        public String itemname;
        public int quan;
        public int price;

        public User() {
            // Default constructor required for calls to DataSnapshot.getValue(User.class)
        }

        public User(String itemname,int quan,int price) {

            this.itemname = itemname;
            this.quan=quan;
            this.price=price;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinach_soup);
        ordersp1();
    }
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
    public void cart(View view){
        Intent i=new Intent(this,OrderSummary.class);
        startActivity(i);
    }
    int quantity=1;
    public void increment(View view) {
        if(quantity==10) {
            Toast.makeText(this, "You cannot order more than 10 Juices", Toast.LENGTH_SHORT).show();
            return;
        }
        String value= getIntent().getStringExtra("key3");;
        int a=Integer.parseInt(value);
        quantity++;
        display(quantity);
        displayPrice(quantity*a);
    }
    public void decrement(View view) {
        if(quantity==1){
            Toast.makeText(this,"You cannot order less than 1 Juice",Toast.LENGTH_SHORT).show();
            return;
        }
        String value= getIntent().getStringExtra("key3");;
        int a=Integer.parseInt(value);
        quantity--;
        display(quantity);
        displayPrice(quantity*a);
    }
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_textview);
        quantityTextView.setText("" + number);
    }
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_textview);
        priceTextView.setText("₹"+number+"/-");
    }
    public void ordersoup(View view){
        Date dt=new Date();
        String date=Integer.toString(dt.getDate())+Integer.toString(dt.getMonth());
        String value= getIntent().getStringExtra("key1");
        TextView textView = (TextView) findViewById(R.id.textView21);
        textView.setText(value);
        String value2= getIntent().getStringExtra("key2");
        String value3= getIntent().getStringExtra("key3");
        int val3=Integer.parseInt(value3);
        OrderSummary.abc.additem(quantity*val3);
        Toast.makeText(this, "Sum="+OrderSummary.abc.sum, Toast.LENGTH_SHORT).show();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        User user1 = new User(value2,quantity,quantity*val3);
        myRef.child("users").child(user.getUid()).child(date).push().setValue(user1);

        if(value2.equals("spinachsoup")){
            try {
                String str="     "+quantity+"        Spinach Soup"+"     "+quantity*39+"\n";
                FileOutputStream fileout=openFileOutput("mytextfile.txt", MODE_APPEND);
                OutputStreamWriter outputWriter=new OutputStreamWriter(fileout);
                outputWriter.write(str.toString());
                outputWriter.close();
                //display file saved message
                Toast.makeText(getBaseContext(), "Added to Cart!",
                        Toast.LENGTH_SHORT).show();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(value2.equals("tomatosoup")){
            try{
                String str="     "+quantity+"        Tomato Soup"+"      "+quantity*39+"\n";
                FileOutputStream fileout=openFileOutput("mytextfile.txt", MODE_APPEND);
                OutputStreamWriter outputWriter=new OutputStreamWriter(fileout);
                outputWriter.write(str.toString());
                outputWriter.close();

                //display file saved message
                Toast.makeText(getBaseContext(), "Added to Cart!",
                        Toast.LENGTH_SHORT).show();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        else if(value2.equals("laukisoup")){
            try {
                String str="     "+quantity+"        Lauki Soup"+"       "+quantity*39+"\n";
                FileOutputStream fileout=openFileOutput("mytextfile.txt", MODE_APPEND);
                OutputStreamWriter outputWriter=new OutputStreamWriter(fileout);
                outputWriter.write(str.toString());
                outputWriter.close();

                //display file saved message
                Toast.makeText(getBaseContext(), "Added to Cart!",
                        Toast.LENGTH_SHORT).show();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(value2.equals("beetsoup")){
            try {
                String str="     "+quantity+"        Beet Soup"+"         "+quantity*49+"\n";
                FileOutputStream fileout=openFileOutput("mytextfile.txt", MODE_APPEND);
                OutputStreamWriter outputWriter=new OutputStreamWriter(fileout);
                outputWriter.write(str.toString());
                outputWriter.close();
                //display file saved message
                Toast.makeText(getBaseContext(), "Added to Cart!",
                        Toast.LENGTH_SHORT).show();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(value2.equals("carrotsoup")){
            try {
                String str="     "+quantity+"        Carrot Soup"+"      "+quantity*49+"\n";
                FileOutputStream fileout=openFileOutput("mytextfile.txt", MODE_APPEND);
                OutputStreamWriter outputWriter=new OutputStreamWriter(fileout);
                outputWriter.write(str.toString());
                outputWriter.close();

                //display file saved message
                Toast.makeText(getBaseContext(), "Added to Cart!",
                        Toast.LENGTH_SHORT).show();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(value2.equals("cauliflowersoup")){
            try {
                String str="     "+quantity+"        Cauliflower"+"       "+quantity*49+"\n";
                FileOutputStream fileout=openFileOutput("mytextfile.txt", MODE_APPEND);
                OutputStreamWriter outputWriter=new OutputStreamWriter(fileout);
                outputWriter.write(str.toString());
                outputWriter.close();

                //display file saved message
                Toast.makeText(getBaseContext(), "Added to Cart!",
                        Toast.LENGTH_SHORT).show();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(value2.equals("karelasoup")){
            try {
                String str="     "+quantity+"        Karela Soup"+"      "+quantity*49+"\n";
                FileOutputStream fileout=openFileOutput("mytextfile.txt", MODE_APPEND);
                OutputStreamWriter outputWriter=new OutputStreamWriter(fileout);
                outputWriter.write(str.toString());
                outputWriter.close();

                //display file saved message
                Toast.makeText(getBaseContext(), "Added to Cart!",
                        Toast.LENGTH_SHORT).show();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(value2.equals("cabbagesoup")){
            try {
                String str="     "+quantity+"        Cabbage Soup"+"    "+quantity*49+"\n";
                FileOutputStream fileout=openFileOutput("mytextfile.txt", MODE_APPEND);
                OutputStreamWriter outputWriter=new OutputStreamWriter(fileout);
                outputWriter.write(str.toString());
                outputWriter.close();

                //display file saved message
                Toast.makeText(getBaseContext(), "Added to Cart!",
                        Toast.LENGTH_SHORT).show();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(value2.equals("broccolisoup")){
            try {
                String str="     "+quantity+"        Brocolli Soup"+"    "+quantity*59+"\n";
                FileOutputStream fileout=openFileOutput("mytextfile.txt", MODE_APPEND);
                OutputStreamWriter outputWriter=new OutputStreamWriter(fileout);
                outputWriter.write(str.toString());
                outputWriter.close();

                //display file saved message
                Toast.makeText(getBaseContext(), "Added to Cart!",
                        Toast.LENGTH_SHORT).show();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
    void ordersp1(){
        String value= getIntent().getStringExtra("key1");
        TextView textView = (TextView) findViewById(R.id.textView21);
        textView.setText(value);
        String value2= getIntent().getStringExtra("key2");
        String value3= getIntent().getStringExtra("key3");;
        TextView textView2 = (TextView) findViewById(R.id.price_textview);
        //ImageView image=(ImageView) findViewById(R.id.image1);
        //int result = Integer.parseInt(value2);
        //image.setImageResource(result);

        if(value2.equals("spinachsoup")){
            ImageView image=(ImageView) findViewById(R.id.image1);
            image.setImageResource(R.drawable.spinachsoup);
            textView2.setText("₹"+value3+"/-");
        } else if(value2.equals("tomatosoup")){
            ImageView image=(ImageView) findViewById(R.id.image1);
            image.setImageResource(R.drawable.tomatosoup);
            textView2.setText("₹"+value3+"/-");
        }else if(value2.equals("laukisoup")){
            ImageView image=(ImageView) findViewById(R.id.image1);
            image.setImageResource(R.drawable.laukisoup);
            textView2.setText("₹"+value3+"/-");
        }else if(value2.equals("beetsoup")){
            ImageView image=(ImageView) findViewById(R.id.image1);
            image.setImageResource(R.drawable.beetsoup);
            textView2.setText("₹"+value3+"/-");
        }else if(value2.equals("carrotsoup")){
            ImageView image=(ImageView) findViewById(R.id.image1);
            image.setImageResource(R.drawable.carrotsoup);
            textView2.setText("₹"+value3+"/-");
        }else if(value2.equals("cauliflowersoup")){
            ImageView image=(ImageView) findViewById(R.id.image1);
            image.setImageResource(R.drawable.cauliflowersoup);
            textView2.setText("₹"+value3+"/-");
        }else if(value2.equals("karelasoup")){
            ImageView image=(ImageView) findViewById(R.id.image1);
            image.setImageResource(R.drawable.karelasoup);
            textView2.setText("₹"+value3+"/-");
        }else if(value2.equals("cabbagesoup")){
            ImageView image=(ImageView) findViewById(R.id.image1);
            image.setImageResource(R.drawable.cabbagesoup);
            textView2.setText("₹"+value3+"/-");
        }else if(value2.equals("broccolisoup")){
            ImageView image=(ImageView) findViewById(R.id.image1);
            image.setImageResource(R.drawable.broccolisoup);
            textView2.setText("₹"+value3+"/-");
        }
    }
}
