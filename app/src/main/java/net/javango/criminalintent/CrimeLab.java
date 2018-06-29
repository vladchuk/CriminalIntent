package net.javango.criminalintent;

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class CrimeLab {

    private static CrimeLab sCrimeLab;

    public static CrimeLab get(Context context) {
        if (sCrimeLab == null) {
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }

    private CrimeLab(Context context) {
    }

    public List<Crime> getCrimes() {
        return CriminalIntent.crimeDao().fetchAll();
    }

    public Crime getCrime(UUID id) {
        String sid = id.toString();
        return CriminalIntent.crimeDao().getCrime(sid);
    }

    public void addCrime(Crime crime) {
        CriminalIntent.crimeDao().addCrime(crime);
    }

    public void updateCrime(Crime crime) {
        CriminalIntent.crimeDao().updateCrime(crime);
    }

}
