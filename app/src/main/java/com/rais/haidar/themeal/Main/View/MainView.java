package com.rais.haidar.themeal.Main.View;

import com.rais.haidar.themeal.Base.BaseView;
import com.rais.haidar.themeal.Main.Model.ModelCategory.CategoriesItem;
import com.rais.haidar.themeal.Main.Model.ModelDetailRecipe.MealsItem;

import java.util.List;

public interface MainView extends BaseView {
    void onSuccessCategory(List<CategoriesItem> data);
    void onError(String msg);
    void onSuccessMeals(List<com.rais.haidar.themeal.Main.Model.ModelListCategory.MealsItem> mealsItems);
    void onDetailSuccess(List<MealsItem> dataDetail);

}
