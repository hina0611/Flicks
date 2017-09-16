package com.flicks.hinaikhan.flicks.data.model.response;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by hinaikhan on 9/15/17.
 */

public class MovieGenreID {


    private final String TAG = MovieGenreID.class.getSimpleName();

    private int genreID;

    public MovieGenreID(int genreID) {
        this.genreID = genreID;
    }

    public int getGenreID() {
        return genreID;
    }

    public void setGenreID(int genreID) {
        this.genreID = genreID;
    }

    @Override
    public String toString() {
        return "MovieGenreID{" +
                "genreID=" + genreID +
                '}';
    }
}
