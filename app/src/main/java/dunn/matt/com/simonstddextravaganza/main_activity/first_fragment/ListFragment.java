package dunn.matt.com.simonstddextravaganza.main_activity.first_fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.Serializable;
import java.util.List;

import dunn.matt.com.simonstddextravaganza.R;
import dunn.matt.com.simonstddextravaganza.data.FruitModel;

public class ListFragment extends Fragment implements ListFragmentContract.View{

    private ListFragmentContract.Presenter mPresenter;
    private ListFragmentAdapter mAdapter;

    private RecyclerView re_fruit_list;
    private Context context;

    private List<FruitModel> fruitList;

    private static String LIST_TAG = "LIST_TAG";

    public ListFragment() {
        // Required empty public constructor
    }

    public static ListFragment newInstance(List<FruitModel> fruitList) {
        ListFragment fragment = new ListFragment();
        Bundle args = new Bundle();
        args.putSerializable(LIST_TAG, (Serializable) fruitList);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        setUpRecycler(view);

        return view;
    }

    private void setUpRecycler(View view){
        re_fruit_list = (RecyclerView)view.findViewById(R.id.re_fruit_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        re_fruit_list.setLayoutManager(linearLayoutManager);
        mAdapter = new ListFragmentAdapter(context, fruitList);
        re_fruit_list.setAdapter(mAdapter);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(getArguments() != null){
            fruitList = (List<FruitModel>)getArguments().getSerializable(LIST_TAG);
        }
        this.context = context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void setPresenter(ListFragmentContract.Presenter presenter) {
        if(mPresenter != null){
            this.mPresenter = presenter;
        } else {
            throw new RuntimeException();
        }
    }
}
