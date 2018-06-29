package net.javango.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class CrimeLab {

    private static CrimeLab sCrimeLab;
    private Map<UUID, Crime> crimes = new LinkedHashMap<>();

    public static CrimeLab get(Context context) {
        if (sCrimeLab == null) {
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }

    private CrimeLab(Context context) {
        List<Crime> list = CriminalIntent.crimeDao().fetchAll();
        for (Crime crime : list)
            crimes.put(crime.getId(), crime);
    }

    public List<Crime> getCrimes() {
        return new ArrayList(crimes.values());
    }

    public void addCrime(Crime crime) {
        CriminalIntent.crimeDao().addCrime(crime);
        crimes.put(crime.getId(), crime);
    }

    public Crime getCrime(UUID id) {
        return crimes.get(id);
    }

    public void updateCrime(Crime crime) {
        CriminalIntent.crimeDao().updateCrime(crime);
    }

    public void deleteCrime(Crime crime) {
        CriminalIntent.crimeDao().deleteCrime(crime);
        crimes.remove(crime.getId());
    }

}
