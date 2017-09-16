package com.flicks.hinaikhan.flicks.ui.mvp.playingmovie;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.flicks.hinaikhan.flicks.R;
import com.flicks.hinaikhan.flicks.util.AppUtil;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hinaikhan on 9/15/17.
 */

public class PlayingMovieActivity extends AppCompatActivity {

    private static final String TAG = PlayingMovieActivity.class.getSimpleName();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Bundle bundle = getIntent().getExtras();
        if(bundle == null){
            bundle = new Bundle();
        }

        AppUtil.displayFragment(new PlayingMovieView(),getSupportFragmentManager(),bundle);
    }

}
