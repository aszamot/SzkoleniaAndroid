package pl.tomasz.weather.zadania.zadanie2;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
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

/**
 * Created by Tomasz on 06.10.2017.
 */

public class WeatherToTextViewJSON extends AppCompatActivity {

    private TextView result;
    private EditText searchET;
    private Button searchBtn;
    private ProgressBar progressBar;

    private static final String API_KEY = "&APPID=e378120272c670db540b58db72d8c753";
    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/forecast?q=";

    List<WeatherModel> forecast = new LinkedList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather_text_proper);

        result = (TextView) findViewById(R.id.result);
        searchET = (EditText) findViewById(R.id.search_et);
        searchBtn = (Button) findViewById(R.id.search_btn);
        progressBar = (ProgressBar) findViewById(R.id.progress);

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
                    new WeatherQueryTask().execute(url);
                }
            }
        });

    }

    public class WeatherQueryTask extends AsyncTask<URL, Void, String> {

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
                forecast.clear();
                try {
                    JSONObject in = new JSONObject(s);

                    JSONObject cityObj = in.getJSONObject("city");
                    String city = cityObj.getString("name");

                    JSONArray forecasts = in.getJSONArray("list");
                    for (int i = 0; i < forecasts.length(); i++) {
                        JSONObject obj = forecasts.getJSONObject(i);

                        long dt = obj.getLong("dt");
                        Date date = new Date(dt*1000);

                        JSONObject main = obj.getJSONObject("main");
                        double temp = main.getDouble("temp");

                        JSONArray weath = obj.getJSONArray("weather");
                        String weatherGroup = weath.getJSONObject(0).getString("main");
                        String iconId = weath.getJSONObject(0).getString("icon");

                        forecast.add(new WeatherModel(city, date.toString(), temp, weatherGroup, iconId));
                    }
                    setTextView();
                } catch (JSONException e) {
                    e.printStackTrace();
                    result.setText(e.toString());
                }
            } else {
                result.setText("Brak wyników zapytania");
            }
        }

        private void setTextView() {
            result.setText("");
            for (int i = 0; i < forecast.size(); i++) {
                WeatherModel weatherModel = forecast.get(i);
                result.append(weatherModel.getCity() + "\n");
                result.append(weatherModel.getDate() + "\n");
                result.append(weatherModel.getTemp() + "\n");
                result.append(weatherModel.getWeatherGroup() + "\n");
                result.append("\n----------------------------\n");
            }
        }
    }
}
