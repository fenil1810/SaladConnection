package com.example.android.saladconnection;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.IntegerRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import android.app.Activity;
        import android.support.annotation.NonNull;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.TextView;

        import java.util.ArrayList;
        import java.util.List;

        import static android.R.attr.order;
        import static android.R.id.list;
import static com.example.android.saladconnection.R.id.qty;

/**
 * Created by fenil on 05-03-2017.
 */

public class OrderList extends ArrayAdapter<Order> {
    private Activity context;
    private List<Order> orderList;

    public OrderList(Activity context,List<Order> orderList){
        super(context,R.layout.order_layout,orderList);
        this.context=context;
        this.orderList=orderList;

    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater=context.getLayoutInflater();
        View listViewItem=inflater.inflate(R.layout.order_layout,null,true);
        TextView itemname=(TextView)listViewItem.findViewById(R.id.itemname);
        TextView qty=(TextView)listViewItem.findViewById(R.id.qty);
        TextView price=(TextView)listViewItem.findViewById(R.id.price);
        Order order=orderList.get(position);
        itemname.setText(order.getitemname());
        qty.setText(Integer.toString(order.getqty()));
        price.setText(Integer.toString(order.getprice()));
        return listViewItem;
    }


}
