package pl.atk.playground;

import android.content.Intent;
import android.icu.util.RangeValueIterator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by Tomasz on 04.11.2017.
 */

public class SecondActivity extends AppCompatActivity {

    private ImageView logo;
    private TextView name;
    private RatingBar ratingBar;
    private TextView desc;

    private Application app;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        logo = (ImageView) findViewById(R.id.logo);
        name = (TextView) findViewById(R.id.name);
        ratingBar = (RatingBar) findViewById(R.id.raiting);
        desc = (TextView) findViewById(R.id.desc);

        Intent intent = getIntent();
        if(intent != null){
            app = (Application) intent.getSerializableExtra("app");
        }

        if(app != null){
            name.setText(app.getName());
            ratingBar.setRating(app.getRating());
            desc.setText(app.getDesc());

            Glide.with(this)
                    .load(app.getLogoUrl())
                    .into(logo);
        }
    }
}
