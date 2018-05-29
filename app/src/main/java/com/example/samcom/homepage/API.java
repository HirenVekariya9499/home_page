package com.example.samcom.homepage;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface API {

    String BASE_URL = "https://billcool.000webhostapp.com/samcom/";


    @GET("recommendation_api.php?recommendation=recommendation")
    Call<List<RetroHome>> getRecommendation();

    @GET("stores_api.php?stores=stores")
    Call<List<RetroHome1>> getRecommendation1();

    @GET("items_api.php?{id}")
    Call<List<RetroFavourite>> getRecommendation2(@Path("id") int id);

    @GET("recommendation_api.php?recommendation=recommendation")
    Call<List<RetroFavourite1>> getRecommendation3();

    @GET("login_api.php?login=login")
    Call<List<RetroUserProfile>> getRecommendation4();
}
