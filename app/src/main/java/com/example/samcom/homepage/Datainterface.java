package com.example.samcom.homepage;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.POST;

public interface Datainterface {

    @POST("login_api.php?login=login")
    Call<List<Contact>>getContacts();





}
