package com.flicks.hinaikhan.flicks.data.model.response;

import com.google.gson.annotations.SerializedName;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by hinaikhan on 9/15/17.
 */

public class MovieResponse{

    private final String TAG = MovieResponse.class.getSimpleName();

    @SerializedName("results")
    private MovieResultResponse[] movieResponses;

    private int page;

    @SerializedName("total_results")
    private int totalResults;

    private DateResponse dateResponse;

    @SerializedName("total_pages")
    private int totalPages;

    public MovieResponse(){

    }

    public MovieResponse(MovieResultResponse[] movieResponses, int page, int totalResults, DateResponse dateResponse, int totalPages) {
        this.movieResponses = movieResponses;
        this.page = page;
        this.totalResults = totalResults;
        this.dateResponse = dateResponse;
        this.totalPages = totalPages;
    }

    public MovieResultResponse[] getMovieResponses() {
        return movieResponses;
    }

    public void setMovieResponses(MovieResultResponse[] movieResponses) {
        this.movieResponses = movieResponses;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public DateResponse getDateResponse() {
        return dateResponse;
    }

    public void setDateResponse(DateResponse dateResponse) {
        this.dateResponse = dateResponse;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    @Override
    public String toString() {
        return "MovieResponse{" +
                "movieResponses=" + Arrays.toString(movieResponses) +
                ", page=" + page +
                ", totalResults=" + totalResults +
                ", dateResponse=" + dateResponse +
                ", totalPages=" + totalPages +
                '}';
    }
}
