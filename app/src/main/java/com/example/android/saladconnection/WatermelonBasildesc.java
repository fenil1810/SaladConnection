package com.example.android.saladconnection;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import static com.example.android.saladconnection.R.id.textView2;

public class WatermelonBasildesc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watermelon_basildesc);
        orderju();
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
    public void orderW(View view){
        String value= getIntent().getStringExtra("key1");
        TextView textView = (TextView) findViewById(textView2);
        textView.setText(value);
        String value2= getIntent().getStringExtra("key2");

        if(value2.equals("watermelon")){
            try {
                String str="     "+quantity+"        Watermelon"+"       "+quantity*39+"\n";
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
        else if(value2.equals("orange")){
            try{
            String str="     "+quantity+"        Orange"+"           "+quantity*49+"\n";
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
        else if(value2.equals("chikoo")){
            try {
                String str="     "+quantity+"        Chikoo"+"           "+quantity*49+"\n";
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
        else if(value2.equals("pineapple")){
            try {
                String str="     "+quantity+"        Pineapple"+"       "+quantity*49+"\n";
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
        else if(value2.equals("apple")){
            try {
                String str="     "+quantity+"        Apple"+"    "+quantity*59+"\n";
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
        else if(value2.equals("pomegranate")){
            try {
                String str="     "+quantity+"        Pomegranate"+"          "+quantity*59+"\n";
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
        else if(value2.equals("kiwi")){
            try {
                String str="     "+quantity+"        Kiwi"+"         "+quantity*69+"\n";
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
    void orderju(){
        String value= getIntent().getStringExtra("key1");
        TextView textView = (TextView) findViewById(textView2);
        textView.setText(value);
        String value2= getIntent().getStringExtra("key2");
        String value3= getIntent().getStringExtra("key3");;
        TextView textView2 = (TextView) findViewById(R.id.price_textview);
        if(value2.equals("watermelon")){
            ImageView image=(ImageView) findViewById(R.id.image);
            image.setImageResource(R.drawable.watermelonbasiljuice);
            textView2.setText("₹"+value3+"/-");
        } else if(value2.equals("orange")){
            ImageView image=(ImageView) findViewById(R.id.image);
            image.setImageResource(R.drawable.orangejuicedesc);
            textView2.setText("₹"+value3+"/-");
        }else if(value2.equals("chikoo")){
            ImageView image=(ImageView) findViewById(R.id.image);
            image.setImageResource(R.drawable.chikooshake);
            textView2.setText("₹"+value3+"/-");
        }else if(value2.equals("pineapple")){
            ImageView image=(ImageView) findViewById(R.id.image);
            image.setImageResource(R.drawable.pineapplejuice);
            textView2.setText("₹"+value3+"/-");
        }else if(value2.equals("apple")){
            ImageView image=(ImageView) findViewById(R.id.image);
            image.setImageResource(R.drawable.applejuicedesc);
            textView2.setText("₹"+value3+"/-");
        }else if(value2.equals("pomegranate")){
            ImageView image=(ImageView) findViewById(R.id.image);
            image.setImageResource(R.drawable.pomegranatejuice2);
            textView2.setText("₹"+value3+"/-");
        }else if(value2.equals("kiwi")){
            ImageView image=(ImageView) findViewById(R.id.image);
            image.setImageResource(R.drawable.kiwijuice);
            textView2.setText("₹"+value3+"/-");
        }
    }

}
