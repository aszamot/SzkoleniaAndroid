package com.example.tomasz.myapplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int READ_PERM_CODE = 1001;

    private Button fromPhoneBtn;
    private Button fromUrlBtn;
    private EditText urlEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fromPhoneBtn = (Button) findViewById(R.id.from_tel_btn);
        fromUrlBtn = (Button) findViewById(R.id.from_url);
        urlEt = (EditText) findViewById(R.id.url_et);

        fromUrlBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), VideoPlayer.class);
                intent.putExtra("video_to_play", urlEt.getText().toString());
                startActivity(intent);
            }
        });

        fromPhoneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= 23) {
                    int permissonCheck = ContextCompat.checkSelfPermission(
                            getApplicationContext(),
                            Manifest.permission.READ_EXTERNAL_STORAGE);
                    if (permissonCheck != PackageManager.PERMISSION_GRANTED) {
                        //nie masz permisji
                        ActivityCompat.requestPermissions(
                                MainActivity.this,
                                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                                READ_PERM_CODE);
                    } else {
                        //masz permisje
                        startFileChooserActivity();
                    }
                } else {
                    startFileChooserActivity();
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == READ_PERM_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //permisje nadano
                startFileChooserActivity();
            } else {
                //permisji nie nadano
                Toast.makeText(getApplicationContext(),
                        "Nie dano pozwolenia, nie możesz korzystać z tej funkcjonalności",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void startFileChooserActivity(){
        Intent intent = new Intent(this,  FileChooser.class);
        startActivity(intent);
    }
}
