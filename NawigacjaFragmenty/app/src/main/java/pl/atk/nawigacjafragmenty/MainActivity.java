package pl.atk.nawigacjafragmenty;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/*
    1. Appbar - Done - DONE ONE LESSON
    2. Drawer - Done - DONE ON LESSON
    3. Fragment with lifecycle -
                        lifecycle: https://developer.android.com/guide/components/fragments.html
                        DONE - DONE ON LESSON
    4. FragmentViewPager - DONE - DONE ON LESSON
    5. TabbedFragmentViewPager - DONE ON LESSON
    6. Alert dialog - DONE - DONE ON LESSON
    7. Alert dialog with custom layouts - DONE - DONE ON LESSON
    8. Notifications - DONE
    10. Push Notification FireBase - DONE
 */
public class MainActivity extends AppCompatActivity {

    private Button normalAlertBtn;
    private Button customAlertBtn;
    private TextView answer;

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder;
        builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Normal alert dialog")
                .setMessage("Do you understand?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        answer.setText("YEP");
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity.super.onBackPressed();
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        answer = (TextView) findViewById(R.id.answer);
        normalAlertBtn = (Button) findViewById(R.id.normal_alert_btn);
        customAlertBtn = (Button) findViewById(R.id.custom_alert_btn);

        startService(new Intent(this, FCMService.class));

        normalAlertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder;
                builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Normal alert dialog")
                        .setMessage("Do you understand?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                answer.setText("YEP");
                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                onBackPressed();
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        });

        customAlertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(MainActivity.this);

                LayoutInflater inflater = MainActivity.this.getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.dialog_layout, null);
                dialogBuilder.setView(dialogView);

                final AlertDialog alertDialog = dialogBuilder.create();

                final EditText editText = (EditText) dialogView.findViewById(R.id.dialog_answer_et);
                Button button = (Button) dialogView.findViewById(R.id.dialog_submit_btn);

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        answer.setText(editText.getText().toString());
                        alertDialog.dismiss();
                    }
                });

                alertDialog.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.app_bar_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.settings) {
            startActivity(new Intent(this, ChildActivity.class));
        } else if (item.getItemId() == R.id.other) {
            startActivity(new Intent(this, DrawerActivity.class));
        }

        return true;
    }
}
