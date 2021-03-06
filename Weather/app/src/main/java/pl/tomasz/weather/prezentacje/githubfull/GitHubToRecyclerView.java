package pl.tomasz.weather.prezentacje.githubfull;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
import java.util.LinkedList;
import java.util.List;

import pl.tomasz.weather.NetUtils;
import pl.tomasz.weather.R;
import pl.tomasz.weather.prezentacje.GitHubRepoModel;

/**
 * Created by Tomasz on 05.10.2017.
 */

public class GitHubToRecyclerView extends AppCompatActivity {

    private TextView result;
    private EditText searchET;
    private Button searchBtn;
    private ProgressBar progressBar;
    private RecyclerView recycler;
    private GitHubAdapter adapter;

    private static final String BASE_URL = "https://api.github.com/search/repositories?q=";

    List<GitHubRepoModel> data = new LinkedList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.github_recycler);

        result = (TextView) findViewById(R.id.result);
        searchET = (EditText) findViewById(R.id.search_et);
        searchBtn = (Button) findViewById(R.id.search_btn);
        progressBar = (ProgressBar) findViewById(R.id.progress);
        recycler = (RecyclerView) findViewById(R.id.recycler);

        adapter = new GitHubAdapter(this, data);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String searchQuery = BASE_URL + searchET.getText().toString();
                Uri uri = Uri.parse(searchQuery);
                URL url = null;
                try {
                    url = new URL(uri.toString());
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                if (url != null) {
                    new GitHubQueryTask().execute(url);
                }
            }
        });

    }

    public class GitHubQueryTask extends AsyncTask<URL, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
            result.setVisibility(View.INVISIBLE);
        }

        @Override
        protected String doInBackground(URL... urls) {
            URL searchUrl = urls[0];
            String resposne = null;
            try {
                resposne = NetUtils.getResponseFromHttpUrl(searchUrl);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return resposne;
        }

        @Override
        protected void onPostExecute(String s) {
            progressBar.setVisibility(View.INVISIBLE);
            result.setVisibility(View.VISIBLE);
            if (s != null && !s.equals("")) {
                result.setText("");
                data.clear();
                try {
                    JSONObject in = new JSONObject(s);
                    JSONArray repos = in.getJSONArray("items");
                    for (int i = 0; i < repos.length(); i++) {
                        JSONObject obj = repos.getJSONObject(i);

                        String name = obj.getString("name");
                        String address = obj.getString("html_url");
                        String lang = obj.getString("language");
                        boolean isPrivate = obj.getBoolean("private");

                        GitHubRepoModel repo = new GitHubRepoModel(name, address, lang, isPrivate);
                        data.add(repo);
                    }
                    adapter = new GitHubAdapter(getApplicationContext(), data);
                    recycler.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                    result.setText(e.toString());
                }
            } else {
                result.setText("Brak wyników zapytania");
            }
        }

    }

}