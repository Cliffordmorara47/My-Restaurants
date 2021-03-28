package com.technight.myrestaurants.ui;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.technight.myrestaurants.R;

public class RestaurantListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurant_list_item);
    }
}