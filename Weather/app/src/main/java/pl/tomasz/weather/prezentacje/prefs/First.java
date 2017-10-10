package pl.tomasz.weather.prezentacje.prefs;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import pl.tomasz.weather.R;

/**
 * Created by Tomasz on 06.10.2017.
 */

public class First extends AppCompatActivity {

    private TextView colorTv;
    private Button btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        colorTv = (TextView) findViewById(R.id.color);
        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Second.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences prefs = getSharedPreferences("myPreferences", Activity.MODE_PRIVATE);
        String colorPrefs = prefs.getString("colorString", "");
        int color = prefs.getInt("color", R.color.black);

        colorTv.setText(colorPrefs);
        colorTv.setTextColor(color);

    }
}
