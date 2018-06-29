package net.javango.criminalintent;

import android.app.Application;

import net.javango.criminalintent.model.AppDatabase;
import net.javango.criminalintent.model.CrimeDao;

public class CriminalIntent extends Application {

    private static AppDatabase db;

    @Override
    public void onCreate() {
        super.onCreate();
        db = AppDatabase.create(getApplicationContext());
    }

    public static CrimeDao crimeDao() {
        return db.crimeDao();
    }
}
