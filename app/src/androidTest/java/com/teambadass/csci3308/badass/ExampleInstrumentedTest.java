package com.teambadass.csci3308.badass;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.teambadass.csci3308.badass", appContext.getPackageName());
        onView(withId(R.id.editText))
                .perform(typeText("Bob"), closeSoftKeyboard());
        onView(withId(R.id.editText3))
                .perform(typeText("bobs_password"), closeSoftKeyboard());
        onView(withId(R.id.button1)).perform(click());

        onView(withId(R.id.MainActivity)).check(matches(isDisplayed()));

    }
}
