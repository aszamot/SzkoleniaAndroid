package pl.tomasz.weather.zadania.zadanie6;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.LinkedList;
import java.util.List;

import pl.tomasz.weather.prezentacje.GitHubRepoModel;
import pl.tomasz.weather.zadania.WeatherModel;

/**
 * Created by Tomasz on 06.10.2017.
 */

public class WeatherDB extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "weather.db";
    private static final String DB_FORECAST_TABLE = "forecast";
    private static final String KEY_CITY = "city";
    private static final String KEY_DATE = "date";
    private static final String KEY_TEMP = "temp";
    private static final String KEY_ICON_ID = "iconID";

    public WeatherDB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + DB_FORECAST_TABLE + "("
                + "id" + " INTEGER PRIMARY KEY," + KEY_CITY + " TEXT,"
                + KEY_DATE + " TEXT," + KEY_TEMP + " REAL,"
                + KEY_ICON_ID + " TEXT" + ")";
        sqLiteDatabase.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DB_FORECAST_TABLE);
        onCreate(sqLiteDatabase);
    }

    public void addForcast(WeatherModel model) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_CITY, model.getCity());
        values.put(KEY_DATE, model.getDate());
        values.put(KEY_TEMP, model.getTemp());
        values.put(KEY_ICON_ID, model.getIconId());

        db.insert(DB_FORECAST_TABLE, null, values);
        db.close();
    }

    public List<WeatherModel> getAllForecast() {
        List<WeatherModel> forcast = new LinkedList<>();

        String selectQuery = "SELECT * FROM " + DB_FORECAST_TABLE;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                WeatherModel model = new WeatherModel();

                model.setCity(cursor.getString(1));
                model.setDate(cursor.getString(2));
                model.setTemp(cursor.getDouble(3));
                model.setIconId(cursor.getString(4));

                forcast.add(model);
            } while (cursor.moveToNext());
        }
        db.close();
        return forcast;
    }

    public void clearForcast() {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("delete from " + DB_FORECAST_TABLE);
        db.close();
    }

}
