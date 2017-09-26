package pl.itgenerator.szkolenia.layouts;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Tomasz on 26.09.2017.
 */

public class Zadanie5 extends AppCompatActivity {

    List<Movie> movies = new LinkedList<>();
    TextView listTv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zadanie5);

        listTv = (TextView) findViewById(R.id.list_of_movies);

        movies.add(new Movie("Skazani na Shawshank", 144));
        movies.add(new Movie("Nietykalni", 112));
        movies.add(new Movie("Zielona mila", 188));
        movies.add(new Movie("Ojciec chrzestny", 175));
        movies.add(new Movie("Forrest Gump", 144));
        movies.add(new Movie("Dwunastu gniewnych ludzi", 96));
        movies.add(new Movie("Lot nad kukułczym gniazdem", 133));
        movies.add(new Movie("Ojciec chrzestny II", 200));
        movies.add(new Movie("Władca Pierścieni: Powrót króla", 201));
        movies.add(new Movie("Pulp Fiction", 154));

        for(int i=0; i< movies.size(); i++){
            Movie movie = movies.get(i);
            listTv.append("Tytuł: " + movie.getTitle() + " Dłg: " + movie.getLength() + "\n");
        }
    }
}
