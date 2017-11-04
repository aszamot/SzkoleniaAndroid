package pl.atk.playground;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

/**
 * Created by Tomasz on 04.11.2017.
 */

public class AppViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private Context context;

    private TextView name;
    private ImageView logo;
    private RatingBar ratingBar;

    private Application app;

    public AppViewHolder(View itemView, Context context) {
        super(itemView);
        this.context = context;

        name = (TextView) itemView.findViewById(R.id.name);
        logo = (ImageView) itemView.findViewById(R.id.logo);
        ratingBar = (RatingBar) itemView.findViewById(R.id.raiting);

        itemView.setOnClickListener(this);
    }

    public void bindData(Application app) {
        this.app = app;

        name.setText(app.getName());
        ratingBar.setRating(app.getRating());

        Glide.with(context)
                .load(app.getLogoUrl())
                .into(logo);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(context, SecondActivity.class);
        intent.putExtra("app", app);

        context.startActivity(intent);
    }
}
