package com.flicks.hinaikhan.flicks.data.trailers;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by hinaikhan on 9/15/17.
 */

public class TrailersResponse implements Serializable {

    private int id;

    @SerializedName("results")
    private TrailersResultsResponse[] trailersResultsResponse;

    public TrailersResponse(int id, TrailersResultsResponse[] trailersResultsResponse) {
        this.id = id;
        this.trailersResultsResponse = trailersResultsResponse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TrailersResultsResponse[] getTrailersResultsResponse() {
        return trailersResultsResponse;
    }

    public void setTrailersResultsResponse(TrailersResultsResponse[] trailersResultsResponse) {
        this.trailersResultsResponse = trailersResultsResponse;
    }

    @Override
    public String toString() {
        return "TrailersResponse{" +
                "id=" + id +
                ", trailersResultsResponse=" + Arrays.toString(trailersResultsResponse) +
                '}';
    }
}
