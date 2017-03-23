package com.example.android.saladconnection;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import static android.R.id.message;
import static android.content.Context.MODE_PRIVATE;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;
import static com.example.android.saladconnection.R.id.emailid;
import static com.example.android.saladconnection.R.id.feedback;
import static com.example.android.saladconnection.R.id.mobile;

public class OrderSummary extends AppCompatActivity {
    static final int READ_BLOCK_SIZE = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_summary);
        display();
    }

    public void clrorder1(View view){
        try {
            String str="";
            FileOutputStream fileout=openFileOutput("mytextfile.txt", MODE_PRIVATE);
            OutputStreamWriter outputWriter=new OutputStreamWriter(fileout);
            outputWriter.write(str.toString());
            outputWriter.close();

            //display file saved message
            Toast.makeText(getBaseContext(), "Order Cleared",
                    Toast.LENGTH_SHORT).show();
            display();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void placeorder(View view){
//        Toast.makeText(getBaseContext(), "Your Order has been placed ", Toast.LENGTH_SHORT).show();
        Intent i=new Intent(this,BarcodeActivity.class);
        startActivity(i);
    }


    public void display() {
       /* try {
            FileInputStream fin = openFileInput("order.txt");
            int c;
            String temp = "";
            while ((c = fin.read()) != -1) {
                temp = temp + Character.toString((char) c);
            }
            TextView OS = (TextView) findViewById(R.id.summary);
            OS.setText(temp);
            fin.close();
        }

        catch(Exception e){
            Toast.makeText(this, "file cannot be read", Toast.LENGTH_SHORT).show();
        }*/
        try {

            FileInputStream fileIn=openFileInput("mytextfile.txt");
            InputStreamReader InputRead= new InputStreamReader(fileIn);

            char[] inputBuffer= new char[READ_BLOCK_SIZE];
            String s="Quantity   Item               Price\n";
            int charRead;

            while ((charRead=InputRead.read(inputBuffer))>0) {
                // char to string conversion
                String readstring=String.copyValueOf(inputBuffer,0,charRead);
                s +=readstring;
            }
            InputRead.close();
            TextView OS = (TextView) findViewById(R.id.order1);
            OS.setText(s);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void quan(View view) {
        try {

            FileInputStream fileIn=openFileInput("mytextfile1.txt");
            InputStreamReader InputRead1= new InputStreamReader(fileIn);

            char[] inputBuffer= new char[READ_BLOCK_SIZE];
            String s="Order:\n";
            int charRead;

            while ((charRead=InputRead1.read(inputBuffer))>0) {
                // char to string conversion
                String readstring=String.copyValueOf(inputBuffer,0,charRead);
                s +=readstring;
            }
            InputRead1.close();
            Toast.makeText(getBaseContext(), s,Toast.LENGTH_SHORT).show();
            TextView OS = (TextView) findViewById(R.id.order1);
            OS.setText(s);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
