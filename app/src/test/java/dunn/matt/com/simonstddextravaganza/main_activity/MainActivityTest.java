package dunn.matt.com.simonstddextravaganza.main_activity;

import android.content.Context;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dunn.matt.com.simonstddextravaganza.data.source.DataSource;

public class MainActivityTest {

    private MainActivityPresenter testablePresenter;
    private TestableView testableView;
    private MockDataRepo mockDataRepo;

    @Before
    public void setUp(){
        testableView = new TestableView();
        mockDataRepo = new MockDataRepo();
        testablePresenter = new MainActivityPresenter(testableView, mockDataRepo);
    }

    @Test
    public void testGetThemFruits(){
        String TEST_URL = "TEST_URL";
        testablePresenter.getThemFruits(TEST_URL, null);
        Assert.assertEquals(mockDataRepo.url, TEST_URL);
    }

    @Test
    public void givenThatTheNetworkCallIsSuccessFul_theCorrectMethodIsCalled(){
        testablePresenter.onSuccessfullFrutCall("{}");
        Assert.assertEquals(testableView.createListForFragmentCalled, true);
    }

    @Test
    public void givenThatTheNetworkCallIsUnsuccesful_theCorrectMethodIsCalled(){
        testablePresenter.onFailedFruitCallback("");
        Assert.assertEquals(testableView.setShowSomethingWrongDialogCalled, true);
    }

    private class TestableView implements MainActivityContract.View {

        private boolean createListForFragmentCalled,
                setShowSomethingWrongDialogCalled;

        @Override
        public void setPresenter(MainActivityContract.Presenter presenter) {

        }

        @Override
        public void createListForFragment(String jsonString) throws Exception {
            createListForFragmentCalled = true;
        }

        @Override
        public void showSomethingWentWrongDialog() {
            setShowSomethingWrongDialogCalled = true;
        }
    }

    private class MockDataRepo implements DataSource {

        String url;

        @Override
        public void getFruits(Context context, String url, NetworkCallbacks fruitCallback) {
            this.url = url;
        }
    }
}
