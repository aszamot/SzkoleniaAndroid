package pl.tomasz.intents.zadania.zadanie4;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import pl.tomasz.intents.R;

/**
 * Created by Tomasz on 29.09.2017.
 */

public class Zadanie4ActivityFirst extends AppCompatActivity {

    private Button btn;
    private EditText edit;
    private TextView text;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_zadanie4);

        edit = (EditText) findViewById(R.id.edit);
        btn = (Button) findViewById(R.id.btn);
        text = (TextView) findViewById(R.id.result);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fromEdit = edit.getText().toString();
                if (fromEdit.isEmpty()) {
                    edit.setError("EditText jest pusty");
                } else {
                    text.setText(edit.getText().toString());
                    edit.setError(null);
                    Intent intent = new Intent(getApplicationContext(), Zadanie4ActivitySecond.class);
                    intent.putExtra("FROM_EDIT", fromEdit);
                    startActivity(intent);
                }
            }
        });

        if (savedInstanceState != null) {
            String result = savedInstanceState.getString("RESULT");
            text.setText(result);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("RESULT", edit.getText().toString());
    }
}
