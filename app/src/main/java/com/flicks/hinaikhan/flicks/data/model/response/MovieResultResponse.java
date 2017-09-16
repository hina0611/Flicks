package com.flicks.hinaikhan.flicks.data.model.response;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by hinaikhan on 9/15/17.
 */

public class MovieResultResponse  {

    private final String TAG = MovieResponse.class.getSimpleName();

    private int voteCount;
    private int id;
    private boolean video;
    private float voteAverage;
    private String title;
    private double popularity;
    private String posterPath;
    private String originalLanguage;
    private String originalTitle;
    private MovieGenreID[] movieGenreIDs;
    private String backDropPath;
    private boolean adult;
    private String overview;
    private Date releaseDate;

    public MovieResultResponse(int voteCount, int id, boolean video, float voteAverage, String title, double popularity, String posterPath, String originalLanguage,
                               String originalTitle, MovieGenreID[] movieGenreIDs,
                               String backDropPath, boolean adult, String overview, Date releaseDate) {
        this.voteCount = voteCount;
        this.id = id;
        this.video = video;
        this.voteAverage = voteAverage;
        this.title = title;
        this.popularity = popularity;
        this.posterPath = posterPath;
        this.originalLanguage = originalLanguage;
        this.originalTitle = originalTitle;
        this.movieGenreIDs = movieGenreIDs;
        this.backDropPath = backDropPath;
        this.adult = adult;
        this.overview = overview;
        this.releaseDate = releaseDate;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public float getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(float voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public MovieGenreID[] getMovieGenreIDs() {
        return movieGenreIDs;
    }

    public void setMovieGenreIDs(MovieGenreID[] movieGenreIDs) {
        this.movieGenreIDs = movieGenreIDs;
    }

    public String getBackDropPath() {
        return backDropPath;
    }

    public void setBackDropPath(String backDropPath) {
        this.backDropPath = backDropPath;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "MovieResultResponse{" +
                "voteCount=" + voteCount +
                ", id=" + id +
                ", video=" + video +
                ", voteAverage=" + voteAverage +
                ", title='" + title + '\'' +
                ", popularity=" + popularity +
                ", posterPath='" + posterPath + '\'' +
                ", originalLanguage='" + originalLanguage + '\'' +
                ", originalTitle='" + originalTitle + '\'' +
                ", movieGenreIDs=" + Arrays.toString(movieGenreIDs) +
                ", backDropPath='" + backDropPath + '\'' +
                ", adult=" + adult +
                ", overview='" + overview + '\'' +
                ", releaseDate=" + releaseDate +
                '}';
    }
}
