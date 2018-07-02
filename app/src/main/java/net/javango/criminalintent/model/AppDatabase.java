package net.javango.criminalintent.model;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import net.javango.criminalintent.Crime;

@Database(entities = {Crime.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {

    private static final String NAME = "CRIME_DB";

    public abstract CrimeDao crimeDao();

    public static AppDatabase create(Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, NAME)
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
    }

}
