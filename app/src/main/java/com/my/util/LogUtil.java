package com.my.util;

import android.util.Log;

public class LogUtil {
    private static String TAG = "mwb";
    private static boolean isShow = true;

    public static void i(String msg) {
        if (isShow) {
            Log.i(TAG, msg);
        }
    }

    public static void e(String msg) {
        if (isShow) {
            Log.e(TAG, msg);
        }
    }

    public static void d(String msg) {
        if (isShow) {
            Log.d(TAG, msg);
        }
    }
}
