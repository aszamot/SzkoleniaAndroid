package pl.tomasz.intents.zadania.zadanie1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.LinkedList;
import java.util.List;

import pl.tomasz.intents.R;

/**
 * Created by Tomasz on 29.09.2017.
 */

public class Zadanie1Acitivty extends AppCompatActivity {

    private RecyclerView recycler;
    private FloatingActionButton btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zadanie1);

        recycler = (RecyclerView) findViewById(R.id.music_recycler);
        btn = (FloatingActionButton) findViewById(R.id.btn);

        List<Album> albums = new LinkedList<>();

        albums.add(new Album("Illmatic","Nas","1994",R.drawable.nas));
        albums.add(new Album("Kind of blue","Miles Davis","1959",R.drawable.miles));
        albums.add(new Album("Życie jak wino","Krzysztof Krawczyk","2011",R.drawable.kraw));
        albums.add(new Album("Catch a fire","Bob Marley","1973",R.drawable.bob));
        albums.add(new Album("The Low End Theory","A Tribe Called Quest","1991",R.drawable.tribe));
        albums.add(new Album("Illmatic","Nas","1994",R.drawable.nas));
        albums.add(new Album("Kind of blue","Miles Davis","1959",R.drawable.miles));
        albums.add(new Album("Życie jak wino","Krzysztof Krawczyk","2011",R.drawable.kraw));
        albums.add(new Album("Catch a fire","Bob Marley","1973",R.drawable.bob));
        albums.add(new Album("The Low End Theory","A Tribe Called Quest","1991",R.drawable.tribe));
        albums.add(new Album("Illmatic","Nas","1994",R.drawable.nas));
        albums.add(new Album("Kind of blue","Miles Davis","1959",R.drawable.miles));
        albums.add(new Album("Życie jak wino","Krzysztof Krawczyk","2011",R.drawable.kraw));
        albums.add(new Album("Catch a fire","Bob Marley","1973",R.drawable.bob));
        albums.add(new Album("The Low End Theory","A Tribe Called Quest","1991",R.drawable.tribe));

        final MusicAdapter adapter = new MusicAdapter(this, albums);

        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Album album = new Album("Illmatic","Nas","1994",R.drawable.nas);
                adapter.addAlbum(album);
                recycler.scrollToPosition(adapter.getItemCount()-1);
            }
        });
    }
}
