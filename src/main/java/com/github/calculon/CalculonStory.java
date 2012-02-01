package com.github.calculon;

import android.app.Activity;

public interface CalculonStory<ActivityT extends Activity> {
    public void setCurrentActivity(Activity currentActivity) ;

    public Activity getCurrentActivity();
}
