package com.example.midterm.Paser;

import android.util.Log;

import androidx.annotation.NonNull;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class JSONParser {

    private static final String url ="https://api.myjson.com/bins/11792e";

    public static final String TAG = "TAG";

    private static Response response;

    public static  JSONObject getDataFromWeb(){
        try{
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            response = client.newCall(request).execute();
            return new JSONObject(response.body().string());
        }catch (@NonNull IOException | JSONException e){
            Log.e(TAG, "" + e.getLocalizedMessage());
        }
        return null;
    }

}
