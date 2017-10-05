package pl.tomasz.intents.zadania.zadanie8;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import pl.tomasz.intents.R;

/**
 * Created by Tomasz on 29.09.2017.
 */

public class Zadanie8Activity extends AppCompatActivity {

    private EditText mailTo;
    private EditText subject;
    private EditText text;
    private Button btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zadanie8);

        mailTo = (EditText) findViewById(R.id.to_et);
        subject = (EditText) findViewById(R.id.subject_et);
        text = (EditText) findViewById(R.id.text_et);
        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isValid = true;
                if (mailTo.getText().toString().isEmpty()) {
                    mailTo.setError("Adresat nie możę być pusty");
                    isValid = false;
                } else {
                    mailTo.setError(null);
                }

                if (subject.getText().toString().isEmpty()) {
                    subject.setError("Temat nie możę być pusty");
                    isValid = false;
                } else {
                    subject.setError(null);
                }

                if (isValid) {
                    String[] addres = {mailTo.getText().toString()};
                    composeEmail(addres, subject.getText().toString(), text.getText().toString());
                }
            }
        });

    }

    public void composeEmail(String[] addresses, String subject, String text) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, text);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
