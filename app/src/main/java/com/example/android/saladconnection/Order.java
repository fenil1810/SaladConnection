package com.example.android.saladconnection;

/**
 * Created by fenil on 06-03-2017.
 */

public class Order {

    public String itemname;
    public int quan;
    public int price;

    public Order() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }
    public Order(String itemname,int quan,int price) {

        this.itemname = itemname;
        this.quan=quan;
        this.price=price;
    }

    public String getitemname(){
        return itemname;
    }
    public int getqty(){
        return quan;
    }
    public int getprice(){
        return price;
    }

}
