package pl.tomasz.intents.zadania.zadanie4;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import pl.tomasz.intents.R;

/**
 * Created by Tomasz on 29.09.2017.
 */

public class Zadanie4ActivitySecond extends AppCompatActivity {

    private TextView result;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_zadanie4);

        result = (TextView) findViewById(R.id.result_tv);

        Intent intent = getIntent();
        if (intent != null) {
            String fromEdit = intent.getStringExtra("FROM_EDIT");
            result.setText(fromEdit);
        }
    }
}
