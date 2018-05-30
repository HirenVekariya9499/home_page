package com.example.samcom.homepage;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface homeRetroAPI {

    String BASE_URL = "https://billcool.000webhostapp.com/samcom/";


    @GET("login_api.php?login=login")
    Call<List<RetroHome>> getRecommendation();
}
