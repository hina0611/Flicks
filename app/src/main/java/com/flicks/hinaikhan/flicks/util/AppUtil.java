package com.flicks.hinaikhan.flicks.util;

import android.content.Context;
import android.content.res.Configuration;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;

import com.flicks.hinaikhan.flicks.R;
import com.flicks.hinaikhan.flicks.data.model.response.MovieResultResponse;

import java.util.Date;
import java.text.FieldPosition;
import java.text.ParsePosition;

import static com.flicks.hinaikhan.flicks.util.Constant.TYPE_NORMAL;
import static com.flicks.hinaikhan.flicks.util.Constant.TYPE_POPULAR;

/**
 * Created by hinaikhan on 9/16/17.
 */

public class AppUtil {

    public static void displayFragment(Fragment displayFragment, FragmentManager mFragmentManager, Bundle mBundle) {

        if (displayFragment == null || mFragmentManager == null || mBundle == null) {
            return;
        }
        displayFragment.setArguments(mBundle);
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_content, displayFragment);

        fragmentTransaction.commit();


    }

    public static String formatDate(Date date) {

        if (date != null) {
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-DD");
                return simpleDateFormat.format(date);
            } catch (Exception ex) {

            }
        }

        return "";
    }

    public static int getMovieItemType(MovieResultResponse mResultResponse) {
        return mResultResponse.getId() > 5.0 ? TYPE_NORMAL : TYPE_POPULAR;
    }

    public static String getMovieImgUrl(Context context, int itemViewType, MovieResultResponse movieResultResponse) {
        String imgUrl = "";
        if (itemViewType == TYPE_NORMAL) {
            int imgOrientation = context.getResources().getConfiguration().orientation;
            if (imgOrientation == Configuration.ORIENTATION_PORTRAIT) {
                imgUrl = String.format("https://image.tmdb.org/t/p/w342%s", movieResultResponse.getPosterPath());
            } else {
                imgUrl = String.format("https://image.tmdb.org/t/p/w500%s", movieResultResponse.getBackDropPath());
            }
        } else {
            imgUrl = String.format("https://image.tmdb.org/t/p/w500%s", movieResultResponse.getBackDropPath());
        }

        return imgUrl;
    }

}
