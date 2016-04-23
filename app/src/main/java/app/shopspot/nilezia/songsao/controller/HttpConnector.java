package app.shopspot.nilezia.songsao.controller;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import app.shopspot.nilezia.songsao.controller.http.ApiConnector;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

public class HttpConnector {

    private static HttpConnector instance;
    private ApiConnector connector;

    public static HttpConnector getInstance() {
        if (instance == null)
            instance = new HttpConnector();
        return instance;
    }

    private Context mContext;

    private HttpConnector() {
        mContext = Contextor.getInstance().getContext();
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://gank.io/api/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        connector = retrofit.create(ApiConnector.class);
    }

    public ApiConnector getConnector() {
        return connector;
    }
}