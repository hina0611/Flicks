package com.flicks.hinaikhan.flicks.ui.mvp.playingmovie;

import com.flicks.hinaikhan.flicks.data.handler.MoviesHandler;
import com.flicks.hinaikhan.flicks.data.model.response.MovieResponse;

/**
 * Created by hinaikhan on 9/15/17.
 */

public class PlayingMoviePresenter {

    private PlayingMovieView mView;

    public PlayingMoviePresenter(PlayingMovieView view) {
        mView = view;
    }

    public PlayingMovieView getmView() {
        return mView;
    }

    public void fetchMovies() {
        MoviesHandler handler = new MoviesHandler();
        handler.fetchMovieData(this);
    }

    public void postResults(MovieResponse response) {
        if(response != null){

            mView.updateMovieData(response);

        }
    }
}
