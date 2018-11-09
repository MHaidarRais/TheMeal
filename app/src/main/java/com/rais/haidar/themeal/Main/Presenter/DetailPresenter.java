package com.rais.haidar.themeal.Main.Presenter;

import com.rais.haidar.themeal.Base.BasePresenter;
import com.rais.haidar.themeal.Main.Model.ModelDetailRecipe.ResponseDetailRecipe;
import com.rais.haidar.themeal.Main.Model.ModelListCategory.MealsItem;
import com.rais.haidar.themeal.Main.Model.ModelListCategory.ResponseListCategory;
import com.rais.haidar.themeal.Main.View.MainView;
import com.rais.haidar.themeal.Network.configNetwork;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailPresenter implements BasePresenter<MainView> {

    public String idMakanan;
    public MainView mainView;

    public void getData(String id){
        idMakanan = id;
        call().enqueue(new Callback<ResponseDetailRecipe>() {
            @Override
            public void onResponse(Call<ResponseDetailRecipe> call, Response<ResponseDetailRecipe> response) {
                if (response.isSuccessful()){
                    List<com.rais.haidar.themeal.Main.Model.ModelDetailRecipe.MealsItem> mealsItemList = response.body().getMeals();
                    mainView.onDetailSuccess(mealsItemList);
                }else {
                    mainView.onError("GAGAL mengambil data");
                }
            }

            @Override
            public void onFailure(Call<ResponseDetailRecipe> call, Throwable t) {
                mainView.onError(t.getMessage());
            }
        });
    }

    public Call<ResponseDetailRecipe> call() {
        return configNetwork.getInstance().getDetailRecipe(idMakanan);
    }

    @Override
    public void onAttach(MainView v) {
        mainView = v;
    }

    @Override
    public void onDetach() {

    }
}
