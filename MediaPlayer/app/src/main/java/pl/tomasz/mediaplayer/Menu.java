package pl.tomasz.mediaplayer;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Tomasz on 12.10.2017.
 */

public class Menu extends AppCompatActivity {

    private Button fromPhoneBtn;
    private Button fromUrlBtn;
    private EditText urlEt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

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
                    int permissionCheck = ContextCompat.checkSelfPermission(Menu.this, Manifest.permission.READ_EXTERNAL_STORAGE);
                    if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
                        //Nie ma permisji
                        ActivityCompat.requestPermissions(Menu.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1001);
                    } else {
                        //Jest permisja
                        startFileChooserActivity();
                    }
                } else {
                    //Android poniżej 6.0
                    startFileChooserActivity();
                }
            }
        });
    }

    public void startFileChooserActivity() {
        Intent intent = new Intent(this, FileChooser.class);
        startActivity(intent);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1001: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //Permisje dodano
                    startFileChooserActivity();
                } else {
                    //Permisje odrzucono

                }
            }
        }
    }
}
