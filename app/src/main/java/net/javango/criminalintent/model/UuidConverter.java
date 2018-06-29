package net.javango.criminalintent.model;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;
import java.util.UUID;

public class UuidConverter {

    @TypeConverter
    public static UUID fromString(String value) {
        return UUID.fromString(value);
    }

    @TypeConverter
    public static String toString(UUID value) {
        return value.toString();
    }
}