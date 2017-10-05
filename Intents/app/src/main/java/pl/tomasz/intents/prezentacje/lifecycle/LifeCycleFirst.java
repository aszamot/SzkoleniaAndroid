package pl.tomasz.intents.prezentacje.lifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import pl.tomasz.intents.R;

/**
 * Created by Tomasz on 29.09.2017.
 */

public class LifeCycleFirst extends AppCompatActivity {

    private static final String TAG = "LIFECYCLE_FIRST";
    private Button btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first);

        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LifeCycleSecond.class);
                startActivity(intent);
            }
        });

        Log.i(TAG, "stworzono");
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
