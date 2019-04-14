package com.mytaxi.android_demo.utils;

import android.support.test.espresso.IdlingResource;
import android.support.test.espresso.idling.CountingIdlingResource;

public class CustomIdlingResources {

    private static CountingIdlingResource countingIdlingResource = new CountingIdlingResource("GLOBAL");


    public static void increment() {
        try {
            countingIdlingResource.increment();
        } catch (Exception ex) {

        }
    }

    public static void decrement() {

        try {
            countingIdlingResource.decrement();
        } catch (Exception ex) {

        }
    }

    public static IdlingResource getIdlingResource() {
        return countingIdlingResource;
    }
}
