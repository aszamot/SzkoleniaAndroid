package pl.atk.playground;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Tomasz on 04.11.2017.
 */

public class AppAdapter extends RecyclerView.Adapter<AppViewHolder> {

    private Context context;
    private LinkedList<Application> apps;

    public AppAdapter(Context context, LinkedList<Application> apps) {
        this.context = context;
        this.apps = apps;
    }

    @Override
    public AppViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item, parent, false);

        return new AppViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(AppViewHolder holder, int position) {
        holder.bindData(apps.get(position));
    }

    @Override
    public int getItemCount() {
        return apps.size();
    }
}
