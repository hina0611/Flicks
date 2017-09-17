package com.flicks.hinaikhan.flicks.ui.mvp.playingmovie.youtube;

import android.os.Bundle;
import android.util.Log;

import com.flicks.hinaikhan.flicks.R;
import com.flicks.hinaikhan.flicks.data.trailers.TrailersResponse;
import com.flicks.hinaikhan.flicks.data.trailers.TrailersResultsResponse;
import com.flicks.hinaikhan.flicks.util.Constant;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hinaikhan on 9/17/17.
 */

public class YoutubePlayActivity extends YouTubeBaseActivity {

    private final String TAG = YoutubePlayActivity.class.getSimpleName();

    @BindView(R.id.youtube_player)
    YouTubePlayerView youTubePlayer;

    private TrailersResultsResponse[] mTrailersResultsResponses;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.youtube_player_activity);
        Log.d(TAG, "in Youtube player");
        ButterKnife.bind(this);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Object obj = extras.get("TRAILERS_RESPONSE");
            if (obj != null && obj instanceof TrailersResponse) {
                TrailersResponse trailersResponse = (TrailersResponse)obj;
                mTrailersResultsResponses = trailersResponse.getTrailersResultsResponse();
            }
        }

        initYouTubeMedia();


    }

    private void initYouTubeMedia(){

        youTubePlayer.initialize(getResources().getString(R.string.youtube_api_key),
                new YouTubePlayer.OnInitializedListener() {
                    @Override
                    public void onInitializationSuccess(YouTubePlayer.Provider provider,
                                                        YouTubePlayer youTubePlayer, boolean b) {

                        // do any work here to cue video, play video, etc.
                        //String[] sources = getIntent().getExtras().getStringArray(Constant.VIDEO_SOURCE);
                        //Log.d(TAG, sources.toString());
                        //youTubePlayer.cueVideos(Arrays.asList(sources));
                        //youTubePlayer.cueVideo("5xVh-7ywKpE");
                        youTubePlayer.loadVideo(mTrailersResultsResponses[0].getKey());
                    }
                    @Override
                    public void onInitializationFailure(YouTubePlayer.Provider provider,
                                                        YouTubeInitializationResult youTubeInitializationResult) {

                    }
                });
    }

}




