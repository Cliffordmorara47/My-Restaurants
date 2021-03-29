package com.technight.myrestaurants;

import android.view.View;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import androidx.test.runner.AndroidJUnit4;

import com.technight.myrestaurants.ui.RestaurantListActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.runner.RunWith;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.not;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityInstrumentationTest {

    @Rule
    public ActivityScenarioRule<RestaurantListActivity> activityTestRule =
            new ActivityScenarioRule<>(RestaurantListActivity.class);

    private View activityDecorView;

    @Before
    public void setUp() {
        activityTestRule.getScenario().onActivity(new ActivityScenario.ActivityAction<RestaurantListActivity>() {
            @Override
            public void perform(RestaurantListActivity activity) {
                activityDecorView = activity.getWindow().getDecorView();
            }
        });
    }

//    @Test
//    public void listItemClickDisplaysToastWithCorrectRestaurant() {
//        String restaurantName = "Mi Mero Mole";
//        onData(anything())
//                .inAdapterView(withId(R.id.listView))
//                .atPosition(0)
//                .perform(click());
//        onView(withText(restaurantName)).inRoot(withDecorView(not(activityDecorView)))
//                .check(matches(withText(restaurantName)));
//    }

}
