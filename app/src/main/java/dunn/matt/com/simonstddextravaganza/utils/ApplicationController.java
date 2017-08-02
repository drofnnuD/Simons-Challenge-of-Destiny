package dunn.matt.com.simonstddextravaganza.utils;

import android.app.Application;

import dunn.matt.com.simonstddextravaganza.data.source.remote.NetworkManager;

/**
 * Created by Matt on 02/08/2017.
 */

public class ApplicationController extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        NetworkManager.getInstance(this);
    }
}
