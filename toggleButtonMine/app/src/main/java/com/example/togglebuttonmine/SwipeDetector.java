package com.example.togglebuttonmine;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by hoshyar on 1/19/17.
 */

public class SwipeDetector implements View.OnTouchListener {

    public static enum Action {
        LR, // Left to Right
        RL, // Right to Left
        TB, // Top to bottom
        BT, // Bottom to Top
        None // when no action was detected
    }

    private static final String logTag = "Swipe";
    private static final int MIN_DISTANCE = 100;
    private float downX, downY, upX, upY;
    private Action mSwipeDetected = Action.None;

    public boolean swipeDetected() {
        return mSwipeDetected != Action.None;
    }

    public Action getAction() {
        return mSwipeDetected;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                downX = event.getX();
                downY = event.getY();
                mSwipeDetected = Action.None;
                return false;

            case MotionEvent.ACTION_MOVE:
                upX = event.getX();
                upY = event.getY();

                float deltaX = downX - upX;
                float deltaY = downY - upY;
                Log.i(logTag,String.valueOf(deltaX));
                Log.i(logTag,String.valueOf(deltaX));

                if (deltaY>0 && deltaY<10 && deltaX<0 || deltaY==0 && deltaX>-15 && deltaX<0){
                    Log.i(logTag,"to right");
                }if (deltaY>=0 && deltaY<10 && deltaX>0 || deltaY<0 && deltaX>15 && deltaX<40){
                Log.i(logTag,"to left");
            }





                if (Math.abs(deltaX) > MIN_DISTANCE) {
                    // left or right
                    if (deltaX < 0) {
                        mSwipeDetected = Action.LR;
                        return false;
                    }
                    if (deltaX > 0) {


                        mSwipeDetected = Action.RL;
                        return false;
                    }
                } else if (Math.abs(deltaY) > MIN_DISTANCE) {


                    if (deltaY < 0) {
                        Log.i(logTag,"to bottom");
                        mSwipeDetected = Action.TB;
                        return false;
                    }
                    if (deltaY > 0) {
                        Log.i(logTag,"to up");
                        mSwipeDetected = Action.BT;
                        return false;
                    }
                }
                return true;
        }
        return false;
    }
}