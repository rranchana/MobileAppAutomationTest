package com.mytaxi.android_demo.pages;

import android.support.test.espresso.matcher.ViewMatchers;

import com.mytaxi.android_demo.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class LoginPage {

    public void typeUserName(String userName) {
        onView(ViewMatchers.withId(R.id.edt_username))
                .perform(typeText(userName))
                .perform(closeSoftKeyboard());
    }

    public void typePassword(String password) {
        onView(withId(R.id.edt_password))
                .perform(typeText(password))
                .perform(closeSoftKeyboard());
    }

    public void clickOnLoginButton() {
        onView(withId(R.id.btn_login))
                .perform(click());
    }

}