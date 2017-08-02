package dunn.matt.com.simonstddextravaganza.data.source;

import android.content.Context;

import dunn.matt.com.simonstddextravaganza.data.source.remote.RemoteDataSource;

/**
 * Created by Matt on 02/08/2017.
 */

public class DataRepository implements DataSource {

    private RemoteDataSource remoteDataSource;

    public DataRepository(RemoteDataSource remoteDataSource){
        this.remoteDataSource = remoteDataSource;
    }

    @Override
    public void getFruits(Context context, String url, FruitCallback fruitCallback) {
        remoteDataSource.getFruits(context, url, fruitCallback);
    }

}
