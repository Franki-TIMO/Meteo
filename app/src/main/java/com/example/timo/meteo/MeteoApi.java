package com.example.timo.meteo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MeteoApi {

    @GET("/PDybala10/WEsiea/posts")

    Call<List<Meteo>> getMeteoResponse();

}

