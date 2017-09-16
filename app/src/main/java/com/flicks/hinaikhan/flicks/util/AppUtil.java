package com.flicks.hinaikhan.flicks.util;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;

import com.flicks.hinaikhan.flicks.R;

/**
 * Created by hinaikhan on 9/16/17.
 */

public class AppUtil  {

    public static void displayFragment(Fragment displayFragment, FragmentManager mFragmentManager, Bundle mBundle) {

        if (displayFragment == null || mFragmentManager == null || mBundle == null) {
            return;
        }
        displayFragment.setArguments(mBundle);
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.frame_content, displayFragment);

        fragmentTransaction.commit();


    }
}
