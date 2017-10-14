package pl.tomasz.mediaplayer;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Tomasz on 12.10.2017.
 */

public class FileAdapter extends RecyclerView.Adapter<FileViewHolder> {

    private Context context;
    private ArrayList<String> data;

    public FileAdapter(Context context, ArrayList<String> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public FileViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_file, parent, false);

        return new FileViewHolder(context, view);
    }

    @Override
    public void onBindViewHolder(FileViewHolder holder, int position) {
        holder.bindData(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
