package com.technight.myrestaurants;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RestaurantsActivity extends AppCompatActivity {
    public static final String TAG = RestaurantsActivity.class.getSimpleName();
    @BindView(R.id.locationTextView) TextView mLocationTextView;
    @BindView(R.id.listView) ListView mListView;

    private String[] restaurants = new String[] {"Sweet Hereafter", "Cricket", "Hawthorne Fish House",
            "Viking Soul Food", "Red Square", "Horse Brass", "Dick's Kitchen", "Taco Bell",
            "Me Kha Noodle Bar", "La Bonita Taqueria", "Smokehouse Tavern", "Pembiche",
            "Kay's Bar", "Gnarly Grey", "Slappy Cakes", "Mi Mero Mole" };

    private String[] cuisines = new String[] {"Vegan Food", "Breakfast",
            "Fish Dish", "Scandinavian", "Coffee", "English Food",
            "Burgers", "Fast Food", "Noodle Soups", "Mexican", "BBQ",
            "Cuban", "Bar Food", "Sports Bar", "Breakfast", "Mexican" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);

        ButterKnife.bind(this);
        mLocationTextView = (TextView) findViewById(R.id.locationTextView);

        MyRestaurantsArrayAdapter adapter = new MyRestaurantsArrayAdapter(this, android.R.layout.simple_list_item_1, restaurants, cuisines);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String restaurant = ((TextView)view).getText().toString();
                Log.v(TAG, "In the onItemClickListener!");
                Toast.makeText(RestaurantsActivity.this, restaurant, Toast.LENGTH_LONG).show();
            }
        });

        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        mLocationTextView.setText("Here are all the restaurants near: " + location);
        Log.d(TAG, "In the onCreate method");
    }
}