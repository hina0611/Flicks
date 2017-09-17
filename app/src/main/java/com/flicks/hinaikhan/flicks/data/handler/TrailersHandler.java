package com.flicks.hinaikhan.flicks.data.handler;

import android.graphics.Movie;
import android.util.Log;

import com.flicks.hinaikhan.flicks.R;
import com.flicks.hinaikhan.flicks.data.model.response.MovieResponse;
import com.flicks.hinaikhan.flicks.data.model.response.MovieResultResponse;
import com.flicks.hinaikhan.flicks.data.trailers.TrailersResponse;
import com.flicks.hinaikhan.flicks.ui.mvp.playingmovie.PlayingMoviePresenter;
import com.flicks.hinaikhan.flicks.ui.mvp.playingmovie.TrailersPresenter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static android.content.ContentValues.TAG;

/**
 * Created by hinaikhan on 9/17/17.
 */

public class TrailersHandler {

    public void fetchTrailersData(final TrailersPresenter presenter, MovieResultResponse movieResultResponse){

        OkHttpClient client = new OkHttpClient();


        String baseUrl = presenter.getmActivity().getResources().getString(R.string.retrieveTrailersImg) +
                        movieResultResponse.getId() + "/videos";

        HttpUrl.Builder urlBuilder = HttpUrl.parse(baseUrl).newBuilder();
        urlBuilder.addQueryParameter("api_key", presenter.getmActivity().getResources().getString(R.string.apiKey));

        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();


        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                if (!response.isSuccessful()) {
                    throw new IOException("Unexpected code " + response);
                } else {
                    // Read data on the worker thread
                    final String responseData = response.body().string();
                    Log.d("FetchTrailers", responseData);

                    presenter.getmActivity().runOnUiThread(
                            new Runnable() {
                                @Override
                                public void run() {
                                    Gson gson = new GsonBuilder().create();
                                    TrailersResponse trailersResponse = gson.fromJson(responseData, TrailersResponse.class);
                                    Log.d(TAG, "Movie responses " + trailersResponse.toString());

                                    presenter.postResults(trailersResponse);
                                }
                            }
                    );

                }
            }
        });
    }


}


