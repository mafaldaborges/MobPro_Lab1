package celmafmary.mobprolab1;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;


public class CustomerOrder extends Fragment {


    public CustomerOrder() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_customer_order, container, false);
        final Context context = getContext();

        ArrayList<FoodItem> currentOrder = ((MainActivity) getActivity()).getCurrentOrder();
        CustOrderAdapter orderAdapter = new CustOrderAdapter(context, currentOrder);
        ListView ordersView = (ListView) view.findViewById(R.id.cust_cur_dish_list);
        ordersView.setAdapter(orderAdapter);

        //gives ADD button function -- creates listener that waits for a click and adds a new list item to cur_dish_list
        View.OnClickListener add_listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).changeFragment(new CustomerMenu());
            }
        };
        Button add_btn = (Button) view.findViewById(R.id.cust_add_dish_btn);
        add_btn.setOnClickListener(add_listener); //sets up add button





        return view;
    }
}
