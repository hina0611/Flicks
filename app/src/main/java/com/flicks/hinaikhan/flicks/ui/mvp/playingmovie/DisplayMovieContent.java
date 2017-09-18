package com.flicks.hinaikhan.flicks.ui.mvp.playingmovie;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.flicks.hinaikhan.flicks.R;
import com.flicks.hinaikhan.flicks.data.handler.TrailersHandler;
import com.flicks.hinaikhan.flicks.data.model.response.MovieResponse;
import com.flicks.hinaikhan.flicks.data.model.response.MovieResultResponse;
import com.flicks.hinaikhan.flicks.data.trailers.TrailersResponse;
import com.flicks.hinaikhan.flicks.ui.adapters.CustomMovieAdapter;
import com.flicks.hinaikhan.flicks.ui.mvp.playingmovie.youtube.YoutubePlayActivity;
import com.flicks.hinaikhan.flicks.util.AppUtil;
import com.squareup.picasso.Picasso;

import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

import static android.R.attr.width;
import static android.R.id.message;
import static java.security.AccessController.getContext;
import static okhttp3.internal.Internal.instance;

/**
 * Created by hinaikhan on 9/16/17.
 */

public class DisplayMovieContent extends AppCompatActivity {

    private static final String TAG = DisplayMovieContent.class.getSimpleName();


    private ImageView imgTrailerItem;
    private TextView tvUserScore;
    private RatingBar mRtaingBar;
    private TextView mTvOverviewTitle;
    private TextView mTvMovieName;
    private TextView mTvOverviewDescription;
    private ImageView imgWishList;
    private ImageView imgFavourite;
    private ImageView imgPlayTrailer;
    private View view;
    private CustomMovieAdapter mTrailerAdapter;
    private MovieResultResponse movieResultResponse;
    private TrailersResponse mTrailersResponse;
    private Context mContext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_play_movie);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayShowTitleEnabled(false);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Object obj = extras.get("MOVIE_RESPONSE");
            if (obj != null && obj instanceof MovieResultResponse) {
                movieResultResponse = (MovieResultResponse) obj;
            }
        }

        Log.d(DisplayMovieContent.class.getSimpleName(), "MovieResultsResponse: " + movieResultResponse);
        bindView();
        fetchTrailers();
        renderView();
        renderData();
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; go home
                Intent intent = new Intent(this, PlayingMovieActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }




    private void bindView(){

        imgTrailerItem = (ImageView) findViewById(R.id.img_view_trailer_item);
        tvUserScore = (TextView) findViewById(R.id.tv_user_score);
        mRtaingBar = (RatingBar) findViewById(R.id.ratingBar);
        mTvOverviewDescription = (TextView) findViewById(R.id.tv_overview_description);
        mTvMovieName = (TextView) findViewById(R.id.tv_name);
        imgPlayTrailer = (ImageView) findViewById(R.id.img_play_trailer);
        imgPlayTrailer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playYoutubeVideo();

            }
        });


    }


    private void renderView() {
        if (movieResultResponse != null) {
            mTvMovieName.setText(movieResultResponse.getTitle());
            mTvOverviewDescription.setText(movieResultResponse.getOverview());

            DisplayMetrics displayMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            int width = displayMetrics.widthPixels;

            String imgUrl = AppUtil.getMovieImgUrl(this, AppUtil.getMovieItemType(movieResultResponse), movieResultResponse);
            Picasso.with(this).load(imgUrl).
                    transform(new RoundedCornersTransformation(10, 10)).
                    placeholder(R.drawable.placeholder).
                    resize(width, 800).
                    centerCrop().into(imgTrailerItem);
        }
    }





    private void fetchTrailers(){
        TrailersPresenter presenter = new TrailersPresenter(this);
        presenter.fetchTrailers(movieResultResponse);
    }


    public void postResults(TrailersResponse trailersResponse) {
        Log.d(TAG, "Trailers Response JSON: " + trailersResponse);
        mTrailersResponse = trailersResponse;
    }

    private void playYoutubeVideo() {
        Intent intent = new Intent(this, YoutubePlayActivity.class);
        intent.putExtra("TRAILERS_RESPONSE", mTrailersResponse);
        startActivity(intent);
    }

    private void renderData(){
        mRtaingBar.setRating(movieResultResponse.getVoteAverage());
    }

}
