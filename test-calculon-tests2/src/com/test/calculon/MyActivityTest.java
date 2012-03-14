package com.test.calculon;

import android.*;
import android.R;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.TextView;
import com.github.calculon.CalculonStoryTest;
import com.github.calculon.predicate.Predicate;

import static com.github.calculon.assertion.CalculonAssertions.*;

/**
 * This is a simple framework for a test of an Application.  See
 * {@link android.test.ApplicationTestCase ApplicationTestCase} for more information on
 * how to write and extend Application tests.
 * <p/>
 * To run this test, you can type:
 * adb shell am instrument -w \
 * -e class com.test.calculon.MyActivityTest \
 * com.test.calculon.tests/android.test.InstrumentationTestRunner
 */
public class MyActivityTest extends CalculonStoryTest<MyActivity> {

    public MyActivityTest() {
        super("com.test.calculon", MyActivity.class);
    }

    public void test_list_click_works() {
        assertThat(list(android.R.id.list)).click(0).implies(com.test.calculon.R.id.text).satisfies(new Predicate<View>() {
            public boolean check(View view) {
                return ((TextView) view).getText().equals("One");
            }
        });
    }

}
