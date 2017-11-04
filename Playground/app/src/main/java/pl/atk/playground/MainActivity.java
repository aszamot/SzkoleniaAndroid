package pl.atk.playground;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LinkedList<Application> apki = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < 10; i++) {
            apki.add(new Application("Hustle Castle: Fantasy Kingdom",
                    "https://lh3.googleusercontent.com/H5wnbecQWYeITcDXDu_8WruUjgKM58KQUwOzyBC55jbHV7B2KE-B1o2FLmEZWyjmFs3w=w300-rw",
                    getResources().getString(R.string.apka1), 4.6f));

            apki.add(new Application("Castle Crush: Free Strategy Card Games",
                    "https://lh3.googleusercontent.com/AVxqKEayW-wIff4rkIr_AzXuFdTQjfOoejEIPEHVTMkfdmmBDoGutJxHACoIF0ggODM=w300-rw",
                    getResources().getString(R.string.apka2), 3.4f));
        }

        recyclerView = (RecyclerView) findViewById(R.id.recycler);

        recyclerView.setAdapter(new AppAdapter(this, apki));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
