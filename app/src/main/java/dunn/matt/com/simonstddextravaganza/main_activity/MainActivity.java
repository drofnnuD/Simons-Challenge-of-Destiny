package dunn.matt.com.simonstddextravaganza.main_activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import dunn.matt.com.simonstddextravaganza.R;
import dunn.matt.com.simonstddextravaganza.data.FruitModel;
import dunn.matt.com.simonstddextravaganza.data.source.DataRepository;
import dunn.matt.com.simonstddextravaganza.data.source.remote.RemoteDataSource;
import dunn.matt.com.simonstddextravaganza.main_activity.first_fragment.ListFragment;
import dunn.matt.com.simonstddextravaganza.utils.BaseActivity;

public class MainActivity extends BaseActivity implements MainActivityContract.View, FragmentInteractionListener {

    private MainActivityContract.Presenter mPresenter;

    private FrameLayout fl_fragment_layout;
    private FragmentManager fragMan;

    private List<FruitModel> fruitList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpFrameLayout();

        setUpFragMan();
        mPresenter = new MainActivityPresenter(this,
                new DataRepository(new RemoteDataSource(this)));
        fruitList = new ArrayList<>();

        getFruit();
    }

    private void setUpFrameLayout(){
        fl_fragment_layout = (FrameLayout)findViewById(R.id.fl_fragment_layout);
    }

    private void getFruit(){
        mPresenter.getThemFruits("https://raw.githubusercontent.com/bertthedefender/ccs/master/fruit.json");
    }

    private void setUpFragMan(){
        fragMan = getSupportFragmentManager();
    }

    @Override
    public void setPresenter(MainActivityContract.Presenter presenter) {
        if(presenter != null){
            this.mPresenter = presenter;
        } else {
            throw new RuntimeException();
        }
    }

    public void setFirstFragment(List<FruitModel> fruitList) {
        FragmentTransaction transaction = fragMan.beginTransaction();
        transaction.replace(fl_fragment_layout.getId(), ListFragment.newInstance(fruitList));
        transaction.commit();
    }

    @Override
    public void createListForFragment(String jsonString) throws Exception {
        JSONObject jsonObject = new JSONObject(jsonString);
        for(int i = 0; i < jsonObject.getJSONArray("fruit").length(); i++){
            JSONObject object = jsonObject.getJSONArray("fruit").getJSONObject(i);
            fruitList.add(new FruitModel(object));
        }
        setFirstFragment(fruitList);
    }

    @Override
    public void showSomethingWentWrongDialog() {

    }
}
