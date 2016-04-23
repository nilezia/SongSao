package app.shopspot.nilezia.songsao;

import android.app.Application;

import app.shopspot.nilezia.songsao.controller.Contextor;

/**
 * Created by NileZia on 17/3/2559.
 */
public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Contextor.getInstance().init(getApplicationContext());
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
