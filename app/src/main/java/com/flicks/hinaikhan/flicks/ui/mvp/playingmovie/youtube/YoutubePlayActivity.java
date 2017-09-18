package com.flicks.hinaikhan.flicks.ui.mvp.playingmovie.youtube;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.flicks.hinaikhan.flicks.R;
import com.flicks.hinaikhan.flicks.data.trailers.TrailersResponse;
import com.flicks.hinaikhan.flicks.data.trailers.TrailersResultsResponse;
import com.flicks.hinaikhan.flicks.util.Constant;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.provider.MediaStore.Video.Thumbnails.VIDEO_ID;

/**
 * Created by hinaikhan on 9/17/17.
 */

public class YoutubePlayActivity extends YouTubeBaseActivity{

    private final String TAG = YoutubePlayActivity.class.getSimpleName();


    private YouTubePlayerView youTubePlayer;
    private ImageView imgClosePlayer;
    private TrailersResultsResponse[] mTrailersResultsResponses;

    @Override
    protected void onCreate(Bundle bundle) {

//        YouTubePlayerFragment youtubeFragment = (YouTubePlayerFragment)
//                getFragmentManager().findFragmentById(R.id.detail_player);




        super.onCreate(bundle);
        setContentView(R.layout.youtube_player_activity);

        youTubePlayer = (YouTubePlayerView) findViewById(R.id.youtube_player);
        imgClosePlayer = (ImageView) findViewById(R.id.img_close_player);
        imgClosePlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

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




