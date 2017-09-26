package pl.itgenerator.szkolenia.layouts;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Tomasz on 26.09.2017.
 */

public class Zadanie9 extends AppCompatActivity {

    EditText editText;
    Button btn;
    TextView result;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zadanie9);

        editText = (EditText) findViewById(R.id.edit);
        btn = (Button) findViewById(R.id.btn);
        result = (TextView) findViewById(R.id.text);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(editText.getText().toString());
            }
        });
    }
}
