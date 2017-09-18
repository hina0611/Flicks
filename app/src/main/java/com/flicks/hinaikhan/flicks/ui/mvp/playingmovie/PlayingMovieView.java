package com.flicks.hinaikhan.flicks.ui.mvp.playingmovie;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.flicks.hinaikhan.flicks.R;
import com.flicks.hinaikhan.flicks.data.model.response.MovieResponse;
import com.flicks.hinaikhan.flicks.ui.adapters.CustomMovieAdapter;

import android.support.v4.app.Fragment;
import android.widget.ListView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static android.content.ContentValues.TAG;


/**
 * Created by hinaikhan on 9/15/17.
 */

public class PlayingMovieView extends Fragment {

    private View view;
    @BindView(R.id.listview_movie_item_list) ListView mListView;
    CustomMovieAdapter mCustomMovieAdapter;
    private Unbinder unbinder;
    private MovieResponse mMovieRes;

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_list_view, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        fetchMovies();
    }

    @Override public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private void fetchMovies(){
        PlayingMoviePresenter presenter = new PlayingMoviePresenter(this);
        presenter.fetchMovies();

    }



    public void updateMovieData(MovieResponse response) {
        if (mCustomMovieAdapter == null) {
            mCustomMovieAdapter = new CustomMovieAdapter(response.getMovieResponses(), getActivity());
        } else {
            mCustomMovieAdapter.addAll(response.getMovieResponses());
        }

        if (mListView.getAdapter() == null) {
            Log.d(TAG, "set movie adapter");
            mListView.setAdapter(mCustomMovieAdapter);

        }
    }

}

















