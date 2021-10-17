package com.example.networkmanager_retrofitrxjava;

import android.content.Context;
import android.util.Log;

public class Utils {
    private static String TAG = "di";
    public static String getToken(Context activity) {
        String token = null;
//        if (User.getInstance().getToken() == null || User.getInstance().getToken().equals("")) {
//            token = (String) SharePref.get(activity, API.token, "");
//        } else {
//            token = User.getInstance().getToken();
//        }
        return token;
    }

    public static void log(String json) {
        Log.d(TAG, "response:" + json);
    }
}
