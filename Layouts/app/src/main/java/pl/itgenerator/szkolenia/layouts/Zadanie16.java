package pl.itgenerator.szkolenia.layouts;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;

/**
 * Created by Tomasz on 26.09.2017.
 */

public class Zadanie16 extends AppCompatActivity {

    ImageView image;
    ImageButton left;
    ImageButton right;
    TextView indicatorTv;
    int indicator = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zadanie16);

        final LinkedList<Integer> images = new LinkedList<>();
        images.add(R.drawable.android);
        images.add(R.drawable.android2);
        images.add(R.drawable.android3);

        image = (ImageView) findViewById(R.id.image);
        left = (ImageButton) findViewById(R.id.left);
        right = (ImageButton) findViewById(R.id.right);
        indicatorTv = (TextView) findViewById(R.id.indicator);


        image.setImageDrawable(getResources().getDrawable(images.get(indicator)));
        setIndicatorTv(indicator+1, images.size());

        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(indicator < images.size()-1){
                    indicator++;
                }else{
                    indicator = 0;
                }
                image.setImageDrawable(getResources().getDrawable(images.get(indicator)));
                setIndicatorTv(indicator+1, images.size());
            }
        });

        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(indicator > 0){
                    indicator--;
                }else{
                    indicator = images.size()-1;
                }
                image.setImageDrawable(getResources().getDrawable(images.get(indicator)));
                setIndicatorTv(indicator+1, images.size());
            }
        });

    }

    private void setIndicatorTv(int which, int size){
        indicatorTv.setText(which + "/" + size);
    }
}
