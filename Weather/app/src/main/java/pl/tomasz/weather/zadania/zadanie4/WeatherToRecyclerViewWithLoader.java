package pl.tomasz.weather.zadania.zadanie4;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import pl.tomasz.weather.NetUtils;
import pl.tomasz.weather.R;
import pl.tomasz.weather.zadania.WeatherModel;
import pl.tomasz.weather.zadania.zadanie3.WeatherAdapter;
import pl.tomasz.weather.zadania.zadanie3.WeatherToRecyclerView;

/**
 * Created by Tomasz on 06.10.2017.
 */

public class WeatherToRecyclerViewWithLoader extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {

    private TextView result;
    private EditText searchET;
    private Button searchBtn;
    private ProgressBar progressBar;
    private RecyclerView recycler;
    private WeatherAdapter adapter;

    private static final String API_KEY = "&APPID=e378120272c670db540b58db72d8c753";
    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/forecast?q=";
    public static final int LOADER_ID = 23;

    List<WeatherModel> forecast = new LinkedList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather_recycler);

        result = (TextView) findViewById(R.id.result);
        searchET = (EditText) findViewById(R.id.search_et);
        searchBtn = (Button) findViewById(R.id.search_btn);
        progressBar = (ProgressBar) findViewById(R.id.progress);
        recycler = (RecyclerView) findViewById(R.id.recycler);

        adapter = new WeatherAdapter(this, forecast);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        final LoaderManager.LoaderCallbacks<String> callbacks = this;

        getSupportLoaderManager().initLoader(LOADER_ID, null, callbacks);

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String searchQuery = BASE_URL + searchET.getText().toString() + API_KEY + "&units=metric";
                Uri uri = Uri.parse(searchQuery);
                URL url = null;
                try {
                    url = new URL(uri.toString());
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                if (url != null) {
                    Bundle queryBundle = new Bundle();
                    queryBundle.putString("query", url.toString());

                    LoaderManager loaderManager = getSupportLoaderManager();
                    Loader<String> stringLoader = loaderManager.getLoader(LOADER_ID);

                    if (stringLoader == null) {
                        loaderManager.initLoader(LOADER_ID, queryBundle, callbacks);
                    } else {
                        loaderManager.restartLoader(LOADER_ID, queryBundle, callbacks);
                    }
                }
            }
        });

    }

    @Override
    public Loader<String> onCreateLoader(int id, Bundle args) {
        return null;
    }

    @Override
    public void onLoadFinished(Loader<String> loader, String data) {

    }

    @Override
    public void onLoaderReset(Loader<String> loader) {

    }

}

