package pl.tomasz.weather.prezentacje.prefs;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import pl.tomasz.weather.R;

/**
 * Created by Tomasz on 06.10.2017.
 */

public class Second extends AppCompatActivity {

    private Button red;
    private Button green;
    private Button blue;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        red = (Button) findViewById(R.id.red);
        green = (Button) findViewById(R.id.green);
        blue = (Button) findViewById(R.id.blue);

        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveColor(red.getText().toString(), red.getCurrentTextColor());
            }
        });

        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveColor(green.getText().toString(), green.getCurrentTextColor());
            }
        });

        blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveColor(blue.getText().toString(), blue.getCurrentTextColor());
            }
        });
    }

    public void saveColor(String colorString, int color) {
        SharedPreferences prefs = getSharedPreferences("myPreferences", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("colorString", colorString);
        editor.putInt("color", color);
        editor.commit();
        Toast.makeText(getApplicationContext(), "Zapisano", Toast.LENGTH_SHORT).show();
    }
}
