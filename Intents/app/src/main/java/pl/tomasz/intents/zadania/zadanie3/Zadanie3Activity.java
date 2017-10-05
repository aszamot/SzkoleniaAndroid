package pl.tomasz.intents.zadania.zadanie3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.LinkedList;
import java.util.List;

import pl.tomasz.intents.R;

/**
 * Created by Tomasz on 29.09.2017.
 */

public class Zadanie3Activity extends AppCompatActivity{

    private ViewPager pager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zadanie3);

        pager = (ViewPager) findViewById(R.id.pager);

        List<Book> books = new LinkedList<>();
        books.add(new Book(getResources().getString(R.string.poczatek), getResources().getString(R.string.poczatek_desc)));
        books.add(new Book(getResources().getString(R.string.rok), getResources().getString(R.string.rok_desc)));
        books.add(new Book(getResources().getString(R.string.spiace), getResources().getString(R.string.spiac_desc)));
        books.add(new Book(getResources().getString(R.string.folwark), getResources().getString(R.string.folwark_desc)));

        BooksAdapter adapter = new BooksAdapter(this, books);
        pager.setAdapter(adapter);
    }
}
