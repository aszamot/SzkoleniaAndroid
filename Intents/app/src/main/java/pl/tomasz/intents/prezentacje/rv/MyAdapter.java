package pl.tomasz.intents.prezentacje.rv;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import pl.tomasz.intents.R;

/**
 * Created by Tomasz on 29.09.2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private List<Integer> data;
    private Context context;

    public MyAdapter(List<Integer> data, Context context){
        this.data = data;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_recycler, parent, false);

        return new MyViewHolder(view, context, this);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.bindData(data.get(position));
    }

    public void addNewItem(int i){
        data.add(i);
        notifyItemInserted(data.size());
    }

    public void removeItem(int pos){
        data.remove(pos);
        notifyItemRemoved(pos);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
