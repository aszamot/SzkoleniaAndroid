package pl.tomasz.mediaplayer;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Tomasz on 12.10.2017.
 */

public class FileViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private Context context;

    private TextView path;

    public FileViewHolder(Context context, View itemView) {
        super(itemView);
        this.context = context;
        path = (TextView) itemView.findViewById(R.id.file_path);
        itemView.setOnClickListener(this);
    }

    public void bindData(String pathString) {
        path.setText(pathString);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(context, VideoPlayer.class);
        intent.putExtra("video_to_play", path.getText());
        context.startActivity(intent);
    }
}
