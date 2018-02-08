package dunn.matt.com.simonstddextravaganza.main_activity;

import java.util.ArrayList;
import java.util.List;

import dunn.matt.com.simonstddextravaganza.data.FruitModel;
import dunn.matt.com.simonstddextravaganza.data.source.DataSource;

public class MainActivityPresenter implements MainActivityContract.Presenter, DataSource.NetworkCallbacks {

    private DataSource dataSource;
    private MainActivityContract.View view;

    private List<FruitModel> fruitList;

    public MainActivityPresenter(MainActivityContract.View view, DataSource dataSource){
        this.view = view;
        this.dataSource = dataSource;
        fruitList = new ArrayList<>();
    }

    @Override
    public void getThemFruits(String url) {
        dataSource.getFruits(url, this);
    }

    @Override
    public void onSuccessfullFrutCall(String response) {
        try{
            view.createListForFragment(response);
        } catch (Exception e ){
            e.printStackTrace();
        }
    }

    @Override
    public void onFailedFruitCallback(String response) {
        view.showSomethingWentWrongDialog();
    }
}
