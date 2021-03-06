package celmafmary.mobprolab1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustFoodItemAdapter extends ArrayAdapter<FoodItem> {

    private ArrayList<FoodItem> dishes;
    private Context context;

    public CustFoodItemAdapter(Context context, ArrayList<FoodItem> dishes){
        super(context, 0, dishes);
        this.dishes = dishes;
        this.context = context;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        FoodItem foodItem = (FoodItem) getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.cust_menu_item, parent, false);
        }

        View.OnClickListener add_listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FoodItem selectedDish = dishes.get(position); //gets fooditem with that index
                ArrayList<FoodItem> currentDishes = ((MainActivity) context).getCurrentOrder();
                currentDishes.add(selectedDish);
                ((MainActivity) context).setCurrentOrder(currentDishes);
                ((MainActivity) context).changeFragment(new CustomerOrder());
                notifyDataSetChanged();
            }
        };
        TextView add_to_order = (TextView) convertView.findViewById(R.id.cust_menu_list_item);
        add_to_order.setOnClickListener(add_listener);
        return convertView;
    }
}
