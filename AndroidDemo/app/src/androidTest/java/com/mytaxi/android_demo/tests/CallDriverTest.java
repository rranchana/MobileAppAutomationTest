package com.mytaxi.android_demo.tests;


import android.support.test.rule.ActivityTestRule;
import android.support.test.rule.GrantPermissionRule;

import com.mytaxi.android_demo.activities.MainActivity;
import com.mytaxi.android_demo.pages.DriverProfilePage;
import com.mytaxi.android_demo.pages.HomePage;
import com.mytaxi.android_demo.pages.LoginPage;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

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
    public void logIntoApplication() {
        loginPage.typeUserName(userName);
        loginPage.typePassword(password);
        loginPage.clickOnLoginButton();
    }

    @Test
    public void shouldCallDriverSuccessfully() throws InterruptedException {
        Thread.sleep(1000);
        homePage.searchDriverByName(searchText);
        Thread.sleep(1000);
        homePage.selectDriver(driverName);
        Thread.sleep(1000);
        driverProfile.clickCallButton();
    }


}
