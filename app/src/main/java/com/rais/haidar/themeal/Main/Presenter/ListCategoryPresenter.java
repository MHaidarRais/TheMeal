package com.rais.haidar.themeal.Main.Presenter;

import com.rais.haidar.themeal.Base.BasePresenter;
import com.rais.haidar.themeal.Main.Model.ModelCategory.CategoriesItem;
import com.rais.haidar.themeal.Main.Model.ModelCategory.ResponseCategory;
import com.rais.haidar.themeal.Main.Model.ModelListCategory.MealsItem;
import com.rais.haidar.themeal.Main.Model.ModelListCategory.ResponseListCategory;
import com.rais.haidar.themeal.Main.View.MainView;
import com.rais.haidar.themeal.Network.configNetwork;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListCategoryPresenter implements BasePresenter<MainView> {

    public MainView mainView;
    public String namaKategori;


    public void getData (String category){
        namaKategori = category;
        call().enqueue(new Callback<ResponseListCategory>() {
            @Override
            public void onResponse(Call<ResponseListCategory> call, Response<ResponseListCategory> response) {
                if (response.isSuccessful()){
                    List<MealsItem> mealsItems = response.body().getMeals();
                    mainView.onSuccessMeals(mealsItems);
                } else {
                    mainView.onError("GAGAL mengambil data");
                }
            }

            @Override
            public void onFailure(Call<ResponseListCategory> call, Throwable t) {
                mainView.onError(t.getMessage());
            }
        });
    }

    public Call<ResponseListCategory> call() {
        return configNetwork.getInstance().getListCategory(namaKategori);
    }

    @Override
    public void onAttach(MainView v) {
        mainView = v;
    }

    @Override
    public void onDetach() {
        mainView = null;
    }
}
