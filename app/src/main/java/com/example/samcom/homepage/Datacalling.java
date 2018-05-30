package com.example.samcom.homepage;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Datacalling {

    public static final String BASE_URL = "https://billcool.000webhostapp.com/samcom/";

    public static Retrofit retrofit = null;

    public static Retrofit getDatacalling(){

        if (retrofit==null){

            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).
                        addConverterFactory(GsonConverterFactory.create()).build();
        }

        return retrofit;

    }




}
