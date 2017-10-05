package pl.tomasz.intents.zadania.zadanie5;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import pl.tomasz.intents.R;
import pl.tomasz.intents.zadania.zadanie1.Zadanie1Acitivty;
import pl.tomasz.intents.zadania.zadanie3.Zadanie3Activity;
import pl.tomasz.intents.zadania.zadanie4.Zadanie4ActivityFirst;
import pl.tomasz.intents.zadania.zadanie7.Zadanie7Activity;
import pl.tomasz.intents.zadania.zadanie8.Zadanie8Activity;

/**
 * Created by Tomasz on 29.09.2017.
 */

public class Zadanie5Activity extends AppCompatActivity {

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn5;
    private Button btn6;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zadanie5);

        btn1 = (Button) findViewById(R.id.zadanie_1);
        btn2 = (Button) findViewById(R.id.zadanie_3);
        btn3 = (Button) findViewById(R.id.zadanie_4);
        btn5 = (Button) findViewById(R.id.zadanie_7);
        btn6 = (Button) findViewById(R.id.zadanie_8);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Zadanie1Acitivty.class);
                startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Zadanie3Activity.class);
                startActivity(intent);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Zadanie4ActivityFirst.class);
                startActivity(intent);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Zadanie7Activity.class);
                startActivity(intent);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Zadanie8Activity.class);
                startActivity(intent);
            }
        });
    }
}
