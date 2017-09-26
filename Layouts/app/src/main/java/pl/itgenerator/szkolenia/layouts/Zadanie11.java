package pl.itgenerator.szkolenia.layouts;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Tomasz on 26.09.2017.
 */

public class Zadanie11 extends AppCompatActivity {

    EditText login;
    EditText password;
    Button loginBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zadanie6);

        login = (EditText) findViewById(R.id.login);
        password = (EditText) findViewById(R.id.pass);
        loginBtn = (Button) findViewById(R.id.login_btn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (canTryToLogin(login, "Login pusty") && canTryToLogin(password, "Hasło puste")) {
                    if (login.getText().toString().equals("user") &&
                            password.getText().toString().equals("qwe123")) {
                        Toast.makeText(getApplicationContext(), getResources().getString(R.string.logged)
                                , Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), getResources().getString(R.string.error_login)
                                , Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }

    private boolean checkIfEditTextIsEmpty(EditText et) {
        return et.getText().toString().isEmpty();
    }

    private boolean canTryToLogin(EditText et, String errorMsg) {
        if (checkIfEditTextIsEmpty(et)) {
            et.setError(errorMsg);
            return false;
        } else {
            et.setError(null);
            return true;
        }
    }

}
