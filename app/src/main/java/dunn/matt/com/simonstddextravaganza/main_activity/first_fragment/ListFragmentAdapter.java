package dunn.matt.com.simonstddextravaganza.main_activity.first_fragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import dunn.matt.com.simonstddextravaganza.R;
import dunn.matt.com.simonstddextravaganza.data.FruitModel;

/**
 * Created by Matt on 02/08/2017.
 */

public class ListFragmentAdapter extends RecyclerView.Adapter<ListFragmentAdapter.ViewHolder>{

    private Context context;
    private List<FruitModel> fruitList;

    public ListFragmentAdapter(Context context, List<FruitModel> fruitList){
        this.context = context;
        this.fruitList = fruitList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_list_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txt_fruit_name.setText(fruitList.get(position).getType());
    }

    @Override
    public int getItemCount() {
        return fruitList.size();
    }

    public FruitModel getItemAtPosition(int position){
        return fruitList.get(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView txt_fruit_name;

        public ViewHolder(View itemView) {
            super(itemView);
            txt_fruit_name = (TextView)itemView.findViewById(R.id.txt_fruit_name);
        }
    }

}
