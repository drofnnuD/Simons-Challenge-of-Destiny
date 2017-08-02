package dunn.matt.com.simonstddextravaganza.data.source.remote;

import android.content.Context;

import dunn.matt.com.simonstddextravaganza.data.source.DataSource;

/**
 * Created by Matt on 02/08/2017.
 */

public class RemoteDataSource implements DataSource{

    @Override
    public void getFruits(Context context, String url, final FruitCallback fruitCallback) {
        NetworkManager.getInstance(context).makeJsonObjectGetRequest(url, new VolleySingletonListener() {
            @Override
            public void onResult(Object object) {
                fruitCallback.onSuccessfullFrutCall(object.toString());
            }
        }, new VolleySingletonErrorListener() {
            @Override
            public void onErrorResult(Exception error) {
                fruitCallback.onFailedFruitCallback(error.toString());
            }
        });
    }

}
