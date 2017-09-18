package com.flicks.hinaikhan.flicks.ui.mvp.playingmovie;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.flicks.hinaikhan.flicks.R;
import com.flicks.hinaikhan.flicks.util.AppUtil;
import com.flicks.hinaikhan.flicks.util.Constant;
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
        checkPermission();

        Bundle bundle = getIntent().getExtras();
        if(bundle == null){
            bundle = new Bundle();
        }

        AppUtil.displayFragment(new PlayingMovieView(),getSupportFragmentManager(),bundle);
    }

    private void checkPermission() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED
                    || checkSelfPermission(Manifest.permission.ACCESS_NETWORK_STATE) != PackageManager.PERMISSION_GRANTED) {
                String[] perms = {Manifest.permission.INTERNET, Manifest.permission.ACCESS_NETWORK_STATE};
                requestPermissions(perms, Constant.REQUEST_PERMISSIONS);
            }
        }
    }

}
