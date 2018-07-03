package net.javango.criminalintent;

import android.app.Application;
import android.content.Context;

import net.javango.criminalintent.model.AppDatabase;
import net.javango.criminalintent.model.CrimeDao;

public class CriminalIntent extends Application {

    private static AppDatabase db;
    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = getApplicationContext();
        db = AppDatabase.create(sContext);
    }

    public static CrimeDao crimeDao() {
        return db.crimeDao();
    }

    public static Context getContext() {
        return sContext;
    }
}
