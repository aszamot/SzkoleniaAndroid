package pl.tomasz.weather.prezentacje.githubfull;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.LinkedList;
import java.util.List;

import pl.tomasz.weather.prezentacje.GitHubRepoModel;

/**
 * Created by Tomasz on 06.10.2017.
 */

public class GitHubDBAdapter extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "github.db";
    private static final String DB_GIT_TABLE = "github";
    private static final String KEY_NAME = "name";
    private static final String KEY_ADDRESS = "address";
    private static final String KEY_LANGUAGE = "language";
    private static final String KEY_IS_PRIVATE = "isPrivate";

    public GitHubDBAdapter(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + DB_GIT_TABLE + "("
                + "id" + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_ADDRESS + " TEXT," + KEY_LANGUAGE + " TEXT,"
                + KEY_IS_PRIVATE + " INTEGER" + ")";
        sqLiteDatabase.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DB_GIT_TABLE);
        onCreate(sqLiteDatabase);
    }

    public void addRepo(GitHubRepoModel repo) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, repo.getName());
        values.put(KEY_ADDRESS, repo.getAddress());
        values.put(KEY_LANGUAGE, repo.getLanguage());
        values.put(KEY_IS_PRIVATE, repo.isPrivate());

        db.insert(DB_GIT_TABLE, null, values);
        db.close();
    }

    public List<GitHubRepoModel> getAllRepos() {
        List<GitHubRepoModel> repos = new LinkedList<>();

        String selectQuery = "SELECT * FROM " + DB_GIT_TABLE;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                GitHubRepoModel repo = new GitHubRepoModel();

                repo.setName(cursor.getString(1));
                repo.setAddress(cursor.getString(2));
                repo.setLanguage(cursor.getString(3));

                boolean flag;
                int i = cursor.getInt(4);
                if(i == 0){
                    flag = false;
                }else{
                    flag = true;
                }

                repo.setPrivate(flag);

                repos.add(repo);
            } while (cursor.moveToNext());
        }
        db.close();
        return repos;
    }

    public void clearRepos() {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("delete from " + DB_GIT_TABLE);
        db.close();
    }

}
