package pl.tomasz.intents.zadania.zadanie1;

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

public class MusicAdapter extends RecyclerView.Adapter<MusicViewHolder> {

    private List<Album> albums;
    private Context context;

    public MusicAdapter(Context context, List albums) {
        this.albums = albums;
        this.context = context;
    }

    @Override
    public MusicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_recycler_zadanie1, parent, false);

        return new MusicViewHolder(view, context, this);
    }

    @Override
    public void onBindViewHolder(MusicViewHolder holder, int position) {
        Album album = albums.get(position);
        holder.bindData(album);
    }

    @Override
    public int getItemCount() {
        return albums.size();
    }

    public void removeAlbum(int pos){
        albums.remove(pos);
        notifyItemRemoved(pos);
    }

    public void addAlbum(Album album){
        albums.add(album);
        notifyItemInserted(albums.size());

    }
}
