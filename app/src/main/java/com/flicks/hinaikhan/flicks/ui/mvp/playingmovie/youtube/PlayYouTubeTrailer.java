//package com.flicks.hinaikhan.flicks.ui.mvp.playingmovie.youtube;
//
//import android.app.Dialog;
//import android.graphics.Movie;
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v4.app.DialogFragment;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.view.Window;
//import android.widget.ImageView;
//
//import com.flicks.hinaikhan.flicks.R;
//import com.flicks.hinaikhan.flicks.data.model.response.MovieResponse;
//import com.flicks.hinaikhan.flicks.data.model.response.MovieResultResponse;
//import com.flicks.hinaikhan.flicks.data.trailers.TrailersResponse;
//import com.flicks.hinaikhan.flicks.data.trailers.TrailersResultsResponse;
//import com.flicks.hinaikhan.flicks.util.Constant;
//import com.google.android.youtube.player.YouTubeInitializationResult;
//import com.google.android.youtube.player.YouTubePlayer;
//import com.google.android.youtube.player.YouTubePlayerFragment;
//import com.google.android.youtube.player.YouTubePlayerSupportFragment;
//
//import java.util.Arrays;
//
//import butterknife.BindView;
//import butterknife.ButterKnife;
//import butterknife.OnClick;
//
//import static android.R.attr.data;
//import static android.R.attr.fragment;
//
///**
// * Created by hinaikhan on 9/17/17.
// */
//
//public class PlayYouTubeTrailer  {
//
//    public PlayYouTubeTrailer() {
//    }
//
//    @BindView(R.id.details_close)
//    ImageView closeBtn;
//    private MovieResultResponse mResponse;
//
//    private YouTubePlayerSupportFragment fragment;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//
//        YouTubePlayerFragment youtubeFragment = (YouTubePlayerFragment)
//                getFragmentManager().findFragmentById(R.id.youtubeFragment);
//        youtubeFragment.initialize("YOUR API KEY",
//                new YouTubePlayer.OnInitializedListener() {
//                    @Override
//                    public void onInitializationSuccess(YouTubePlayer.Provider provider,
//                                                        YouTubePlayer youTubePlayer, boolean b) {
//                        // do any work here to cue video, play video, etc.
//                        youTubePlayer.cueVideo("5xVh-7ywKpE");
//                    }
//                    @Override
//                    public void onInitializationFailure(YouTubePlayer.Provider provider,
//                                                        YouTubeInitializationResult youTubeInitializationResult) {
//
//                    }
//                });
//
//        // ...
//    }
//}
