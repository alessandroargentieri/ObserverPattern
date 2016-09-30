package mawashi.alex.observerpattern;


import android.app.Application;
import android.content.Context;

/**
 * Created by alessandro.argentier on 29/09/2016.
 */
public class ApplicationClass extends Application {

    private static Context appContext;


    @Override
    public void onCreate() {
        super.onCreate();
        appContext = getApplicationContext();
    }

    //essendo statico sia il metodo che il contesto dichiarato, per richiamarlo non ho bisogno di istanziare ApplicationClass
    public static Context getContext() {
        return appContext;
    }

}