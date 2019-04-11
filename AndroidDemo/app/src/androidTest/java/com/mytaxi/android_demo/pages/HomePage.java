package com.mytaxi.android_demo.pages;

import android.support.test.espresso.matcher.RootMatchers;
import android.support.test.espresso.matcher.ViewMatchers;

import com.mytaxi.android_demo.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


public class HomePage {

    public void searchDriverByName(String searchText) {
        onView(ViewMatchers.withId(R.id.textSearch))
                .perform(typeText(searchText))
                .perform(closeSoftKeyboard());
    }


    public void selectDriver(String driverName) {
        onView(withText(driverName))
                .inRoot(RootMatchers.isPlatformPopup())
                .perform(click());
    }

}