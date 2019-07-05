package com.prototype.swgoh;

import android.os.AsyncTask;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppRetrofitService extends AsyncTask<Void, Void, List<Character>> {

    final String TAG = "swgoh.gg";
    final String BASE_URL = "https://swgoh.gg/";
    List<Character> characters;
    Retrofit mRetrofit;
    GameDataAPIService mAPIService;

    public AppRetrofitService() {
        initialize();
    }

    @Override
    protected List<Character> doInBackground(Void... voids) {
        return getAllCharactersSync();
    }

    private void initialize() {
        initializeRetrofitObject();
        initializeGameDataAPIService();
    }

    private void initializeRetrofitObject() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private void initializeGameDataAPIService() {
        mAPIService = mRetrofit.create(GameDataAPIService.class);
    }

    private List<Character> getAllCharactersAsync() {
        Call<List<Character>> call = mAPIService.getAllCharacters();
        call.enqueue(new Callback<List<Character>>() {
            @Override
            public void onResponse(Call<List<Character>> call, Response<List<Character>> response) {
                Log.d(TAG, "Response Successful");
                characters = response.body();
            }

            @Override
            public void onFailure(Call<List<Character>> call, Throwable t) {
                Log.d(TAG, "Response Failed");
                characters = null;
            }
        });

        return characters;
    }

    private List<Character> getAllCharactersSync() {
        Call<List<Character>> call = mAPIService.getAllCharacters();
        List<Character> characters;

        try {
            characters = call.execute().body();
        } catch (Exception e) {
            e.printStackTrace();
            characters = null;
        }

        return characters;
    }

}
