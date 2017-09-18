package com.flicks.hinaikhan.flicks.ui.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.widget.CardView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.flicks.hinaikhan.flicks.R;
import com.flicks.hinaikhan.flicks.data.model.response.MovieResultResponse;
import com.flicks.hinaikhan.flicks.ui.mvp.playingmovie.DisplayMovieContent;
import com.flicks.hinaikhan.flicks.util.AppUtil;
import com.flicks.hinaikhan.flicks.util.Constant;
import com.squareup.picasso.Picasso;
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;
import java.util.Date;


/**
 * Created by hinaikhan on 9/15/17.
 */

public class CustomMovieAdapter extends ArrayAdapter<MovieResultResponse> {

    private final String TAG = CustomMovieAdapter.class.getSimpleName();

    private Context mContext;


    public CustomMovieAdapter(MovieResultResponse[] mResultResponse, Context mContext) {
        super(mContext, android.R.layout.simple_list_item_1, mResultResponse);
        this.mContext = mContext;

    }

    @Override
    public int getItemViewType(int position) {
       return AppUtil.getMovieItemType((MovieResultResponse) getItem(position));

    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public int getViewTypeCount() {
        return Constant.MOVIE_COUNT;
    }

    private static class ViewHolder {
        private ImageView mIvMovieImage;
        private TextView mTvMovieTitle;
        private TextView mTvMovieVoteAverage;
        private ImageView mIvMovieStar;
        private ImageView mIvMovieReleaseDate;
        private TextView mTvReleaseDate;
        private TextView mTvMovieOverviewDescription;
        private CardView mCardViewContainer;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        final MovieResultResponse movieResultResponse = getItem(position);

        ViewHolder viewHolder; // view lookup cache stored in tag
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.movie_content_items, parent, false);

            viewHolder.mIvMovieImage = (ImageView) convertView.findViewById(R.id.img_list_items);
            viewHolder.mTvMovieTitle = (TextView) convertView.findViewById(R.id.tv_movie_title);
            viewHolder.mTvMovieVoteAverage = (TextView) convertView.findViewById(R.id.tv_movie_vote_average);
            viewHolder.mIvMovieStar = (ImageView) convertView.findViewById(R.id.img_vote_average);
            viewHolder.mIvMovieReleaseDate = (ImageView) convertView.findViewById(R.id.img_release_date);
            viewHolder.mTvReleaseDate = (TextView) convertView.findViewById(R.id.tv_release_date);
            viewHolder.mTvMovieOverviewDescription = (TextView) convertView.findViewById(R.id.tv_movie_overview_description);
            viewHolder.mCardViewContainer = (CardView) convertView.findViewById(R.id.card_view_movie_container);

            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        if(getItemViewType(position) == Constant.TYPE_NORMAL) {
            viewHolder.mTvMovieTitle.setText(movieResultResponse.getTitle());
            viewHolder.mTvReleaseDate.setText(movieResultResponse.getReleaseDate());
            viewHolder.mTvMovieOverviewDescription.setText(movieResultResponse.getOverview());
            viewHolder.mTvMovieVoteAverage.setText(movieResultResponse.getVoteAverage() + " ");

        }

        viewHolder.mCardViewContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, DisplayMovieContent.class);
                intent.putExtra("MOVIE_RESPONSE", movieResultResponse);
                mContext.startActivity(intent);

            }
        });


        if(mContext.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            String imgUrl = AppUtil.getMovieImgUrl(mContext, getItemViewType(position), movieResultResponse);
            Picasso.with(mContext).load(imgUrl).
                    transform(new RoundedCornersTransformation(10, 10)).
                    placeholder(R.drawable.placeholder).
                    resize(800, 800).
                    centerCrop().
                    into(viewHolder.mIvMovieImage);
        }  else {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((Activity)mContext).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            int width = displayMetrics.widthPixels;

            String imgUrl = AppUtil.getMovieImgUrl(mContext, getItemViewType(position), movieResultResponse);
            Picasso.with(mContext).load(imgUrl).
                    transform(new RoundedCornersTransformation(10, 10)).
                    placeholder(R.drawable.placeholder).
                    resize(width, 800).
                    centerCrop().
                    into(viewHolder.mIvMovieImage);
        }

        return convertView;
    }

}
