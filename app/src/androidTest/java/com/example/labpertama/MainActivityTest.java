package com.example.labpertama;

import android.content.Context;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule(MainActivity.class);

    @Test
    public void check_number_input() {
        onView(withId(R.id.button0)).perform(click());
        onView(withId(R.id.button1)).perform(click());
        onView(withId(R.id.button2)).perform(click());
        onView(withId(R.id.button3)).perform(click());
        onView(withId(R.id.button4)).perform(click());
        onView(withId(R.id.button5)).perform(click());
        onView(withId(R.id.button6)).perform(click());
        onView(withId(R.id.button7)).perform(click());
        onView(withId(R.id.button8)).perform(click());
        onView(withId(R.id.button9)).perform(click());
    }

    @Test
    public void check_valid_calculation(){
        // check the correctness of the following calculations
        // -1+2+3 = 4
        onView(withId(R.id.subtractButton)).perform(click());
        onView(withId(R.id.button1)).perform(click());
        onView(withId(R.id.plusButton)).perform(click());
        onView(withId(R.id.button2)).perform(click());
        onView(withId(R.id.plusButton)).perform(click());
        onView(withId(R.id.button3)).perform(click());
        onView(withId(R.id.equalButton)).perform(click());
        onView(withId(R.id.resultTextView)).check(matches(withText("4")));
    }

    @Test
    public void check_invalid_calculation() {
        // check the error of the following calculations
        // -1+2+3+ = err
        onView(withId(R.id.subtractButton)).perform(click());
        onView(withId(R.id.button1)).perform(click());
        onView(withId(R.id.plusButton)).perform(click());
        onView(withId(R.id.button2)).perform(click());
        onView(withId(R.id.plusButton)).perform(click());
        onView(withId(R.id.button3)).perform(click());
        onView(withId(R.id.plusButton)).perform(click());
        onView(withId(R.id.equalButton)).perform(click());
        onView(withId(R.id.resultTextView)).check(matches(withText("err")));
    }

}