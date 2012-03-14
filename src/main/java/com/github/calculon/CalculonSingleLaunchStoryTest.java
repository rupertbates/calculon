package com.github.calculon;

import android.app.Activity;
import android.content.Intent;

import android.test.SingleLaunchActivityTestCase;
import com.github.calculon.assertion.CalculonAssertions;
import com.github.calculon.story.StoryTestActivityStack;
import com.github.calculon.support.ActivityLauncher;

public abstract class CalculonSingleLaunchStoryTest<ActivityT extends Activity>
        extends SingleLaunchActivityTestCase<ActivityT>
        implements CalculonTestCase, CalculonStory{

    private Class<ActivityT> mActivityClass;
    private StoryTestActivityStack activityStack = null;

    public CalculonSingleLaunchStoryTest(String pkg, Class<ActivityT> activityClass){
        super(pkg, activityClass);
        mActivityClass = activityClass;
    }

    @Override
    public ActivityLauncher.LaunchConfiguration getLaunchConfiguration() {
        return new ActivityLauncher.LaunchConfiguration();
    }



    @Override
    protected void setUp() throws Exception {
        //setActivityInitialTouchMode(false);

        CalculonAssertions.register(this);
        super.setUp();
        activityStack = new StoryTestActivityStack(getActivity());
//        Intent startingIntent = new Intent(getInstrumentation().getTargetContext(), mActivityClass
//                .getClass());
//
//        setUp(startingIntent);
    }

//    protected void setUp(Intent startingIntent) throws Exception {
//        startingIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        startingIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//
//        //setActivityIntent(startingIntent);
//
//        //super.setUp();
//
//        activityStack = new StoryTestActivityStack(getActivity());
//        //setActivityInitialTouchMode(false);
//
//        CalculonAssertions.register(this);
//    }

    @Override
    public void setCurrentActivity(Activity currentActivity) {
        activityStack.push(currentActivity);
    }

    public Activity getCurrentActivity() {

        return activityStack.pop();
    }

    @Override
    public Class<? extends Activity> getActivityClass() {
        return mActivityClass;
    }

}
