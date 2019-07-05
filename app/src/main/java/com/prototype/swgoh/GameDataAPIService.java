package com.prototype.swgoh;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GameDataAPIService {

    @GET("api/characters/")
    Call<List<Character>> getAllCharacters();

}
