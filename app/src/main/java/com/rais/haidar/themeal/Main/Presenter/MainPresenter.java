package com.rais.haidar.themeal.Main.Presenter;

import com.rais.haidar.themeal.Base.BasePresenter;
import com.rais.haidar.themeal.Main.Model.ModelCategory.CategoriesItem;
import com.rais.haidar.themeal.Main.Model.ModelCategory.ResponseCategory;
import com.rais.haidar.themeal.Main.View.MainView;
import com.rais.haidar.themeal.Network.configNetwork;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements BasePresenter<MainView> {

    public MainView mainView;

    public Call<ResponseCategory> call() {
        return configNetwork.getInstance().getCategory();
    }

    public void getData(){
        call().enqueue(new Callback<ResponseCategory>() {
            @Override
            public void onResponse(Call<ResponseCategory> call, Response<ResponseCategory> response) {
                if (response.isSuccessful()){
                    List<CategoriesItem> CategoriesItems = response.body().getCategories();
                    mainView.onSuccessCategory(CategoriesItems);
                } else {
                    mainView.onError("GAGAL mengambil data");
                }
            }

            @Override
            public void onFailure(Call<ResponseCategory> call, Throwable t) {
                mainView.onError(t.getMessage());
            }

        });
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
