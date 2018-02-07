package dunn.matt.com.simonstddextravaganza.main_activity.second_fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dunn.matt.com.simonstddextravaganza.R;
import dunn.matt.com.simonstddextravaganza.main_activity.FragmentInteractionListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class FruitInfoFragment extends Fragment {

    private Context context;
    private FragmentInteractionListener fragmentInteractionListener;

    public FruitInfoFragment() {
        // Required empty public constructor
    }

    public static FruitInfoFragment newInstance(){
        FruitInfoFragment fragment = new FruitInfoFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fruit_info, container, false);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        fragmentInteractionListener = (FragmentInteractionListener) context;
    }
}
