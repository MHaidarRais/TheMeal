package com.rais.haidar.themeal.Main.Activity.DetailRecipe;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.rais.haidar.themeal.Main.Model.ModelCategory.CategoriesItem;
import com.rais.haidar.themeal.Main.Model.ModelListCategory.MealsItem;
import com.rais.haidar.themeal.Main.Presenter.DetailPresenter;
import com.rais.haidar.themeal.Main.View.MainView;
import com.rais.haidar.themeal.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ScrollingDetailActivity extends AppCompatActivity implements MainView {

    @BindView(R.id.imgDetail)
    ImageView imgDetail;
    @BindView(R.id.detailCategory)
    TextView detailCategory;
    @BindView(R.id.detailCountry)
    TextView detailCountry;
    @BindView(R.id.detailTags)
    TextView detailTags;
    @BindView(R.id.detailInstruction)
    TextView detailInstruction;
    @BindView(R.id.Ing1)
    TextView Ing1;
    @BindView(R.id.Ing2)
    TextView Ing2;
    @BindView(R.id.Ing3)
    TextView Ing3;
    @BindView(R.id.Ing4)
    TextView Ing4;
    @BindView(R.id.Ing5)
    TextView Ing5;
    @BindView(R.id.Ing6)
    TextView Ing6;
    @BindView(R.id.Ing7)
    TextView Ing7;
    @BindView(R.id.Ing8)
    TextView Ing8;
    @BindView(R.id.Ing9)
    TextView Ing9;
    @BindView(R.id.Ing10)
    TextView Ing10;
    @BindView(R.id.Ing11)
    TextView Ing11;
    @BindView(R.id.Ing12)
    TextView Ing12;
    @BindView(R.id.Ing13)
    TextView Ing13;
    @BindView(R.id.Ing14)
    TextView Ing14;
    @BindView(R.id.Ing15)
    TextView Ing15;
    @BindView(R.id.Ing16)
    TextView Ing16;
    @BindView(R.id.Ing17)
    TextView Ing17;
    @BindView(R.id.Ing18)
    TextView Ing18;
    @BindView(R.id.Ing19)
    TextView Ing19;
    @BindView(R.id.Ing20)
    TextView Ing20;
    @BindView(R.id.Mea1)
    TextView Mea1;
    @BindView(R.id.Mea2)
    TextView Mea2;
    @BindView(R.id.Mea3)
    TextView Mea3;
    @BindView(R.id.Mea4)
    TextView Mea4;
    @BindView(R.id.Mea5)
    TextView Mea5;
    @BindView(R.id.Mea6)
    TextView Mea6;
    @BindView(R.id.Mea7)
    TextView Mea7;
    @BindView(R.id.Mea8)
    TextView Mea8;
    @BindView(R.id.Mea9)
    TextView Mea9;
    @BindView(R.id.Mea10)
    TextView Mea10;
    @BindView(R.id.Mea11)
    TextView Mea11;
    @BindView(R.id.Mea12)
    TextView Mea12;
    @BindView(R.id.Mea13)
    TextView Mea13;
    @BindView(R.id.Mea14)
    TextView Mea14;
    @BindView(R.id.Mea15)
    TextView Mea15;
    @BindView(R.id.Mea16)
    TextView Mea16;
    @BindView(R.id.Mea17)
    TextView Mea17;
    @BindView(R.id.Mea18)
    TextView Mea18;
    @BindView(R.id.Mea19)
    TextView Mea19;
    @BindView(R.id.Mea20)
    TextView Mea20;


    List<com.rais.haidar.themeal.Main.Model.ModelDetailRecipe.MealsItem> mealsItemsDetail;

    private DetailPresenter detailPresenter;
    private String idMakanan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling_detail);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        detailPresenter = new DetailPresenter();
        idMakanan = getIntent().getStringExtra("idMakanan");
        onAttachView();

    }

    @Override
    public void onSuccessCategory(List<CategoriesItem> data) {
    }

    @Override
    public void onSuccessMeals(List<MealsItem> mealsItems) {

    }


    @Override
    public void onError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDetailSuccess(List<com.rais.haidar.themeal.Main.Model.ModelDetailRecipe.MealsItem> dataDetail) {
        mealsItemsDetail = dataDetail;

//        detailCategory.setText();
        int i = 0;

        CollapsingToolbarLayout toolbarLayout = findViewById(R.id.toolbar_layout);
        toolbarLayout.setTitle(mealsItemsDetail.get(i).getStrMeal());

        detailCategory.setText(mealsItemsDetail.get(i).getStrCategory());
        detailCountry.setText(mealsItemsDetail.get(i).getStrArea());
        detailInstruction.setText(mealsItemsDetail.get(i).getStrInstructions());
        detailTags.setText(mealsItemsDetail.get(i).getStrTags());
        Glide.with(this)
                .load(mealsItemsDetail.get(i).getStrMealThumb())
                .into(imgDetail);


        Ing1.setText(mealsItemsDetail.get(i).getStrIngredient1());
        Ing2.setText(mealsItemsDetail.get(i).getStrIngredient2());
        Ing3.setText(mealsItemsDetail.get(i).getStrIngredient3());
        Ing4.setText(mealsItemsDetail.get(i).getStrIngredient4());
        Ing5.setText(mealsItemsDetail.get(i).getStrIngredient5());
        Ing6.setText(mealsItemsDetail.get(i).getStrIngredient6());
        Ing7.setText(mealsItemsDetail.get(i).getStrIngredient7());
        Ing8.setText(mealsItemsDetail.get(i).getStrIngredient8());
        Ing9.setText(mealsItemsDetail.get(i).getStrIngredient9());
        Ing10.setText(mealsItemsDetail.get(i).getStrIngredient10());
        Ing11.setText(mealsItemsDetail.get(i).getStrIngredient11());
        Ing12.setText(mealsItemsDetail.get(i).getStrIngredient12());
        Ing13.setText(mealsItemsDetail.get(i).getStrIngredient13());
        Ing14.setText(mealsItemsDetail.get(i).getStrIngredient14());
        Ing15.setText(mealsItemsDetail.get(i).getStrIngredient15());
        Ing16.setText(mealsItemsDetail.get(i).getStrIngredient16());
        Ing17.setText(mealsItemsDetail.get(i).getStrIngredient17());
        Ing18.setText(mealsItemsDetail.get(i).getStrIngredient18());
        Ing19.setText(mealsItemsDetail.get(i).getStrIngredient19());
        Ing20.setText(mealsItemsDetail.get(i).getStrIngredient20());


        Mea1.setText(mealsItemsDetail.get(i).getStrMeasure1());
        Mea2.setText(mealsItemsDetail.get(i).getStrMeasure2());
        Mea3.setText(mealsItemsDetail.get(i).getStrMeasure3());
        Mea4.setText(mealsItemsDetail.get(i).getStrMeasure4());
        Mea5.setText(mealsItemsDetail.get(i).getStrMeasure5());
        Mea6.setText(mealsItemsDetail.get(i).getStrMeasure6());
        Mea7.setText(mealsItemsDetail.get(i).getStrMeasure7());
        Mea8.setText(mealsItemsDetail.get(i).getStrMeasure8());
        Mea9.setText(mealsItemsDetail.get(i).getStrMeasure9());
        Mea10.setText(mealsItemsDetail.get(i).getStrMeasure10());
        Mea11.setText(mealsItemsDetail.get(i).getStrMeasure11());
        Mea12.setText(mealsItemsDetail.get(i).getStrMeasure12());
        Mea13.setText(mealsItemsDetail.get(i).getStrMeasure13());
        Mea14.setText(mealsItemsDetail.get(i).getStrMeasure14());
        Mea15.setText(mealsItemsDetail.get(i).getStrMeasure15());
        Mea16.setText(mealsItemsDetail.get(i).getStrMeasure16());
        Mea17.setText(mealsItemsDetail.get(i).getStrMeasure17());
        Mea18.setText(mealsItemsDetail.get(i).getStrMeasure18());
        Mea19.setText(mealsItemsDetail.get(i).getStrMeasure19());
        Mea20.setText(mealsItemsDetail.get(i).getStrMeasure20());
    }

    @Override
    public void onAttachView() {

        detailPresenter.onAttach(this);
        detailPresenter.getData(idMakanan);

    }

    @Override
    public void onDetachView() {

    }
}
