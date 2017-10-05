package pl.tomasz.intents.powtorka;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import pl.tomasz.intents.R;

/**
 * Created by Tomasz on 29.09.2017.
 */

public class Zadanie14 extends AppCompatActivity {

    private Button red;
    private Button blue;
    private Button green;
    private TextView text;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zadanie14);

        red = (Button) findViewById(R.id.red_btn);
        blue = (Button) findViewById(R.id.blue_btn);
        green = (Button) findViewById(R.id.green_btn);

        text = (TextView) findViewById(R.id.textView);

        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setTextColor(getColor(R.color.red));
            }
        });

        blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setTextColor(getColor(R.color.blue));
            }
        });

        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setTextColor(getColor(R.color.green));
            }
        });

    }
}
