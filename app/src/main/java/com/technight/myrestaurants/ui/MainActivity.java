package com.technight.myrestaurants.ui;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.technight.myrestaurants.Constants;
import com.technight.myrestaurants.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = MainActivity.class.getSimpleName();
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    @BindView(R.id.findRestaurantsButton) Button mFindRestaurantsButton;
    @BindView(R.id.locationEditText) EditText mLocationEditText;
    @BindView(R.id.appNameTextView) TextView mAppNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mSharedPreferences.edit();

        mFindRestaurantsButton.setOnClickListener(this);

//        mFindRestaurantsButton.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                String location = mLocationEditText.getText().toString();
//                Intent intent = new Intent(MainActivity.this, RestaurantListActivity.class);
//                intent.putExtra("location", location);
//                startActivity(intent);
//                Toast.makeText(MainActivity.this, location, Toast.LENGTH_SHORT).show();
//            }
//        });
    }
    @Override
    public void onClick(View v) {
        if (v == mFindRestaurantsButton) {
            String location = mLocationEditText.getText().toString();
            if (!(location).equals("")) {
                addToSharedPreferences(location);
            }
            Intent intent = new Intent(MainActivity.this, RestaurantListActivity.class);
//            intent.putExtra("location", location);
            startActivity(intent);
//            Toast.makeText(MainActivity.this, location, Toast.LENGTH_SHORT).show();
        }
    }

    private void addToSharedPreferences(String location){
        mEditor.putString(Constants.PREFERENCES_LOCATION_KEY, location).apply();
    }
}