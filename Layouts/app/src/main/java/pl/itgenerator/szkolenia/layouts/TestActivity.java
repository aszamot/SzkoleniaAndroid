package pl.itgenerator.szkolenia.layouts;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Tomasz on 26.09.2017.
 */

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TUTAJ ZMIENIAJCIE ID LAYOUTU
        setContentView(R.layout.zadanie1);
    }
}
