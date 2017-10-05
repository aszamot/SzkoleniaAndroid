package pl.tomasz.intents.prezentacje.zmianyaktywnosci;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import pl.tomasz.intents.R;

/**
 * Created by Tomasz on 29.09.2017.
 */

public class SecondActivity extends AppCompatActivity{

    private TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        textView = (TextView) findViewById(R.id.label);

        Intent intent = getIntent();

        String str = "";
        if( intent != null){
            str = intent.getStringExtra("label");
        }

        textView.setText(str);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Toast.makeText(this,"Cofinj", Toast.LENGTH_SHORT).show();
    }
}
