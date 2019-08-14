package com.nafidinara.threesubmission.connection;
import com.nafidinara.threesubmission.model.Movie;
import com.nafidinara.threesubmission.model.TvShow;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET ("movie")
    Call<Movie> getMovie(@Query("api_key")String apiKey);

    @GET ("tv")
    Call<TvShow> getShow(@Query("api_key")String apiKey);
}
