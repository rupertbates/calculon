package com.github.calculon.assertion;

import android.app.Activity;
import android.app.Instrumentation;
import android.test.InstrumentationTestCase;
import com.github.calculon.CalculonStory;
import com.github.calculon.CalculonUnitTest;

public abstract class AssertionBase {

    protected InstrumentationTestCase testCase;
    protected Activity activity;
    protected Instrumentation instrumentation;

    public AssertionBase(InstrumentationTestCase testCase, Activity activity) {
        this.testCase = testCase;
        this.instrumentation = testCase.getInstrumentation();
        this.activity = activity;
    }

    @SuppressWarnings("unchecked")
    public CalculonUnitTest<Activity> getUnitTestCase() {
        return (CalculonUnitTest<Activity>) testCase;
    }

    @SuppressWarnings("unchecked")
    public CalculonStory<Activity> getStoryTestCase() {
        return (CalculonStory<Activity>) testCase;
    }
}
