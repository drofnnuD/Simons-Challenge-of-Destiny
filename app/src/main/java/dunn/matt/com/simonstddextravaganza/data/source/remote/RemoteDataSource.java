package dunn.matt.com.simonstddextravaganza.data.source.remote;

import android.content.Context;

import dunn.matt.com.simonstddextravaganza.data.source.DataSource;

/**
 * Created by Matt on 02/08/2017.
 */

public class RemoteDataSource implements DataSource{

    private Context context;

    public RemoteDataSource(Context context){
        this.context = context;
    }

    @Override
    public void getFruits(String url, final NetworkCallbacks callbacks) {
        NetworkManager.getInstance(context).makeJsonObjectGetRequest(url, new VolleySingletonListener() {
            @Override
            public void onResult(Object object) {
                callbacks.onSuccessfullFrutCall(object.toString());
            }
        }, new VolleySingletonErrorListener() {
            @Override
            public void onErrorResult(Exception error) {
                callbacks.onFailedFruitCallback(error.toString());
            }
        });
    }

}
