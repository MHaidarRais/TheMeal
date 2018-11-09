package com.rais.haidar.themeal.Main.Activity.Main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.rais.haidar.themeal.Main.Model.ModelCategory.CategoriesItem;
import com.rais.haidar.themeal.Main.Model.ModelDetailRecipe.MealsItem;
import com.rais.haidar.themeal.Main.Presenter.MainPresenter;
import com.rais.haidar.themeal.Main.View.MainView;
import com.rais.haidar.themeal.R;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView {

    private MainPresenter mainPresenter;
    RecyclerView rcViewCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcViewCategory = findViewById(R.id.rcViewCategory);
        mainPresenter = new MainPresenter();
        onAttachView();

    }


    @Override
    public void onSuccessCategory(List<CategoriesItem> data) {
        rcViewCategory.setLayoutManager(new LinearLayoutManager(this));
        rcViewCategory.setAdapter(new MainAdapter(MainActivity.this,data));
    }

    @Override
    public void onError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccessMeals(List<com.rais.haidar.themeal.Main.Model.ModelListCategory.MealsItem> mealsItems) {

    }

    @Override
    public void onDetailSuccess(List<MealsItem> dataDetail) {

    }

    @Override
    public void onAttachView() {
        mainPresenter.onAttach(this);
        mainPresenter.getData();

    }

    @Override
    public void onDetachView() {

    }
}
