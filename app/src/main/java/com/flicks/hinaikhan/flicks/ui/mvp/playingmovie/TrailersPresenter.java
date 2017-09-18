package com.flicks.hinaikhan.flicks.ui.mvp.playingmovie;


import com.flicks.hinaikhan.flicks.data.handler.TrailersHandler;
import com.flicks.hinaikhan.flicks.data.model.response.MovieResultResponse;
import com.flicks.hinaikhan.flicks.data.trailers.TrailersResponse;

/**
 * Created by hinaikhan on 9/17/17.
 */

public class TrailersPresenter {

    private DisplayMovieContent mActivity;

    public TrailersPresenter(DisplayMovieContent activity) {
        mActivity = activity;
    }

    public DisplayMovieContent getmActivity() {
        return mActivity;
    }

    public void fetchTrailers(MovieResultResponse movieResultResponse) {
        TrailersHandler handler = new TrailersHandler();
        handler.fetchTrailersData(this, movieResultResponse);
    }

    public void postResults(TrailersResponse trailersResponse) {
        mActivity.postResults(trailersResponse);
    }


}
