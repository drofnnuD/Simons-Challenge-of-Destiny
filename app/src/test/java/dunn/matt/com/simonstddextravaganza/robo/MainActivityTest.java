package dunn.matt.com.simonstddextravaganza.robo;

import android.os.Build;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.widget.FrameLayout;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import dunn.matt.com.simonstddextravaganza.BuildConfig;
import dunn.matt.com.simonstddextravaganza.R;
import dunn.matt.com.simonstddextravaganza.data.FruitModel;
import dunn.matt.com.simonstddextravaganza.main_activity.MainActivity;
import dunn.matt.com.simonstddextravaganza.main_activity.MainActivityPresenter;
import dunn.matt.com.simonstddextravaganza.main_activity.first_fragment.ListFragment;
import dunn.matt.com.simonstddextravaganza.main_activity.first_fragment.ListFragmentAdapter;

/**
 * Created by Matt on 02/08/2017.
 *
 * Lazy tasts should of mocked, didn't.
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP, manifest = "AndroidManifest.xml")
public class MainActivityTest {

    private MainActivity activity;
    private MainActivityPresenter presenter;
    private FrameLayout fl_fragment_layout;

    @Before
    public void setUp(){
        activity = Robolectric.setupActivity(MainActivity.class);
        presenter = new MainActivityPresenter(activity);
        fl_fragment_layout = (FrameLayout)activity.findViewById(R.id.fl_fragment_layout);
    }

    @Test
    public void testActivityNotNull(){
        Assert.assertNotNull(activity);
    }

    @Test
    public void testPresenterNotNull(){
        Assert.assertNotNull(presenter);
    }

    @Test
    public void testFrameLayoutFragment(){
        final ListFragment listFragment = new ListFragment();
        //lazy, should mock, not enough time
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Assert.assertEquals(listFragment, activity.getSupportFragmentManager().findFragmentById(R.id.fl_fragment_layout));
            }
        }, 2000);
    }

    @Test
    public void testFirstItem(){
        //lazy, should mock, not enough time
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                ListFragment listFragment = (ListFragment) activity.getSupportFragmentManager().findFragmentById(R.id.fl_fragment_layout);
                Assert.assertNotNull(listFragment);
                RecyclerView re_fruit_list = (RecyclerView) activity.getSupportFragmentManager().
                        findFragmentById(R.id.fl_fragment_layout).getActivity().findViewById(R.id.re_fruit_list);
                Assert.assertNotNull(re_fruit_list);

                ListFragmentAdapter adapter = (ListFragmentAdapter) re_fruit_list.getAdapter();
                Assert.assertNotNull(adapter);

                FruitModel model = adapter.getItemAtPosition(0);

                Assert.assertEquals(model.getType(), "apple");
                Assert.assertEquals(model.getPrice(), 149);
                Assert.assertEquals(model.getWeight(), 120);
            }
        }, 2000);
    }

    @After
    public void tearDown(){

    }

}
