package net.javango.criminalintent;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import net.javango.criminalintent.model.DateConverter;
import net.javango.criminalintent.model.UuidConverter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Entity
@TypeConverters({DateConverter.class, UuidConverter.class})
public class Crime {

    @PrimaryKey
    @NonNull
    private UUID id;
    private String title;
    private Date date;
    private boolean solved;
    private String mSuspect;

    public Crime() {
        id = UUID.randomUUID();
        date = new Date();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isSolved() {
        return solved;
    }

    public void setSolved(boolean solved) {
        this.solved = solved;
    }

    public String getSuspect() {
        return mSuspect;
    }

    public void setSuspect(String suspect) {
        mSuspect = suspect;
    }


    public String getFormattedDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, MMM d, yyyy");
        return dateFormat.format(date);
    }
}
