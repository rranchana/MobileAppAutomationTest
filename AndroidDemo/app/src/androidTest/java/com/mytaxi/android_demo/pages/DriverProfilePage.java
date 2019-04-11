package com.mytaxi.android_demo.pages;

import android.support.test.espresso.matcher.ViewMatchers;

import com.mytaxi.android_demo.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;

public class DriverProfilePage {

    public void clickCallButton() {
        onView(ViewMatchers.withId(R.id.fab))
                .perform(click());
    }

}