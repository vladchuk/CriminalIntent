package net.javango.criminalintent.model;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import net.javango.criminalintent.Crime;

import java.util.List;
import java.util.UUID;

@Dao
public interface CrimeDao {

    @Insert
    void addCrime(Crime crime);

    @Update
    void updateCrime(Crime crime);

    @Delete
    void deleteCrime(Crime crime);

    @Query("select * from crime where id = :id")
    Crime getCrime(String id);

    @Query("select * from crime order by id")
    List<Crime> fetchAll();

    @Query("select count(*) from crime")
    int getCount();

}
