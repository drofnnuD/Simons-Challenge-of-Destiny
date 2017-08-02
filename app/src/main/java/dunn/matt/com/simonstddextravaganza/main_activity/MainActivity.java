package dunn.matt.com.simonstddextravaganza.main_activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;

import java.util.List;

import dunn.matt.com.simonstddextravaganza.R;
import dunn.matt.com.simonstddextravaganza.data.FruitModel;
import dunn.matt.com.simonstddextravaganza.main_activity.first_fragment.ListFragment;
import dunn.matt.com.simonstddextravaganza.utils.BaseActivity;

public class MainActivity extends BaseActivity implements MainActivityContract.View, FragmentInteractionListener {

    private MainActivityContract.Presenter mPresenter;

    private FrameLayout fl_fragment_layout;
    private FragmentManager fragMan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpFrameLayout();

        setUpFragMan();
        mPresenter = new MainActivityPresenter(this);

        getFruit();
    }

    private void setUpFrameLayout(){
        fl_fragment_layout = (FrameLayout)findViewById(R.id.fl_fragment_layout);
    }

    private void getFruit(){
        mPresenter.getThemFruits("https://raw.githubusercontent.com/bertthedefender/ccs/master/fruit.json", this);
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

    @Override
    public void setFirstFragment(List<FruitModel> fruitList) {
        FragmentTransaction transaction = fragMan.beginTransaction();
        transaction.replace(fl_fragment_layout.getId(), ListFragment.newInstance(fruitList));
        transaction.commit();
    }
}
