package dunn.matt.com.simonstddextravaganza.main_activity;

import android.content.Context;

import java.util.List;

import dunn.matt.com.simonstddextravaganza.data.FruitModel;
import dunn.matt.com.simonstddextravaganza.utils.BasePresenter;
import dunn.matt.com.simonstddextravaganza.utils.BaseView;

/**
 * Created by Matt on 02/08/2017.
 */

public interface MainActivityContract {

    interface View extends BaseView<Presenter>{
        void setFirstFragment(List<FruitModel> fruitList);
    }

    interface Presenter extends BasePresenter{
        void getThemFruits(String url, Context context);
        void createListForFragment(String jsonString) throws Exception;
    }

}
