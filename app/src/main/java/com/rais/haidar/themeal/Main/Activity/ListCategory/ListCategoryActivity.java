package com.rais.haidar.themeal.Main.Activity.ListCategory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.rais.haidar.themeal.Main.Model.ModelCategory.CategoriesItem;
import com.rais.haidar.themeal.Main.Model.ModelDetailRecipe.MealsItem;
import com.rais.haidar.themeal.Main.Presenter.ListCategoryPresenter;
import com.rais.haidar.themeal.Main.Presenter.MainPresenter;
import com.rais.haidar.themeal.Main.View.MainView;
import com.rais.haidar.themeal.R;

import java.util.List;

public class ListCategoryActivity extends AppCompatActivity implements MainView {

    private ListCategoryPresenter listCategoryPresenter;
    private String stringKategori;
    RecyclerView rcViewSesuai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_category_class);

        rcViewSesuai = findViewById(R.id.rcViewSesuai);

        listCategoryPresenter = new ListCategoryPresenter();
        stringKategori = getIntent().getStringExtra("stringKategori");
        onAttachView();
    }


    @Override
    public void onSuccessCategory(List<CategoriesItem> data) {
    }

    @Override
    public void onError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccessMeals(List<com.rais.haidar.themeal.Main.Model.ModelListCategory.MealsItem> mealsItems) {

        rcViewSesuai.setLayoutManager(new GridLayoutManager(this,2));
        rcViewSesuai.setAdapter(new ListCategoryAdapter(ListCategoryActivity.this,mealsItems));
    }

    @Override
    public void onDetailSuccess(List<MealsItem> dataDetail) {

    }

    @Override
    public void onAttachView() {
        listCategoryPresenter.onAttach(this);
        listCategoryPresenter.getData(stringKategori);
    }

    @Override
    public void onDetachView() {
    }
}
