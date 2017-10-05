package pl.tomasz.intents.prezentacje.lifecycle;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import pl.tomasz.intents.R;

/**
 * Created by Tomasz on 29.09.2017.
 */

public class LifeCycleSecond extends AppCompatActivity {

    private static final String TAG = "LIFECYCLE_SECOND";
    private EditText editText;
    private TextView textView;
    private Button btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lc_second);

        editText = (EditText) findViewById(R.id.edit);
        textView = (TextView) findViewById(R.id.text);
        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(editText.getText().toString());
            }
        });

        if(savedInstanceState != null){
            String napis = savedInstanceState.getString("napisZTextView");
            textView.setText(napis);
        }

        Log.i(TAG, "stworzono");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "zapisano dane");
        String napis = textView.getText().toString();
        outState.putString("napisZTextView", napis);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "wystartowano");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "wznowiono");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "spauzowano");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "zniszczono");
    }
}

