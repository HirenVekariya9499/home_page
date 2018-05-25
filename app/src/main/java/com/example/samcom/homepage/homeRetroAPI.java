package com.example.samcom.homepage;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface homeRetroAPI {

    String BASE_URL = "https://billcool.000webhostapp.com/samcom/";


    @GET("recommendation_api.php?recommendation=recommendation")
    Call<List<homeRetro>> getRecommendation();

    @GET("stores_api.php?stores=stores")
    Call<List<homeRetro1>> getRecommendation1();

    @GET("stores_api.php?stores=stores")
    Call<List<favouriteRetro>> getRecommendation2();

    @GET("recommendation_api.php?recommendation=recommendation")
    Call<List<favouriteRetro1>> getRecommendation3();

}
