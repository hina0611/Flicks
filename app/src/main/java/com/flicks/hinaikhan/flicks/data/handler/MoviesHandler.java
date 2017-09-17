package com.flicks.hinaikhan.flicks.data.handler;

import android.util.Log;
import android.widget.TextView;

import com.flicks.hinaikhan.flicks.R;
import com.flicks.hinaikhan.flicks.data.model.response.MovieResponse;
import com.flicks.hinaikhan.flicks.ui.mvp.playingmovie.PlayingMoviePresenter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Callback;
import okhttp3.Response;

import static android.content.ContentValues.TAG;


/**
 * Created by hinaikhan on 9/16/17.
 */

public class MoviesHandler  {

    public void fetchMovieData(final PlayingMoviePresenter presenter){

        OkHttpClient client = new OkHttpClient();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(presenter.getmView().getContext().getResources().getString(R.string.retriveMoviesInfo)).newBuilder();
        urlBuilder.addQueryParameter("api_key", presenter.getmView().getContext().getResources().getString(R.string.apiKey));

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
                    Log.d("FetchMovies", responseData);

                    presenter.getmView().getActivity().runOnUiThread(
                            new Runnable() {
                                @Override
                                public void run() {
                                    Gson gson = new GsonBuilder().create();
                                    MovieResponse movieResponse = gson.fromJson(responseData, MovieResponse.class);
                                    Log.d(TAG, "Movie responses " + movieResponse.toString());

                                    presenter.postResults(movieResponse);
                                }
                            }
                    );



                }
            }
        });
    }


}
