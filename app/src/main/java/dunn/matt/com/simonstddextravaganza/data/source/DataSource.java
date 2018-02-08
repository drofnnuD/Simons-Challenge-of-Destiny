package dunn.matt.com.simonstddextravaganza.data.source;

import android.content.Context;

/**
 * Created by Matt on 02/08/2017.
 */

public interface DataSource {

    interface NetworkCallbacks {
        void onSuccessfullFrutCall(String response);
        void onFailedFruitCallback(String response);
    }

    void getFruits(String url, NetworkCallbacks fruitCallback);

}
