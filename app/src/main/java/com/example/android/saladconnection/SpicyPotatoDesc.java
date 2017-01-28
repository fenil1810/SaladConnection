package com.example.android.saladconnection;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.NumberFormat;

import static android.R.attr.data;
import static android.R.attr.y;
import static android.os.Build.VERSION_CODES.N;
import static android.provider.Telephony.Mms.Part.FILENAME;
import static com.example.android.saladconnection.R.id.feedback;
import static com.example.android.saladconnection.R.id.price_textview;

public class SpicyPotatoDesc extends BaseActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    public class User {

        public String username;
        public int quan;
        public int price;

        public User() {
            // Default constructor required for calls to DataSnapshot.getValue(User.class)
        }

        public User(String username,int quan,int price) {

            this.username = username;
            this.quan=quan;
            this.price=price;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spicy_potato_desc);
        ordersa();
    }
     /* OrderSummary o=new OrderSummary();
        String[] str2=new String[1];
             str2[0]="Spicy Potato";
       o.writer(str2);*/
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

    int quantity=1;
    public void increment(View view) {

         String value= getIntent().getStringExtra("key3");;
         int a=Integer.parseInt(value);
         if(quantity==10) {
             Toast.makeText(this, "You cannot order more than 10 Salads", Toast.LENGTH_SHORT).show();
             return;
         }quantity++;
         display(quantity);
         displayPrice(quantity*a);
     }
    public void decrement(View view) {
        if(quantity==1){
            //Button B=new Button(R.id.decrement);
            Toast.makeText(this,"You cannot order less than 1 Salad",Toast.LENGTH_SHORT).show();
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
    public void cart(View view){
        Intent i=new Intent(this,OrderSummary.class);
        startActivity(i);
    }
    public void orderSP(View view){
       /* String FILENAME = "order.txt";
        String string = "Spicy Potato";

        try {
            FileOutputStream fout = openFileOutput(FILENAME,MODE_PRIVATE);
            fout.write(string.getBytes());
            fout.close();
        }
        catch(Exception e){
            Toast.makeText(this, "file not found", Toast.LENGTH_SHORT).show();
        }*/

        /*try {
            String str="     "+quantity+"        Spicy Potato"+"       "+quantity*69+"\n";
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
        String value= getIntent().getStringExtra("key1");
        TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setText(value);
        String value2= getIntent().getStringExtra("key2");
        */
        String value= getIntent().getStringExtra("key1");
        TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setText(value);
        String value2= getIntent().getStringExtra("key2");
        String value3= getIntent().getStringExtra("key3");
        int val3=Integer.parseInt(value3);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        User user1 = new User(value2,quantity,quantity*val3);
        myRef.child("users").child(user.getUid()).push().setValue(user1);

        if(value2.equals("spicypotato")){
            try {
                String str="     "+quantity+"        Spicy Potato"+"       "+quantity*69+"\n";
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
        else if(value2.equals("brownrice")){
            try {
                String str="     "+quantity+"        Brown Rice"+"       "+quantity*89+"\n";
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
        else if(value2.equals("chiaseed")){
            try {
                String str="     "+quantity+"        Chiaseed"+"           "+quantity*99+"\n";
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
        else if(value2.equals("bean")){
            try {
                String str="     "+quantity+"        Bean Salad"+"       "+quantity*79+"\n";
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
        else if(value2.equals("soya")){
            try {
                String str="     "+quantity+"        Soya Chunks"+"    "+quantity*69+"\n";
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
        else if(value2.equals("chickpeas")){
            try {
                String str="     "+quantity+"        Chickpeas"+"          "+quantity*79+"\n";
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
        else if(value2.equals("superfood")){
            try {
                String str="     "+quantity+"        Superfood"+"         "+quantity*109+"\n";
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
        else if(value2.equals("sprout")){
            try {
                String str="     "+quantity+"        Spartan Sprout"+"  "+quantity*79+"\n";
                FileOutputStream fileout=openFileOutput("mytextfile.txt", MODE_APPEND);
                OutputStreamWriter outputWriter=new OutputStreamWriter(fileout);
                outputWriter.write(str.toString());
                outputWriter.close();

                //display file saved message
                Toast.makeText(getBaseContext(), "Added to Cart!",
                        Toast.LENGTH_SHORT).show();

            } catch (Exception e) {
                e.printStackTrace();
            }}
        else if(value2.equals("detox")) {
            try {
                String str="     "+quantity+"        Detox Salad"+"     "+quantity*109+"\n";
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
    void ordersa(){
        String value= getIntent().getStringExtra("key1");
        TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setText(value);
        String value2= getIntent().getStringExtra("key2");
        String value3= getIntent().getStringExtra("key3");;
        TextView textView2 = (TextView) findViewById(R.id.price_textview);
        if(value2.equals("spicypotato")){
            ImageView image=(ImageView) findViewById(R.id.image);
            image.setImageResource(R.drawable.spicy_potato1);
            textView2.setText("₹"+value3+"/-");
        } else if(value2.equals("brownrice")){
            ImageView image=(ImageView) findViewById(R.id.image);
            image.setImageResource(R.drawable.brown_rice);
            textView2.setText("₹"+value3+"/-");
        }else if(value2.equals("chiaseed")){
            ImageView image=(ImageView) findViewById(R.id.image);
            image.setImageResource(R.drawable.chiaseed);
            textView2.setText("₹"+value3+"/-");
        }else if(value2.equals("bean")){
            ImageView image=(ImageView) findViewById(R.id.image);
            image.setImageResource(R.drawable.bean);
            textView2.setText("₹"+value3+"/-");
        }else if(value2.equals("soya")){
            ImageView image=(ImageView) findViewById(R.id.image);
            image.setImageResource(R.drawable.soya_chunks);
            textView2.setText("₹"+value3+"/-");
        } else if(value2.equals("chickpeas")){
            ImageView image=(ImageView) findViewById(R.id.image);
            image.setImageResource(R.drawable.chickpea);
            textView2.setText("₹"+value3+"/-");
        }else if(value2.equals("superfood")){
            ImageView image=(ImageView) findViewById(R.id.image);
            image.setImageResource(R.drawable.superfood);
            textView2.setText("₹"+value3+"/-");
        }else if(value2.equals("sprout")){
            ImageView image=(ImageView) findViewById(R.id.image);
            image.setImageResource(R.drawable.sprout_salad);
            textView2.setText("₹"+value3+"/-");
        }else if(value2.equals("detox")){
            ImageView image=(ImageView) findViewById(R.id.image);
            image.setImageResource(R.drawable.tofu2);
            textView2.setText("₹"+value3+"/-");
        }
    }
}
