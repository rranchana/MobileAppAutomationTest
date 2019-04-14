package com.mytaxi.android_demo.tests;


import android.support.test.espresso.IdlingPolicies;
import android.support.test.espresso.IdlingRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.rule.GrantPermissionRule;

import com.mytaxi.android_demo.activities.MainActivity;
import com.mytaxi.android_demo.pages.DriverProfilePage;
import com.mytaxi.android_demo.pages.HomePage;
import com.mytaxi.android_demo.pages.LoginPage;
import com.mytaxi.android_demo.utils.CustomIdlingResources;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static com.mytaxi.android_demo.resources.TestData.driverName;
import static com.mytaxi.android_demo.resources.TestData.password;
import static com.mytaxi.android_demo.resources.TestData.searchText;
import static com.mytaxi.android_demo.resources.TestData.userName;

public class CallDriverTest {

    private LoginPage loginPage = new LoginPage();
    private HomePage homePage = new HomePage();
    private DriverProfilePage driverProfile = new DriverProfilePage();


    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Rule
    public GrantPermissionRule mGrantPermissionRule = GrantPermissionRule.grant("android.permission.ACCESS_FINE_LOCATION");



    @Before
    public void setUp() {
        IdlingRegistry.getInstance().register(CustomIdlingResources.getIdlingResource());
        IdlingPolicies.setMasterPolicyTimeout(3, TimeUnit.MINUTES);
        IdlingPolicies.setIdlingResourceTimeout(3, TimeUnit.MINUTES);

    }

    @Test
    public void shouldLogInAndCallDriverSuccessfully() {
        loginPage.typeUserName(userName);
        loginPage.typePassword(password);
        loginPage.clickOnLoginButton();
        homePage.searchDriverByName(searchText);
        homePage.selectDriver(driverName);
        driverProfile.clickCallButton();
    }

    @After
    public void tearDown() {
        IdlingRegistry.getInstance().unregister(CustomIdlingResources.getIdlingResource());

    }

}
