package com.rais.haidar.themeal.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class configNetwork {

    static final String WebUrl = "https://www.themealdb.com/api/json/v1/1/";

    public static Retrofit setInit(){
        return new Retrofit.Builder()
                .baseUrl(WebUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ApiService getInstance(){
        return setInit().create(ApiService.class);
    }

}
