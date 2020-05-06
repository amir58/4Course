package com.example.servicecourse;

import android.content.Context;
import android.content.SharedPreferences;

public class MySharedPreferences {

    private final String USER_ID= "userId";
    private final String IS_USER_LOGIN = "isUserLogin";

    private SharedPreferences myShared;

    public MySharedPreferences(Context context) {
        myShared = context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
    }

    public void setUserId(String userId) {
        myShared.edit().putString(USER_ID, userId).apply();
    }

    public String getUserId() {
        return myShared.getString(USER_ID, "-1");
    }

    public void setUserLogin(boolean isUserLogin) {
        myShared.edit().putBoolean(IS_USER_LOGIN, isUserLogin).apply();
    }

    public boolean isUserLogin() {
        return myShared.getBoolean(IS_USER_LOGIN, false);
    }

}
