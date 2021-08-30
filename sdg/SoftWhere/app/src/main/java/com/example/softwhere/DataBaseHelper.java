package com.example.softwhere;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.softwhere.Asorted.Jobs;
import com.example.softwhere.Asorted.Languages;
import com.example.softwhere.Asorted.ShortJob;

import java.util.ArrayList;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String JOB_DETAILS_TABLE = "job_details";
    public static final String JOB_COLUMN_ID = "id";
    public static final String JOB_COLUMN_TITLE = "job_title";
    public static final String JOB_COLUMN_DESCRIPTION = "job_description";
    public static final String JOB_COLUMN_SALARY = "salary";
    public static final String JOB_COLUMN_SKILLS = "skills";
    public static final String JOB_COLUMN_LINK = "link";
    public static final String JOB_COLUMN_IMAGE_URL = "job_image_url";

    public static final String LANGUAGES_TABLE = "languages";
    public static final String LANGUAGES_COLUMN_ID = "id";
    public static final String LANGUAGES_COLUMN_TITLE = "title";
    public static final String LANGUAGES_COLUMN_TYPE = "type";
    public static final String LANGUAGES_COLUMN_DESCRIPTION = "description";
    public static final String LANGUAGES_COLUMN_STATUS = "status";

    public DataBaseHelper(@Nullable Context context) {
        super(context, "softwhere_details.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatment =
                "CREATE TABLE " + JOB_DETAILS_TABLE +
                        " (" + JOB_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        JOB_COLUMN_TITLE + " VARCHAR(63), " +
                        JOB_COLUMN_DESCRIPTION + " TEXT, " +
                        JOB_COLUMN_SALARY + " VARCHAR(25), " +
                        JOB_COLUMN_SKILLS + " TEXT, " +
                        JOB_COLUMN_LINK + " VARCHAR(255), " +
                        JOB_COLUMN_IMAGE_URL + " VARCHAR(255));";

        db.execSQL(createTableStatment);

        createTableStatment =
                "CREATE TABLE " + LANGUAGES_TABLE  +
                        " (" + LANGUAGES_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        LANGUAGES_COLUMN_TITLE + " VARCHAR(31), " +
                        LANGUAGES_COLUMN_TYPE + " VARCHAR(63), " +
                        LANGUAGES_COLUMN_DESCRIPTION + " TEXT, " +
                        LANGUAGES_COLUMN_STATUS + " VARCHAR(15))";

        db.execSQL(createTableStatment);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    // =============================================
    // JOB QUERIES
    // =============================================

    public boolean addJob(Jobs job) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(JOB_COLUMN_TITLE, job.getTitle());
        cv.put(JOB_COLUMN_DESCRIPTION, job.getDescription());
        cv.put(JOB_COLUMN_SALARY, job.getSalary());
        cv.put(JOB_COLUMN_SKILLS, job.getSkills());
        cv.put(JOB_COLUMN_LINK, job.getLink());
        cv.put(JOB_COLUMN_IMAGE_URL, job.getImageURL());

        long insert = db.insert(JOB_DETAILS_TABLE, null, cv);
        if(insert == -1)
            return false;
        return true;
    }

    public boolean deleteOneJob(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String queryString = "DELETE FROM " + JOB_DETAILS_TABLE + " WHERE " + JOB_COLUMN_ID + " = " + id + ";";

        Cursor cursor = db.rawQuery(queryString, null);
        if(cursor.moveToFirst())
            return false;

        return true;
    }

    public ArrayList<ShortJob> getAllCardJobs() {
        ArrayList<ShortJob> shortJobs = new ArrayList<>();

        String queryString = "SELECT " +
                JOB_COLUMN_ID + ", " +
                JOB_COLUMN_TITLE + ", " +
                JOB_COLUMN_SALARY + ", " +
                JOB_COLUMN_IMAGE_URL +
                " FROM " + JOB_DETAILS_TABLE + ";";

//        String queryString = "SELECT * FROM " + JOB_DETAILS_TABLE + ";";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if(cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String title = cursor.getString(1);
                String salary = cursor.getString(2);
                String imageURL = cursor.getString(3);

                shortJobs.add(new ShortJob(id, title, salary, imageURL));
            } while(cursor.moveToNext());
        }
        else {
            // Do nothing.
        }

        cursor.close();
        db.close();

        return shortJobs;
    }

    public Jobs getJobById(int id) {
        Jobs job;

        String queryString = "SELECT * FROM " + JOB_DETAILS_TABLE + " " +
                "WHERE " + JOB_COLUMN_ID + " = " + id + ";";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if(cursor.moveToFirst()) {
            int jobId = cursor.getInt(0);
            String title = cursor.getString(1);
            String description = cursor.getString(2);
            String salary = cursor.getString(3);
            String skills = cursor.getString(4);
            String link = cursor.getString(5);
            String imageURL = cursor.getString(6);

            job = new Jobs(jobId, title, description, skills, link, salary, imageURL);
        }
        else {
            job = new Jobs(-1, "No Title Available", "No Description Available", "No Skills Available","No Link Available", "No Salary Available","https://as1.ftcdn.net/jpg/02/57/42/72/500_F_257427286_Lp7c9XdPnvN46TyFKqUaZpPADJ77ZzUk.jpg");
        }

        cursor.close();
        db.close();

        return job;
    }

    // =============================================
    // LANGUAGE QUERIES
    // =============================================

    public boolean addLanguage(Languages language) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(LANGUAGES_COLUMN_TITLE, language.getTitle());
        cv.put(LANGUAGES_COLUMN_TYPE, language.getType());
        cv.put(LANGUAGES_COLUMN_DESCRIPTION, language.getDescription());
        cv.put(LANGUAGES_COLUMN_STATUS, language.getStatus());

        long insert = db.insert(LANGUAGES_TABLE, null, cv);
        if(insert == -1)
            return false;
        return true;

    }

    public boolean deleteOneLanguage(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String queryString = "DELETE FROM " + LANGUAGES_TABLE + " WHERE " + LANGUAGES_COLUMN_ID + " = " + id + ";";

        Cursor cursor = db.rawQuery(queryString, null);
        if(cursor.moveToFirst())
            return true;

        return false;
    }

    public ArrayList<Languages> getAllLanguages(String searchQuery, String statusQuery) {
        // ===================================================================================
        searchQuery = "%" + searchQuery + "%";
        searchQuery = "'" + searchQuery + "'";

        statusQuery = "%" + statusQuery + "%";
        statusQuery = "'" + statusQuery + "'";
        // ===================================================================================

        ArrayList<Languages> languages = new ArrayList<>();

        String queryString = "SELECT * FROM " + LANGUAGES_TABLE +
                " WHERE " + LANGUAGES_COLUMN_TITLE + " LIKE " + searchQuery + " AND " +
                LANGUAGES_COLUMN_STATUS + " LIKE " + statusQuery + ";";

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(queryString, null);
        if(cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String title = cursor.getString(1);
                String type = cursor.getString(2);
                String description = cursor.getString(3);
                String status = cursor.getString(4);

                languages.add(new Languages(id, title, type, description, status));
            } while(cursor.moveToNext());
        }
        else {
            // Do nothing.
        }

        cursor.close();
        db.close();

        return languages;
    }
}
