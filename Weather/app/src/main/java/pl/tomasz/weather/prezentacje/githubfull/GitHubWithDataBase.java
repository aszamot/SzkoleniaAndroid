package pl.tomasz.weather.prezentacje.githubfull;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import pl.tomasz.weather.NetUtils;
import pl.tomasz.weather.R;
import pl.tomasz.weather.prezentacje.GitHubRepoModel;

/**
 * Created by Tomasz on 06.10.2017.
 */

public class GitHubWithDataBase extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {

    private TextView result;
    private EditText searchET;
    private Button searchBtn;
    private ProgressBar progressBar;
    private RecyclerView recycler;
    private GitHubAdapter adapter;

    GitHubDBAdapter db;

    private static final String BASE_URL = "https://api.github.com/search/repositories?q=";
    public static final int LOADER_ID = 22;

    List<GitHubRepoModel> data = new LinkedList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.github_recycler);

        db = new GitHubDBAdapter(this);

        result = (TextView) findViewById(R.id.result);
        searchET = (EditText) findViewById(R.id.search_et);
        searchBtn = (Button) findViewById(R.id.search_btn);
        progressBar = (ProgressBar) findViewById(R.id.progress);
        recycler = (RecyclerView) findViewById(R.id.recycler);

        adapter = new GitHubAdapter(this, data);
        adapter.insertList(db.getAllRepos());
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(this));


        final LoaderManager.LoaderCallbacks<String> callbacks = this;

        getSupportLoaderManager().initLoader(LOADER_ID, null, callbacks);

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isNetworkAvailable()) {
                    String searchQuery = BASE_URL + searchET.getText().toString();
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
                }else {
                    Toast.makeText(getApplicationContext(), "Nie masz połączenia z internetem", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }



    public boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override
    public Loader<String> onCreateLoader(int id, final Bundle args) {
        return new AsyncTaskLoader<String>(this) {
            @Override
            protected void onStartLoading() {
                super.onStartLoading();
                if (args == null) {
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);
                result.setVisibility(View.INVISIBLE);

                forceLoad();
            }

            @Override
            public String loadInBackground() {
                String urlString = args.getString("query");
                if (urlString == null || urlString.isEmpty()) {
                    return null;
                }
                try {
                    URL url = new URL(urlString);
                    return NetUtils.getResponseFromHttpUrl(url);
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        };
    }

    @Override
    public void onLoadFinished(Loader<String> loader, String data) {
        progressBar.setVisibility(View.INVISIBLE);
        result.setVisibility(View.VISIBLE);
        if (data != null && !data.equals("")) {
            result.setText("");
            db.clearRepos();
            this.data.clear();
            try {
                JSONObject in = new JSONObject(data);
                JSONArray repos = in.getJSONArray("items");
                for (int i = 0; i < repos.length(); i++) {
                    JSONObject obj = repos.getJSONObject(i);

                    String name = obj.getString("name");
                    String address = obj.getString("html_url");
                    String lang = obj.getString("language");
                    boolean isPrivate = obj.getBoolean("private");

                    GitHubRepoModel repo = new GitHubRepoModel(name, address, lang, isPrivate);
                    this.data.add(repo);
                    db.addRepo(repo);
                }
                adapter = new GitHubAdapter(getApplicationContext(), this.data);
                recycler.setAdapter(adapter);
            } catch (JSONException e) {
                e.printStackTrace();
                result.setText(e.toString());
            }
        } else {
            result.setText("Brak wyników zapytania");
        }
    }

    @Override
    public void onLoaderReset(Loader<String> loader) {

    }

}
