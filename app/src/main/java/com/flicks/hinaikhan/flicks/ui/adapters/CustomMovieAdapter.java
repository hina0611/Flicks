package com.flicks.hinaikhan.flicks.ui.adapters;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Icon;
import android.provider.SyncStateContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.flicks.hinaikhan.flicks.R;
import com.flicks.hinaikhan.flicks.data.model.response.MovieResponse;
import com.flicks.hinaikhan.flicks.data.model.response.MovieResultResponse;
import com.flicks.hinaikhan.flicks.util.Constant;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

import static android.R.attr.data;
import static android.R.attr.moreIcon;
import static android.R.attr.offset;
import static android.R.attr.orientation;
import static android.R.attr.theme;
import static com.flicks.hinaikhan.flicks.R.id.tv_release_date;
import static com.flicks.hinaikhan.flicks.util.Constant.TYPE_NORMAL;

/**
 * Created by hinaikhan on 9/15/17.
 */

public class CustomMovieAdapter extends ArrayAdapter<MovieResultResponse> {

    private final String TAG = CustomMovieAdapter.class.getSimpleName();

    private Context mContext;
    private MovieResultResponse mResultResponse;

    @BindView(R.id.img_list_items) ImageView mIvMovieImage;
    @BindView(R.id.tv_movie_title) TextView mTvMovieTitle;
    @BindView(R.id.tv_movie_vote_average) TextView mTvMovieVoteAverage;
    @BindView(R.id.img_vote_average) ImageView mIvMovieStar;
    @BindView(R.id.img_release_date) ImageView mIvMovieReleaseDate;
    @BindView(tv_release_date) TextView mTvReleaseDate;
    @BindView(R.id.tv_movie_overview_description) TextView mTvMovieOverviewDescription;



    public CustomMovieAdapter(List<MovieResultResponse> mResultResponse, Context mContext) {
        super(mContext, android.R.layout.simple_list_item_1, mResultResponse);
        this.mContext = mContext;

    }


    @Override
    public int getItemViewType(int position) {

//        MovieResponse mMovieResponses = new MovieResponse();
//        mMovieResponses.getMovieResponses();

        MovieResultResponse mResultResponse = (MovieResultResponse) getItem(position);
        return mResultResponse.getId() > 5.0 ? TYPE_NORMAL : TYPE_NORMAL;

    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public int getViewTypeCount() {
        return Constant.MOVIE_COUNT;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        mResultResponse = (MovieResultResponse) getItem(position);
        if(convertView == null){
            convertView = getMovieType(getItemViewType(position));
        }
        if(getItemViewType(position) == TYPE_NORMAL){
            mTvReleaseDate.setText(mResultResponse.getTitle());
            mTvReleaseDate.setText((CharSequence) mResultResponse.getReleaseDate());
            mTvMovieOverviewDescription.setText(mResultResponse.getOverview());
            mIvMovieImage.setImageIcon(Icon.createWithContentUri(mResultResponse.getPosterPath()));
        }

        String imgUrl = "";
        if(getItemViewType(position) == Constant.TYPE_NORMAL) {
            int imgOrientation = mContext.getResources().getConfiguration().orientation;
            if (imgOrientation == Configuration.ORIENTATION_PORTRAIT) {
                imgUrl = String.format("https://image.tmdb.org/t/p/w342%s", mResultResponse.getPosterPath());
            } else {
                imgUrl = String.format("https://image.tmdb.org/t/p/w500%s", mResultResponse.getBackDropPath());
            }
        }
        else {
            imgUrl = String.format("https://image.tmdb.org/t/p/w500%s", mResultResponse.getBackDropPath());
        }

//        Picasso.with(mContext).load(R.drawable.demo)
//                .transform(new RoundedCornersTransformation(10, 10)).into((ImageView) findViewById(R.id.image));

        return convertView;

    }

    private View getMovieType(int viewMovie){
        if(viewMovie == TYPE_NORMAL){
            return LayoutInflater.from(mContext).inflate(R.layout.fragment_list_view, null);
        }
        if(viewMovie == TYPE_NORMAL){
            return LayoutInflater.from(mContext).inflate(R.layout.movie_content_items, null);
        }

        return null;
    }



}
