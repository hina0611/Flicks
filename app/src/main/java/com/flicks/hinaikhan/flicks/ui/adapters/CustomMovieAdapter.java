package com.flicks.hinaikhan.flicks.ui.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Icon;
import android.provider.SyncStateContract;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.flicks.hinaikhan.flicks.R;
import com.flicks.hinaikhan.flicks.data.model.response.MovieResultResponse;
import com.flicks.hinaikhan.flicks.ui.mvp.playingmovie.DisplayMovieContent;
import com.flicks.hinaikhan.flicks.util.AppUtil;
import com.flicks.hinaikhan.flicks.util.Constant;
import com.squareup.picasso.Picasso;

import java.sql.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

import static android.R.attr.data;
import static android.R.attr.moreIcon;
import static android.R.attr.offset;
import static android.R.attr.orientation;
import static android.R.attr.start;
import static android.R.attr.theme;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;
import static com.flicks.hinaikhan.flicks.R.id.tv_movie_title;
import static com.flicks.hinaikhan.flicks.R.id.tv_release_date;
import static com.flicks.hinaikhan.flicks.util.Constant.TYPE_NORMAL;
import static com.flicks.hinaikhan.flicks.util.Constant.TYPE_POPULAR;

/**
 * Created by hinaikhan on 9/15/17.
 */

public class CustomMovieAdapter extends ArrayAdapter<MovieResultResponse> {

    private final String TAG = CustomMovieAdapter.class.getSimpleName();

    private Context mContext;
    private ImageView mIvMovieImage;
    private TextView mTvMovieTitle;
    private TextView mTvMovieVoteAverage;
    private ImageView mIvMovieStar;
    private ImageView mIvMovieReleaseDate;
    private TextView mTvReleaseDate;
    private TextView mTvMovieOverviewDescription;
    private RelativeLayout mRelativeMovieContainer;

//    static class ViewHolder {
//        @BindView(R.id.img_list_items)
//        ImageView mIvMovieImage;
//        @BindView(R.id.tv_movie_title)
//        TextView mTvMovieTitle;
//        @BindView(R.id.tv_movie_vote_average)
//        TextView mTvMovieVoteAverage;
//        @BindView(R.id.img_vote_average)
//        ImageView mIvMovieStar;
//        @BindView(R.id.img_release_date)
//        ImageView mIvMovieReleaseDate;
//        @BindView(tv_release_date)
//        TextView mTvReleaseDate;
//        @BindView(R.id.tv_movie_overview_description)
//        TextView mTvMovieOverviewDescription;
//
//        public ViewHolder(View view) {
//            ButterKnife.bind(this, view);
//        }
//    }


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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final MovieResultResponse movieResultResponse = getItem(position);
        View view = LayoutInflater.from(mContext).inflate(R.layout.movie_content_items, parent, false);

         mIvMovieImage = (ImageView) view.findViewById(R.id.img_list_items);
         mTvMovieTitle = (TextView) view.findViewById(R.id.tv_movie_title);
         mTvMovieVoteAverage = (TextView) view.findViewById(R.id.tv_movie_vote_average);
         mIvMovieStar = (ImageView) view.findViewById(R.id.img_vote_average);
         mIvMovieReleaseDate = (ImageView) view.findViewById(R.id.img_release_date);
         mTvReleaseDate = (TextView) view.findViewById(R.id.tv_release_date);
         mTvMovieOverviewDescription = (TextView) view.findViewById(R.id.tv_movie_overview_description);
         mRelativeMovieContainer = (RelativeLayout) view.findViewById(R.id.realtive_container_layout);
            mRelativeMovieContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, DisplayMovieContent.class);
                intent.putExtra("MOVIE_RESPONSE", movieResultResponse);
                mContext.startActivity(intent);

            }
        });

        if(getItemViewType(position) == Constant.TYPE_NORMAL) {
            mTvMovieTitle.setText(movieResultResponse.getTitle());
            mTvReleaseDate.setText(AppUtil.formatDate(movieResultResponse.getReleaseDate()));
            mTvMovieOverviewDescription.setText(movieResultResponse.getOverview());
            mTvMovieVoteAverage.setText(movieResultResponse.getVoteAverage() + " ");

        }

        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity)mContext).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int width = displayMetrics.widthPixels;


        String imgUrl = AppUtil.getMovieImgUrl(mContext, getItemViewType(position), movieResultResponse);
        Picasso.with(mContext).load(imgUrl).
                transform(new RoundedCornersTransformation(10, 10)).
                placeholder(R.drawable.placeholder).
                resize(width, 800).
                centerCrop().
                into(mIvMovieImage);


        return view;

    }
}
