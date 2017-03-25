package com.example.android.saladconnection;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

import static com.example.android.saladconnection.DbHelper.quantity;

public class RetreivalActivity extends AppCompatActivity {

    //private Firebase mRef;
    //private ArrayList<String> mOrder;

    ListView listViewOrders;
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference mRef= database.getReference().child("users").child(user.getUid());
    List<Order> orderList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retreival);
        listViewOrders=(ListView)findViewById(R.id.listViewOrders);
        orderList=new ArrayList<>();
        // mRef=new Firebase("https://saladconnection-a2558.firebaseio.com/");

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
    protected void onStart() {
        super.onStart();
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                orderList.clear();
                for (DataSnapshot orderSnapshot : dataSnapshot.getChildren()) {
                    Order order=orderSnapshot.getValue(Order.class);
                    orderList.add(order);
                }
                OrderList adapter=new OrderList(RetreivalActivity.this,orderList);
                listViewOrders.setAdapter(adapter);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
