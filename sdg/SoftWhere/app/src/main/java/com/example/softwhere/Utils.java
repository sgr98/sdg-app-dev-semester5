package com.example.softwhere;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

/*
Used in order to initialise the database only once and not every time the app is loaded
 */
public class Utils {

    private static Utils instance;
    private SharedPreferences sharedPreferences;

    private static final String INITIALSE_KEY = "to_initialise";

    private Utils(Context context) {
        sharedPreferences = context.getSharedPreferences("firstTime", Context.MODE_PRIVATE);

        if(getIniti() == null) {
            setIniti("false");
        }
    }

    public static Utils getInstance(Context context) {
        if(instance == null) {
            instance = new Utils(context);
        }
        return instance;
    }

    public String getIniti() {
        Gson gson = new Gson();
        Type type = new TypeToken<String>(){}.getType();
        String isIniti = gson.fromJson(sharedPreferences.getString(INITIALSE_KEY, null), type);
        return isIniti;
    }

    public void setIniti(String status) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(INITIALSE_KEY, status);
        editor.commit();
    }

}
