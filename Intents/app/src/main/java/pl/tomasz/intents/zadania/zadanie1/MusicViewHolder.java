package pl.tomasz.intents.zadania.zadanie1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import pl.tomasz.intents.R;

/**
 * Created by Tomasz on 29.09.2017.
 */

public class MusicViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

    private TextView title;
    private TextView artist;
    private TextView year;
    private ImageView cover;
    private Context context;
    private MusicAdapter adapter;

    public MusicViewHolder(View itemView, Context context, MusicAdapter adapter) {
        super(itemView);
        this.context = context;
        this.adapter = adapter;
        title = (TextView) itemView.findViewById(R.id.title);
        artist = (TextView) itemView.findViewById(R.id.artist);
        year = (TextView) itemView.findViewById(R.id.year);
        cover = (ImageView) itemView.findViewById(R.id.cover);
        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
    }

    public void bindData(Album album) {
        title.setText(album.getTitle());
        artist.setText(album.getArtist());
        year.setText(album.getYear());

        cover.setImageDrawable(context.getResources().getDrawable(album.getImageId()));
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(context, title.getText(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onLongClick(View view) {
        adapter.removeAlbum(getAdapterPosition());
        return false;
    }
}
