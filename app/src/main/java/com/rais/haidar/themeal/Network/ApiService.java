package com.rais.haidar.themeal.Network;

import com.rais.haidar.themeal.Main.Model.ModelCategory.ResponseCategory;
import com.rais.haidar.themeal.Main.Model.ModelDetailRecipe.ResponseDetailRecipe;
import com.rais.haidar.themeal.Main.Model.ModelListCategory.ResponseListCategory;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("categories.php")
    Call<ResponseCategory> getCategory(

    );

    @GET("filter.php")
    Call<ResponseListCategory> getListCategory(
            @Query("c") String namaKategori
    );

    @GET("lookup.php")
    Call<ResponseDetailRecipe> getDetailRecipe(
            @Query("i") String id
    );

}
