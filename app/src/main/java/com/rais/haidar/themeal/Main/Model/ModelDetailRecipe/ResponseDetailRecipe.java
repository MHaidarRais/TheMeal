package com.rais.haidar.themeal.Main.Model.ModelDetailRecipe;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseDetailRecipe{

	@SerializedName("meals")
	private List<MealsItem> meals;

	public void setMeals(List<MealsItem> meals){
		this.meals = meals;
	}

	public List<MealsItem> getMeals(){
		return meals;
	}

	@Override
 	public String toString(){
		return 
			"ResponseDetailRecipe{" + 
			"meals = '" + meals + '\'' + 
			"}";
		}
}