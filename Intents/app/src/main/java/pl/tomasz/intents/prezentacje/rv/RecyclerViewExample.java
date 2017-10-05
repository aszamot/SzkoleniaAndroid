package pl.tomasz.intents.prezentacje.rv;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.LinkedList;
import java.util.List;

import pl.tomasz.intents.R;

/**
 * Created by Tomasz on 29.09.2017.
 */

public class RecyclerViewExample extends AppCompatActivity {

    private RecyclerView recycler;
    private FloatingActionButton btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_example);

        recycler = (RecyclerView) findViewById(R.id.recycler);
        btn = (FloatingActionButton) findViewById(R.id.btn);

        List<Integer> data = new LinkedList<>();
        for(int i=0; i<40; i++){
            data.add(i);
        }

        final MyAdapter adapter = new MyAdapter(data, getApplicationContext());
        recycler.setAdapter(adapter);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(this));


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.addNewItem(999);
                recycler.scrollToPosition(adapter.getItemCount()-1);
            }
        });
    }
}
