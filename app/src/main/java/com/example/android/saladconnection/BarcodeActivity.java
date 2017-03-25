package com.example.android.saladconnection;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import static com.example.android.saladconnection.OrderSummary.READ_BLOCK_SIZE;

public class BarcodeActivity extends AppCompatActivity {
    private WebView qr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barcode);
        try {

            FileInputStream fileIn=openFileInput("mytextfile.txt");
            InputStreamReader InputRead= new InputStreamReader(fileIn);

            char[] inputBuffer= new char[READ_BLOCK_SIZE];
            String s="Quantity   Item               Price\n";
            int charRead;

            while ((charRead=InputRead.read(inputBuffer))>0) {
                // char to string conversion
                String readstring=String.copyValueOf(inputBuffer,0,charRead);
                s +=readstring+"\n";
            }
            qr = (WebView)findViewById(R.id.qr);
            qr.loadUrl("https://chart.googleapis.com/chart?cht=qr&chs=300x300&chl="+s);
            InputRead.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        /*try {
            Scanner x = new Scanner(openFileInput("mytextfile.txt"));
            String s = "";
            while (x.hasNext()) {
                s += x.next() + x.next() + x.next() + "\n";
            }
            qr = (WebView)findViewById(R.id.qr);
            qr.loadUrl("https://chart.googleapis.com/chart?cht=qr&chs=177x177&chl="+s);
            TextView OS = (TextView) findViewById(R.id.textView3);
            OS.setText(s);

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        */
        /* File sdcard = Environment.getExternalStorageDirectory();
        File file = new File(sdcard,"mytextfile.txt");
        StringBuilder content = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line);
                content.append('\n');
            }
        }
        catch (IOException e) {
        }

*/
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
}
