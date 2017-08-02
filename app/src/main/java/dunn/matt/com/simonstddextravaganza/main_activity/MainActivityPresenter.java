package dunn.matt.com.simonstddextravaganza.main_activity;

import android.content.Context;
import android.util.Log;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import dunn.matt.com.simonstddextravaganza.data.FruitModel;
import dunn.matt.com.simonstddextravaganza.data.source.DataRepository;
import dunn.matt.com.simonstddextravaganza.data.source.DataSource;
import dunn.matt.com.simonstddextravaganza.data.source.remote.RemoteDataSource;

/**
 * Created by Matt on 02/08/2017.
 */

public class MainActivityPresenter implements MainActivityContract.Presenter {

    private DataRepository dataRepository;
    private MainActivityContract.View mActivityView;

    private List<FruitModel> fruitList;

    public MainActivityPresenter(MainActivityContract.View mActivityView){
        this.mActivityView = mActivityView;
        dataRepository = new DataRepository(new RemoteDataSource());
        fruitList = new ArrayList<>();
    }

    @Override
    public void start() {

    }

    @Override
    public void getThemFruits(String url, Context context) {
        dataRepository.getFruits(context, url, new DataSource.FruitCallback() {
            @Override
            public void onSuccessfullFrutCall(String response) {
                try{
                    createListForFragment(response);
                } catch (Exception e ){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailedFruitCallback(String response) {

            }
        });
    }

    @Override
    public void createListForFragment(String jsonString) throws Exception {
        JSONObject jsonObject = new JSONObject(jsonString);
        for(int i = 0; i < jsonObject.getJSONArray("fruit").length(); i++){
            JSONObject object = jsonObject.getJSONArray("fruit").getJSONObject(i);
            fruitList.add(new FruitModel(object));
        }
        mActivityView.setFirstFragment(fruitList);
    }
}
