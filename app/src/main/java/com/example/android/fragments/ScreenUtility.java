package com.example.android.fragments;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.Display;

public class ScreenUtility {

    private Activity activity;
    private float dpWidth;
    private float dpHeight;
    private float myDensity;
    private float myHeightPixels;
    private float myWidthPixels;

    public ScreenUtility(Activity activity) {
        this.activity = activity;

        Display display = activity.getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        display.getMetrics(outMetrics);

        //density is the logical density, so xhdpi returns a 2.0 and mhdpi a 1.0.
        float density = activity.getResources().getDisplayMetrics().density;

        dpHeight = outMetrics.heightPixels / density;
        dpWidth = outMetrics.widthPixels / density;

        myHeightPixels = outMetrics.heightPixels;
        myWidthPixels = outMetrics.widthPixels;
        myDensity = density;
    }

    public float getWidth() {
        return dpWidth;
    }

    public float getHeight() {
        return dpHeight;
    }

    public float getDensity() {return myDensity; }

    public float getMyHeightPixels() {return myHeightPixels; }

    public float getMyWidthPixels() {return myWidthPixels; }

}

