package com.flicks.hinaikhan.flicks.ui.mvp.playingmovie;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.flicks.hinaikhan.flicks.R;
import com.flicks.hinaikhan.flicks.data.model.response.MovieResponse;
import com.flicks.hinaikhan.flicks.data.model.response.MovieResultResponse;
import com.flicks.hinaikhan.flicks.ui.adapters.CustomMovieAdapter;

import android.support.v4.app.Fragment;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static android.content.ContentValues.TAG;


/**
 * Created by hinaikhan on 9/15/17.
 */

public class PlayingMovieView extends Fragment {

    private View view;
    @BindView(R.id.card_view) CardView mCardView;
    @BindView(R.id.listview_movie_item_list) ListView mListView;
    CustomMovieAdapter mCustomMovieAdapter;
    private Unbinder unbinder;
    private Context mContext;

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_list_view, container, false);
        unbinder = ButterKnife.bind(this, view);

        return view;
    }

    @Override public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private List<MovieResultResponse> postMovieResult(MovieResponse mMovieResponse){
            List<MovieResultResponse> movieResult = new ArrayList<>();
            MovieResultResponse[] results = mMovieResponse.getMovieResponses();

            for(MovieResultResponse res : results){
                movieResult.add(res);
            }

            return movieResult;
    }

    private void showMovieResults(MovieResponse mMovieRes) {

        if (mCustomMovieAdapter == null) {
            mCustomMovieAdapter = new CustomMovieAdapter(postMovieResult(mMovieRes), mContext);
        }

        mCustomMovieAdapter.clear();
        mCustomMovieAdapter.addAll(postMovieResult(mMovieRes));

        if (mListView.getAdapter() == null) {
            Log.d(TAG, "set movie adapter");
            mListView.setAdapter(mCustomMovieAdapter);

        }
    }














}